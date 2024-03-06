package com.example.Trabajo.miproyecto.api;

import com.example.Trabajo.miproyecto.Servicio.RegistroServicioImp;
import com.example.Trabajo.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registros")
public class ApiController {

    @Autowired
    private RegistroServicioImp registroServicio;

    @GetMapping
    public List<Registro> obtenerRegistros() {
        return registroServicio.obtenerRegistros();
    }

    @PostMapping
    public Registro guardarRegistro(@RequestBody Registro registro) {
        return registroServicio.guardarRegistro(registro);
    }

    @GetMapping("/{id}")
    public Optional<Registro> obtenerRegistroPorId(@PathVariable Long id) {
        return registroServicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarRegistroPorId(@PathVariable Long id) {
        boolean eliminado = registroServicio.eliminarRegistro(id);
        if (eliminado) {
            return "Se eliminó correctamente el registro con ID " + id;
        } else {
            return "No se pudo eliminar el registro con ID " + id;
        }
    }
}





