package com.tatianaborda.twitterClone.Repository;

import com.tatianaborda.twitterClone.Model.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow, Long> {
    @Query("SELECT uf.followee.userId FROM UserFollow uf WHERE uf.follower.userId = :followerId")
    List<Long> findFolloweeIdsByFollowerId(@Param("followerId") Long followerId);
}
