package com.example.Trabajo.miproyecto.Servicio;

import com.example.Trabajo.model.Registro;
import java.util.List;
import java.util.Optional;
public interface RegistroServicio {



    void guardar(Registro registro);

    void borrar(Registro registro);

    Registro localizarRegistro(Registro registro);

    List<Registro> obtenerRegistros();

    Registro guardarRegistro(Registro registro);

    Optional<Registro> obtenerPorId(Long id);

    boolean eliminarRegistro(Long id);
}
