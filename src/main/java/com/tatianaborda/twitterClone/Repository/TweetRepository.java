package com.tatianaborda.twitterClone.Repository;


import com.tatianaborda.twitterClone.Model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByCreatedByUserId(Long userId);
    List<Tweet> findByCreatedByUserIdInOrderByPostTimeDesc(List<Long> userIds);

}
