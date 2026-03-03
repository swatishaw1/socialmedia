package com.example.socialmedia.Service;
import com.example.socialmedia.Entity.SocialGroup;
import com.example.socialmedia.Entity.SocialProfile;
import com.example.socialmedia.Entity.SocialUser;
import com.example.socialmedia.Repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllSocialUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser createNewSocialUser(SocialUser socialUser) {
        if (socialUser.getId() != null && socialUserRepository.existsById(socialUser.getId())) {
            SocialUser existingUser = socialUserRepository
                    .findById(socialUser.getId())
                    .orElseThrow();
            existingUser.setProfile(socialUser.getProfile());
            if(existingUser.getGroups()!=null) {
                existingUser.getGroups().addAll(existingUser.getGroups());
            }
            if (socialUser.getGroups()!=null) {
                existingUser.getGroups().addAll(socialUser.getGroups());
            }
            return socialUserRepository.save(existingUser);
        }
        socialUser.setId(null); // force insert
        socialUser.getProfile().setId(null);
        socialUser.setProfile(socialUser.getProfile());
        return socialUserRepository.save(socialUser);
    }
    public SocialUser deleteSocialUser(Long id) {
        SocialUser socialUser = socialUserRepository.findById(id).orElseThrow(() -> new RuntimeException("Social User Not Found") );
        socialUserRepository.deleteById(id);
        return socialUser;
    }
}