package com.tatianaborda.twitterClone.Controller;

import com.tatianaborda.twitterClone.Model.Tweet;
import com.tatianaborda.twitterClone.Repository.TweetRepository;
import com.tatianaborda.twitterClone.Repository.UserRepository;
import com.tatianaborda.twitterClone.Service.TweetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TweetController.class)
public class TweetControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TweetService tweetService;

    @MockBean
    private TweetRepository tweetRepository;

    @MockBean
    private UserRepository userRepository;
    @Test
    public void testGetTweetsByUserId_Success() throws Exception {
        Long userId = 1L;
        List<Tweet> expectedTweets = new ArrayList<>();
        when(tweetService.getTweetsByUserId(userId)).thenReturn(expectedTweets);
        mockMvc.perform(MockMvcRequestBuilders.get("/tweets/user/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetTweetsByUserId_UserNotFound() throws Exception {
        Long userId = 1L;
        when(tweetService.getTweetsByUserId(userId)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        mockMvc.perform(MockMvcRequestBuilders.get("/tweets/user/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
