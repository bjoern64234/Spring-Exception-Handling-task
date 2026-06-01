package de.neuefische.springexceptionhandlingtask.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCarBrand_shouldReturnCarBrand_whenPorscheIsGiven() throws Exception {
        mockMvc.perform(get("/api/cars/porsche"))
                .andExpect(status().isOk())
                .andExpect(content().string("porsche"));
    }

    @Test
    void getCarBrand_shouldReturnForbidden_whenPorscheIsNotGiven() throws Exception {
        mockMvc.perform(get("/api/cars/vw"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("Only 'porsche' allowed"))
                .andExpect(jsonPath("$.status").value(403));
    }

    @Test
    void getAllCars_shouldAlwaysReturnIsNotFound() throws Exception {
        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No Cars found"))
                .andExpect(jsonPath("$.status").value(404));
    }
}