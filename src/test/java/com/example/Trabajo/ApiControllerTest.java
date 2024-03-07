package com.example.Trabajo;


import com.example.Trabajo.miproyecto.api.ApiController;
import com.example.Trabajo.model.Registro;
import com.example.Trabajo.miproyecto.Servicio.RegistroServicioImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RegistroServicioImp registroServicio;

    @InjectMocks
    private ApiController apiController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerRegistros() throws Exception {

        Registro registro1 = new Registro();
        Registro registro2 = new Registro();
        List<Registro> registros = Arrays.asList(registro1, registro2);


        when(registroServicio.obtenerRegistros()).thenReturn(registros);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/registros")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nombre").value(registro1.getNombre()))
                .andExpect(jsonPath("$[1].nombre").value(registro2.getNombre()));

        verify(registroServicio, times(1)).obtenerRegistros();
    }

}
