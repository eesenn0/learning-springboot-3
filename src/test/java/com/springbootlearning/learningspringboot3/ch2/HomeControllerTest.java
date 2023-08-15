package com.springbootlearning.learningspringboot3.ch2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VideoService videoService;

    @Test
    @WithMockUser
    public void indexPageHasSeveralHtmlForms() throws Exception {
        String html = mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Username: user")))
                .andExpect(content().string(containsString("Authorities: [ROLE_USER]")))
                .andReturn()
                .getResponse().getContentAsString();

        assertThat(html).contains("<form action=\"/logout\"", "<form action=\"/search\"",
                "<form action=\"/new-video\"");
    }
}
