package com.springbootlearning.learningspringboot3.ch2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    
    UserAccount findByUsername(String username);
}
