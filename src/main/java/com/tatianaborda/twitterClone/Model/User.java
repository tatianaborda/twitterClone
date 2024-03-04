package com.tatianaborda.twitterClone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(schema = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @NotBlank
    @Size(max = 20)
    @Column
    private String userName;
    @JsonIgnore
    private String password;
    private String bio;
    private String profileImg;

    @JsonIgnore
    @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL)
    private List<UserFollow> followers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<UserFollow> following = new ArrayList<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public List<UserFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserFollow> followers) {
        this.followers = followers;
    }

    public List<UserFollow> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserFollow> following) {
        this.following = following;
    }
}
