package application.controllers;

import application.testConfigs.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
class StaticControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHomePage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assertTrue(content.contains("href=\"/form\""));
        assertFalse(content.contains("data-th-href"));
    }


    @Test
    void getInvalidPage() throws Exception {
        mockMvc.perform(get("/nem-létező"))
                .andExpect(
                        status().is(404)
                )
                .andReturn();
    }

    @Test
    void checkGameWithoutLogin() throws Exception {
        mockMvc.perform(get("/game"))
                .andExpect(
                        status().is(403)
                )
                .andReturn();
    }

    @WithMockUser("user")
    @Test
    void checkGameWithUser() throws Exception {
        mockMvc.perform(get("/game"))
                .andExpect(
                        status().is(403)
                )
                .andReturn();
    }


    @Test
    @WithMockUser("admin")
    void checkGameWithAdmin() throws Exception {
        mockMvc.perform(get("/game"))
                .andExpect(
                        status().isOk()
                )
                .andReturn();
    }
}