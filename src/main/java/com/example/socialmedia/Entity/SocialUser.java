package com.example.socialmedia.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user", cascade ={CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.MERGE})
    private SocialProfile profile;
    @OneToMany(mappedBy = "users",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();
    //StackOverflow Occurs

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    //For maintaining bidirectional relation
    public void setProfile(SocialProfile profile){
        this.profile = profile;
        if (profile != null && profile.getUser() != this) {
            profile.setUser(this);
        }
    }
}
