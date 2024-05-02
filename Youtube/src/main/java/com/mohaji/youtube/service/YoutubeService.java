package com.mohaji.youtube.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Value;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@Service
public class YoutubeService {

    @Value("${youtube.api.key}")
    private String apiKey;

    public List<Video> getPopularVideos() throws IOException, GeneralSecurityException {
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName("Youtube API Client")
                .build();

        YouTube.Videos.List request = youtube.videos().list(Collections.singletonList("snippet"));
        request.setKey(apiKey);
        request.setChart("mostPopular");
        request.setMaxResults(10L);

        VideoListResponse response = request.execute();
        return response.getItems();
    }
}