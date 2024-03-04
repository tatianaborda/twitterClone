package com.tatianaborda.twitterClone.Service;

import com.tatianaborda.twitterClone.Model.Tweet;
import com.tatianaborda.twitterClone.Model.User;
import com.tatianaborda.twitterClone.Model.UserFollow;
import com.tatianaborda.twitterClone.Repository.TweetRepository;
import com.tatianaborda.twitterClone.Repository.UserFollowRepository;
import com.tatianaborda.twitterClone.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserFollowRepository userFollowRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ("User not found with id: " + userId)));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long userId) {
        List<Tweet> tweetsToDelete = tweetRepository.findByCreatedByUserId(userId); //Delete all user's tweets
        tweetRepository.deleteAll(tweetsToDelete);
        userRepository.deleteById(userId); // Delete the user
    }

    public void followUser(Long followerId, Long followeeId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new EntityNotFoundException("Follower not found with id: " + followerId));

        User followee = userRepository.findById(followeeId)
                .orElseThrow(() -> new EntityNotFoundException("Followee not found with id: " + followeeId));
        UserFollow userFollow = new UserFollow();
        userFollow.setFollower(follower);
        userFollow.setFollowee(followee);
        userFollowRepository.save(userFollow);
    }

    public List<Tweet> getTimeline(Long userId) {
        List<Long> followedUserIds = userFollowRepository.findFolloweeIdsByFollowerId(userId);
        List<Tweet> timelineTweets = tweetRepository.findByCreatedByUserIdInOrderByPostTimeDesc(followedUserIds);

        return timelineTweets;
    }

    public List<Long> getFolloweeIdsByFollowerId(Long followerId) {
        return userFollowRepository.findFolloweeIdsByFollowerId(followerId);
    }
}