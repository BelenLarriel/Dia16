package com.example.Trabajo;
import com.example.Trabajo.model.Registro;
import com.example.Trabajo.model.RegistroRepository;
import com.example.Trabajo.miproyecto.Servicio.RegistroServicioImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest

public class RegistroServicioImpTest {
    @Mock
    private RegistroRepository registroRepository;

    @InjectMocks
    private RegistroServicioImp registroServicio;

    @Test
    void obtenerRegistros_DeberiaRetornarListaVaciaCuandoNoHayRegistros() {

        Mockito.when(registroRepository.findAll()).thenReturn(new ArrayList<>());


        List<Registro> registros = registroServicio.obtenerRegistros();


        Mockito.verify(registroRepository).findAll();

           assertEquals(0, registros.size());
    }

    @Test
    void obtenerPorId_DeberiaRetornarRegistroCuandoExiste() {

        Registro registroMock = new Registro();
        registroMock.setId(1L);
        Mockito.when(registroRepository.findById(anyLong())).thenReturn(Optional.of(registroMock));


        Optional<Registro> resultado = registroServicio.obtenerPorId(1L);


        Mockito.verify(registroRepository).findById(1L);

        assertEquals(registroMock, resultado.orElse(null));
    }


}

