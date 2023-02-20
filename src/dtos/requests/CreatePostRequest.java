package dtos.requests;

import java.time.LocalDateTime;

public class CreatePostRequest {
    private String title;
    private String body;
    private LocalDateTime timeStamp = LocalDateTime.now();

}
