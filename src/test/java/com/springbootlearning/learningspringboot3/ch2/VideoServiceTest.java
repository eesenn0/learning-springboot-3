package com.springbootlearning.learningspringboot3.ch2;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class VideoServiceTest {

    VideoService service;

    @Mock
    VideoRepository repository;

    @BeforeEach
    void setUp() {
        this.service = new VideoService(repository);
    }

    @Test
    void getVideosShouldReturnAll() {
        // given
        VideoEntity video1 = new VideoEntity("alice", "Spring Boot 3 Intro", "Learn the basics!");
        VideoEntity video2 = new VideoEntity("alice", "Spring Boot 3 Deep Dive", "Go deep!");

        when(repository.findAll()).thenReturn(List.of(video1, video2));

        // when
        List<VideoEntity> videos = service.getVideos();

        // then
        assertThat(videos).containsExactly(video1, video2);
    }
}
