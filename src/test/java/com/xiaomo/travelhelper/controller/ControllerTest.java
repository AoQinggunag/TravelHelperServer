package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.TravelHelperServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value = false)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void register() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("account","12345")
                .param("password","12345")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void listFriends() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/friend/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("account","13113288564")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void likeByAccountOrUsername() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/friend/likeByAccountOrUsername")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("val","莫")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void addFriend() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/friend/addFriend")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("account","13425377247")
                .param("targetAccount","13660996067")
                .param("desc","我是莫家乐")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void listMsgFriend() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/msg/friend")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("account","13660996067")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void agreeFriend() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/friend/agreeFriend")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("account","13660996067")
                .param("targetAccount","13425377247")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void send() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/share/send")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("account","13660996067")
                .param("content","哈哈哈哈，这是我的朋友圈")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

    @Test
    public void list() throws Exception {

        String json = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/share/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(json);

    }

}