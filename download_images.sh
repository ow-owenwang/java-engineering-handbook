#!/bin/bash
# 下载 markdown 文件中的在线图片到本地 assets 目录

process_file() {
    local md_file="$1"
    local md_dir=$(dirname "$md_file")
    local assets_dir="${md_dir}/assets"
    
    # 创建 assets 目录
    mkdir -p "$assets_dir"
    
    # 提取所有图片 URL 并下载
    grep '!\[.*\](http' "$md_file" | while IFS= read -r line; do
        # 提取 URL (使用 sed)
        url=$(echo "$line" | sed -n 's/.*!\[.*\](\(https\?:\/\/[^)]*\).*/\1/p')
        
        if [ -n "$url" ]; then
            # 从 URL 提取文件名
            filename=$(basename "$url" | cut -d'?' -f1)
            
            # 如果没有扩展名，尝试从 URL 判断
            if [[ ! "$filename" =~ \.(png|jpg|jpeg|gif|svg|webp)$ ]]; then
                if [[ "$url" =~ \.png ]]; then
                    filename="${filename}.png"
                elif [[ "$url" =~ \.jpg ]] || [[ "$url" =~ \.jpeg ]]; then
                    filename="${filename}.jpg"
                elif [[ "$url" =~ \.gif ]]; then
                    filename="${filename}.gif"
                else
                    filename="${filename}.png"
                fi
            fi
            
            local_file="${assets_dir}/${filename}"
            relative_path="assets/${filename}"
            
            # 下载图片（如果不存在）
            if [ ! -f "$local_file" ]; then
                echo "  下载: $url"
                if curl -k -L -s "$url" -o "$local_file" && [ -f "$local_file" ] && [ -s "$local_file" ]; then
                    size=$(stat -f%z "$local_file" 2>/dev/null || stat -c%s "$local_file" 2>/dev/null)
                    echo "  ✓ 下载成功 (${size} bytes)"
                else
                    echo "  ✗ 下载失败"
                    rm -f "$local_file" 2>/dev/null
                    continue
                fi
            else
                echo "  已存在: $relative_path"
            fi
            
            # 更新 markdown 中的图片路径
            # 转义特殊字符用于 sed
            escaped_url=$(echo "$url" | sed 's/[[\.*^$()+?{|]/\\&/g')
            sed -i '' "s|!\[\([^\]]*\)\]($escaped_url)|![\1]($relative_path)|g" "$md_file"
        fi
    done
}

# 处理所有包含在线图片的 markdown 文件
find . -name "*.md" -exec grep -l "!\[.*\](http" {} \; | while read -r md_file; do
    echo "处理文件: $md_file"
    process_file "$md_file"
    echo ""
done

echo "完成！"
