package com.tatianaborda.twitterClone.Service;
import com.tatianaborda.twitterClone.Model.Tweet;
import com.tatianaborda.twitterClone.Repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public Tweet postTweet(Tweet tweet) {
        return tweetRepository.save(tweet); // save new tweet into db
    }

    public List<Tweet> getTweetsByUserId(Long userId) {
        return tweetRepository.findByCreatedByUserId(userId);// get tweets by an specific user
    }

    public void deleteTweetById(Long tweetId) {
        tweetRepository.deleteById(tweetId);
    }

    public List<Tweet> getTimelineByUserIds(List<Long> userIds) {
        return tweetRepository.findByCreatedByUserIdInOrderByPostTimeDesc(userIds);
    }

}