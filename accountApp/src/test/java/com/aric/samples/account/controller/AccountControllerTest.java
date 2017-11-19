package com.aric.samples.account.controller;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testAccountRequest() throws Exception {    	
        this.mockMvc.perform(get("/query")).andExpect(status().isOk()).andExpect(content().string(containsString("query method is working")));
	
    }
    
    public void testDepositRequest() throws Exception {    	
        this.mockMvc.perform(get("/deposit")).andExpect(status().isOk()).andExpect(content().string(containsString("deposit method working")));
	
    }
    public void testEftRequest() throws Exception {    	
        this.mockMvc.perform(get("/eft")).andExpect(status().isOk()).andExpect(content().string(containsString("eft method working")));
	
    }
    
    //çağıırlan metodlar için ... mewthod working mesajı üretir. test bu şekilde kontrole ediliyor
    
    
    
}