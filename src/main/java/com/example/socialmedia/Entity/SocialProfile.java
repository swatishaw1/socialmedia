package com.example.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private SocialUser user;
    private String description;
    public void setUser(SocialUser user){
        this.user = user;
        if (user != null && user.getProfile() != this) {
            user.setProfile(this);
        }
    }
}
