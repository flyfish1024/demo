package com.example.demo.com.flyfish.day1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class HelloWorldControllerTest {

    /*private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    }

    @Test
    public void getHello() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/hello1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
    .andExpect(content().string(equalTo("Hello World")));
    }

    @Test
    public void getHello2() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/hello2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
    .andExpect(content().string(equalTo("[\"A\",\"B\",\"C\"]")));
    }*/

}
