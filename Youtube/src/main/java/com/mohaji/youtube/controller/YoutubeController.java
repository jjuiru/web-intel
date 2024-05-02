package com.mohaji.youtube.controller;



import com.google.api.services.youtube.model.Video;
import com.mohaji.youtube.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;

    @GetMapping("/popular-videos")
    public List<Video> getPopularVideos() throws IOException, GeneralSecurityException {
        return youtubeService.getPopularVideos();
    }
}