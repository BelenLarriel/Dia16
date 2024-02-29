package com.example.Trabajo.miproyecto;


import com.example.Trabajo.model.Registro;
import com.example.Trabajo.model.RegistroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FutbolController {
    @Autowired
    private RegistroRepository registroRepository;

    @GetMapping("/futbol")
    public String futbolPage(Model model) {
        // Añade un atributo al modelo para indicar la práctica
        model.addAttribute("practica", "futbol");
        return "futbol";
    }

    @PostMapping("/futbol/registro")
    public String registrarFutbol(Registro registro, Model model) {
        // Establece el valor del campo 'practica' según el atributo del modelo
        registro.setPractica((String) model.getAttribute("practica"));

        // Guarda el registro en la base de datos
        registroRepository.save(registro);
        model.addAttribute("registroExitoso", true);

        // Redirige a donde desees después de guardar
        return "redirect:/futbol";
    }
















}
