package com.example.youtube.controller;


import com.example.youtube.service.YoutubeService;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/youtube")
@RestController
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;

    @GetMapping("/popular-videos")
    public List<Video> getPopularVideos() throws IOException, GeneralSecurityException {
        return youtubeService.getPopularVideos();
    }
}
