package com.example.socialmedia.Repository;

import com.example.socialmedia.Entity.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepository extends JpaRepository<SocialProfile,Long> {
}
