package org.example.springexamples.file_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.URLConnection;

@RestController
@RequestMapping("/api")
public class DownloadFileController {

    private static final Logger log = LoggerFactory.getLogger(DownloadFileController.class);

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String url) throws Exception {
        // 使用 RestTemplate 发送请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.exchange(
                url, HttpMethod.GET, null, byte[].class);
        log.info("Download file url:{}", url);
        if (response.getStatusCode() == HttpStatus.OK) {
            byte[] fileBytes = response.getBody();

            // 自动推断文件类型
            String contentType = URLConnection.guessContentTypeFromStream(
                    response.getBody() != null ? new java.io.ByteArrayInputStream(fileBytes) : null
            );
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            // 从URL提取文件名
            String fileName = url.substring(url.lastIndexOf('/') + 1);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentDispositionFormData("attachment", fileName);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileBytes);
        }

        return ResponseEntity.status(404).body(null);
    }
}

