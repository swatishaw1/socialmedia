package com.example.socialmedia;

import com.example.socialmedia.Entity.Post;
import com.example.socialmedia.Entity.SocialGroup;
import com.example.socialmedia.Entity.SocialProfile;
import com.example.socialmedia.Entity.SocialUser;
import com.example.socialmedia.Repository.PostRepository;
import com.example.socialmedia.Repository.SocialGroupRepository;
import com.example.socialmedia.Repository.SocialProfileRepository;
import com.example.socialmedia.Repository.SocialUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final SocialGroupRepository groupRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final PostRepository postRepository;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
        SocialUser user1 = new SocialUser();
        SocialUser user2 = new SocialUser();
        SocialUser user3 = new SocialUser();

        // Save users to the database
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Create some groups
        SocialGroup group1 = new SocialGroup();
        SocialGroup group2 = new SocialGroup();

        // Add users to groups
        group1.getUsers().add(user1);
        group1.getUsers().add(user2);

        group2.getUsers().add(user2);
        group2.getUsers().add(user3);

        // Save groups to the database
        groupRepository.save(group1);
        groupRepository.save(group2);

        // Associate users with groups
        user1.getGroups().add(group1);
        user2.getGroups().add(group1);
        user2.getGroups().add(group2);
        user3.getGroups().add(group2);

        // Save users back to database to update associations
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


        // Create some posts
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();

        // Associate posts with users
        post1.setUsers(user1);
        post2.setUsers(user2);
        post3.setUsers(user3);

        // Save posts to the database (assuming you have a PostRepository)
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        // Create some social profiles
        SocialProfile profile1 = new SocialProfile();
        SocialProfile profile2 = new SocialProfile();
        SocialProfile profile3 = new SocialProfile();

        // Associate profiles with users
        profile1.setUser(user1);
        profile2.setUser(user2);
        profile3.setUser(user3);

        // Save profiles to the database (assuming you have a SocialProfileRepository)
        socialProfileRepository.save(profile1);
        socialProfileRepository.save(profile2);
        socialProfileRepository.save(profile3);

        //Fetch Types
            System.out.println("FETCHING SOCIAL USER: ");
            userRepository.findById(1L);
        };
    }
}
