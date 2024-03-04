package com.tatianaborda.twitterClone.Repository;

import com.tatianaborda.twitterClone.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
