package com.springbootlearning.learningspringboot3.ch2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;


@Service
public class VideoService {

  private final VideoRepository repository;

  public VideoService(VideoRepository repository) {
    this.repository = repository;
  }

  private List<Video> videos = List.of( //
    new Video("Need HELP with your SPRING BOOT 3 App?"), //
    new Video("Don't do THIS to your own CODE!"), //
    new Video("SECRETS to fix BROKEN CODE!"));

  public List<Video> getVideos() {
    return videos;
  }

  public Video create(Video newVideo) {
    List<Video> extend = new ArrayList<>(videos);
    extend.add(newVideo);
    this.videos = List.copyOf(extend);
    return newVideo;
  }

  public List<VideoEntity> search(VideoSearch videoSearch) {
    if (StringUtils.hasText(videoSearch.name()) //
      && StringUtils.hasText(videoSearch.description())) {
        return repository //
          .findByNameContainsOrDescriptionContainsAllIgnoreCase( //
            videoSearch.name(), videoSearch.description());          
      }

    if (StringUtils.hasText(videoSearch.name())) {
      return repository.findByNameContainsIgnoreCase(videoSearch.name());
    }

    if (StringUtils.hasText(videoSearch.description())) {
      return repository.findByDescriptionContainsIgnoreCase(videoSearch.description());
    }

    return Collections.emptyList();
}
}