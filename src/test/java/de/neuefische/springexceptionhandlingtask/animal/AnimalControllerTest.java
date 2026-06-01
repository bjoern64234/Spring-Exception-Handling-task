package de.neuefische.springexceptionhandlingtask.animal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AnimalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAnimalSpecies_shouldReturnSpeciesName_WhenDogIsGiven() throws Exception {
        mockMvc.perform(get("/api/animals/dog"))
                .andExpect(status().isOk())
                .andExpect(content().string("dog"));
    }

    @Test
    void getAnimalSpecies_shouldReturnForbidden_WhenSpeciesIsNoDog() throws Exception {
        mockMvc.perform(get("/api/animals/cat"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("Only 'dog' is allowed"))
                .andExpect(jsonPath("$.status").value(403));
    }

    @Test
    void getAllAnimals_shouldAlwaysReturnIsNotFound() throws Exception {
        mockMvc.perform(get("/api/animals"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No Animals found"))
                .andExpect(jsonPath("$.status").value(404));
    }
}