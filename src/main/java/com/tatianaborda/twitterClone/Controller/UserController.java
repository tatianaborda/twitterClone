package com.tatianaborda.twitterClone.Controller;

import com.tatianaborda.twitterClone.Model.Tweet;
import com.tatianaborda.twitterClone.Model.User;
import com.tatianaborda.twitterClone.Service.TweetService;
import com.tatianaborda.twitterClone.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TweetService tweetService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User with ID " + userId + " deleted successfully");
    }

    @PostMapping("/{followerId}/follow/{followeeId}")
    public ResponseEntity<String> followUser(@PathVariable Long followerId, @PathVariable Long followeeId) {
        userService.followUser(followerId, followeeId);
        return ResponseEntity.ok("User " + followerId + " followed user " + followeeId);
    }

    @GetMapping("/{userId}/timeline")
    public List<Tweet> getUserTimeline(@PathVariable Long userId) {
        List<Long> followeeIds = userService.getFolloweeIdsByFollowerId(userId); // get ids of followees
        followeeIds.add(userId);// Add userId to include tweets from the user requesting
        return tweetService.getTimelineByUserIds(followeeIds);
    }
}
