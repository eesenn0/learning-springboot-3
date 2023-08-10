package com.springbootlearning.learningspringboot3.ch2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface VideoRepository extends JpaRepository <VideoEntity, Long> {
    
    List<VideoEntity> findByNameContainsIgnoreCase(String partialName);

    List<VideoEntity> findByDescriptionContainsIgnoreCase(String partialDescription);

    List<VideoEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String partialName, 
        String partialDescription);

    @PreAuthorize("#entity.username == authentication.name")
    @Override
    void delete(VideoEntity entity);
}
