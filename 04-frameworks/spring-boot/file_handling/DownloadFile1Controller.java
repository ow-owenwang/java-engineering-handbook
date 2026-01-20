package org.example.springexamples.file_handling;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class DownloadFile1Controller {

    private final WebClient webClient = WebClient.create();

    @GetMapping("/download1")
    public Mono<ResponseEntity<byte[]>> downloadFile(@RequestParam String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(DataBuffer.class)
                .map(dataBuffer -> {
                    byte[] fileBytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(fileBytes);

                    // 从URL提取文件名
                    String fileName = url.substring(url.lastIndexOf('/') + 1);

                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    headers.setContentDispositionFormData("attachment", fileName);

                    return ResponseEntity.ok()
                            .headers(headers)
                            .body(fileBytes);
                });
    }
}