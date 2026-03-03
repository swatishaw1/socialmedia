package com.example.socialmedia.Repository;


import com.example.socialmedia.Entity.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser,Long> {
}
