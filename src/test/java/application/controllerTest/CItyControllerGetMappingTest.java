package application.controllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CItyControllerGetMappingTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String allContent = "[{\"id\":1,\"name\":\"New York\",\"advices\":[{\"id\":1,\"content\":\"Go to Central Park\"},{\"id\":2,\"content\":\"Go to Central Moll\"}]}," +
            "{\"id\":2,\"name\":\"San Francisco\",\"advices\":[{\"id\":3,\"content\":\"Go to Selicon Valley\"},{\"id\":4,\"content\":\"Not go to the ghetto\"}]}," +
            "{\"id\":3,\"name\":\"Washington\",\"advices\":[{\"id\":5,\"content\":\"Go to Central Library\"}]}]";

    private static final String cityByNameContent = "{\"id\":1,\"name\":\"New York\",\"advices\":[{\"id\":1,\"content\":\"Go to Central Park\"},{\"id\":2,\"content\":\"Go to Central Moll\"}]}";

    private static final String allAdvicesByCityName = "[{\"id\":1,\"content\":\"Go to Central Park\"},{\"id\":2,\"content\":\"Go to Central Moll\"}]";

    @Test
    public void getAllCitiesTest() throws Exception {
        mockMvc.perform(get("/cities"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(allContent));

    }

    @Test
    public void findByNameTest() throws Exception {
        mockMvc.perform(get("/city/New York"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(cityByNameContent));
    }

    @Test
    public void getAllAdvicesByCityName() throws Exception {
        mockMvc.perform(get("/advice/New York"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(allAdvicesByCityName));
    }
}
