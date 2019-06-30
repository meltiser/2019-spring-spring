package com.epam.mvc.controller;

import com.epam.mvc.config.AppConfig;
import com.epam.mvc.config.SecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class AppIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webAppContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void filterTest() throws Exception {
        mockMvc.perform(get("/users?teapot=true"))
                .andExpect(status().isIAmATeapot());
    }

    @Test
    public void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserTest() throws Exception {
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserNotFoundTest() throws Exception {
        mockMvc.perform(get("/user/243"))
                .andExpect(status().isNotFound());
    }
}