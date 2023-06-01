/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egg.news.Controladores;

import com.egg.news.Entidades.Noticia;
import com.egg.news.Servicios.serviciosNoticia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author droa
 */
@Controller
@RequestMapping("/")
public class controladorInicio {
    
    @Autowired
    private serviciosNoticia sN;
    
    @GetMapping("/")
    public String index(ModelMap modelo){
        List<Noticia> noticias = sN.todasNoticias();
        modelo.addAttribute("noticias", noticias);
        return "index.html";
    }
}
