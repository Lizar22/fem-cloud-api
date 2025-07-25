package femcloudapi;

import femcloudapi.models.Quote;
import femcloudapi.repositories.QuoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class QuoteControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    QuoteRepository quoteRepository;

    @BeforeEach
    void setup() {
        quoteRepository.deleteAll();

        Quote quote1 = new Quote("Education is the path to freedom", "Aspasia of Miletus", "circa 430 BC");
        Quote quote2 = new Quote("I am not free while any woman is unfree, even when her shackles are very different from my own.", "Audre Lorde", "1981");
        Quote quote3 = new Quote("We realize the importance of our voice when we are silenced.", "Malala Yousafzai", "2013");
        Quote quote4 = new Quote("Feminism is for everybody.", "bell hooks", "2000");

        quoteRepository.saveAll(List.of(quote1, quote2, quote3, quote4));
    }

    @Test
    @DisplayName("GET /quotes should return all quotes")
    void getAllQuotes_returnsListOfQuotes() throws Exception {
        mockMvc.perform(get("/quotes")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$[0].text").value("Education is the path to freedom"))
                .andExpect(jsonPath("$[0].author").value("Aspasia of Miletus"))
                .andExpect(jsonPath("$[0].year").value("circa 430 BC"))
                .andExpect(jsonPath("$[1].text").value("I am not free while any woman is unfree, even when her shackles are very different from my own."))
                .andExpect(jsonPath("$[1].author").value("Audre Lorde"))
                .andExpect(jsonPath("$[1].year").value("1981"))
                .andExpect(jsonPath("$[2].text").value("We realize the importance of our voice when we are silenced."))
                .andExpect(jsonPath("$[2].author").value("Malala Yousafzai"))
                .andExpect(jsonPath("$[2].year").value("2013"))
                .andExpect(jsonPath("$[3].text").value("Feminism is for everybody."))
                .andExpect(jsonPath("$[3].author").value("bell hooks"))
                .andExpect(jsonPath("$[3].year").value("2000"));
    }

    @Test
    @DisplayName("DELETE /quotes/{id} should return 404 Not Found if quote to delete does not exist")
    void deleteQuote_ReturnsNotFound_WhenIdDoesNotExist() throws Exception {
        Long nonExistentId = 99L;

        mockMvc.perform(delete("/quotes/" + nonExistentId))
                .andExpect(status().isNotFound());
    }
}