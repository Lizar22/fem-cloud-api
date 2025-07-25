package femcloudapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("mysql")
@AutoConfigureMockMvc
public class QuoteControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET /quotes should return all quotes")
    void getAllQuotes_returnsListOfQuotes() throws Exception {
        mockMvc.perform(get("/quotes").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].text").value("Education is the path to freedom"))
                .andExpect(jsonPath("$[1].author").value("Angela Davies"));
    }

    @Test
    @DisplayName("DELETE /quotes/{id} should return 404 Not Found if quote to delete does not exist")
    void deleteQuote_ReturnsNotFound_WhenIdDoesNotExist() throws Exception {
        Long nonExistentId = 99L;

        mockMvc.perform(delete("/quotes/" + nonExistentId))
                .andExpect(status().isNotFound());
    }
}