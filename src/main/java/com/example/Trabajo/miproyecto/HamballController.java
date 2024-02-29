package com.example.Trabajo.miproyecto;



import com.example.Trabajo.model.Registro;
import com.example.Trabajo.model.RegistroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HamballController {
    @Autowired
    private RegistroRepository registroRepository;

    @GetMapping("/hamball")
    public String hamballPage(Model model) {
        model.addAttribute("practica", "hamball");

        return "hamball";
    }

    @PostMapping("/hamball/registro")
    public String registrarHamball(Registro registro, Model model) {
        registro.setPractica((String) model.getAttribute("practica"));
        registroRepository.save(registro);
        model.addAttribute("registroExitoso", true);
        return "redirect:/hamball";
    }
}
