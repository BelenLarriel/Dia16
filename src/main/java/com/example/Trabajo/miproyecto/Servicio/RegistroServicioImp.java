package com.example.Trabajo.miproyecto.Servicio;


import com.example.Trabajo.model.RegistroRepository;
import com.example.Trabajo.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroServicioImp implements RegistroServicio{

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    @Transactional
    public void guardar(Registro registro) {
        registroRepository.save(registro);
    }

    @Override
    @Transactional
    public void borrar(Registro registro) {
        registroRepository.delete(registro);
    }

    @Override
    public Registro localizarRegistro(Registro registro) {
        return registroRepository.findById(registro.getId()).orElse(null);
    }












    public List<Registro> obtenerRegistros() {
        return (List<Registro>) registroRepository.findAll();
    }

    public Registro guardarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public Optional<Registro> obtenerPorId(Long id) {
        return registroRepository.findById(id);
    }

    public boolean eliminarRegistro(Long id) {
        try {
            registroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
