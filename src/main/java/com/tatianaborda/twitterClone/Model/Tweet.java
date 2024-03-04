package com.tatianaborda.twitterClone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(schema = "Tweets")
public class Tweet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tweetId;
    private LocalDateTime postTime;
    @NotBlank
    @Size(max = 280)
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
