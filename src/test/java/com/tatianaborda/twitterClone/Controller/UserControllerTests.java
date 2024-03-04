package com.tatianaborda.twitterClone.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tatianaborda.twitterClone.Model.User;
import com.tatianaborda.twitterClone.Service.TweetService;
import com.tatianaborda.twitterClone.Service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private TweetService tweetService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testCreateUser() throws Exception {
        User newUser = new User();
        newUser.setUserName("salvatore");
        Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(newUser);
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName", Matchers.is("salvatore")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFollowUser() throws Exception {
        Long followerId = 1L;
        Long followeeId = 2L;

        mockMvc.perform(post("/users/{followerId}/follow/{followeeId}", followerId, followeeId))
                .andExpect(status().isOk());

        verify(userService, times(1)).followUser(followerId, followeeId);
    }
}
