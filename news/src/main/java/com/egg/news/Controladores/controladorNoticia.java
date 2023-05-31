/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egg.news.Controladores;

import com.egg.news.Servicios.serviciosNoticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author droa
 */
@Controller
@RequestMapping("/noticia")
public class controladorNoticia {
    
    @Autowired
    private serviciosNoticia sN;
    
    @GetMapping("/creacion")
    public String registrar(){
        return "noticia_form.html";
    }
    @PostMapping("/crear")
    public String crear(@RequestParam String titulo,@RequestParam String cuerpo)
    {
        sN.crearNoticia(titulo, cuerpo);
        return "index.html";
    }
}
