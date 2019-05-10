package com.github.fish56.freemarker.controller;

import com.github.fish56.freemarker.FreemarkerImlApplicationTests;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.*;

public class RootControllerTest extends FreemarkerImlApplicationTests {

    @Test
    public void index() throws Exception{

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void list() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/list");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void ifElse() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/if-else");
        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print());

        builder = MockMvcRequestBuilders.get("/if-else")
                .param("token", "123456");
        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print());
    }
}