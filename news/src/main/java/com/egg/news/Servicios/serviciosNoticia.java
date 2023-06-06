/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egg.news.Servicios;

import com.egg.news.Entidades.Noticia;
import com.egg.news.Repositorios.repositorioNoticia;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author droa
 */

@Service
public class serviciosNoticia  {
    
    @Autowired
    private repositorioNoticia rN;
    
    @Transactional
    public void crearNoticia(String Titulo, String Cuerpo){
        Noticia noticia = new Noticia();
        noticia.setTitulo(Titulo);
        noticia.setCuerpo(Cuerpo);
        rN.save(noticia);
    }
    @Transactional(readOnly = true)
    public List<Noticia> buscarNoticia(String palabraClave){
        List<Noticia> noticias = new ArrayList();
        noticias = rN.buscarNoticia(palabraClave);
        return noticias;
    }
    @Transactional(readOnly = true)
    public List<Noticia> todasNoticias(){
        List<Noticia> noticias = new ArrayList();
        noticias = rN.findAll();
        return noticias;
    }
    
    @Transactional(readOnly = true)
    public Noticia obtenerNoticia(String idNoticia){
        Noticia noticia= new Noticia();
        noticia = rN.getOne(idNoticia);
        return noticia;
    }
    
    @Transactional
    public void modificarNoticia(String Id, String Titulo, String Cuerpo){
        Optional<Noticia> respuestaNoticia = rN.findById(Id);
        Noticia noticia = new Noticia();
        if(respuestaNoticia.isPresent()){
            noticia = respuestaNoticia.get();
            noticia.setTitulo(Titulo);
            noticia.setCuerpo(Cuerpo);
            rN.save(noticia);
        }
        
    }
    
    @Transactional
    public void darDeBajaNoticia(String idNoticia){
        
        Optional<Noticia> noticia = rN.findById(idNoticia);
        if(noticia.isPresent()){
            Noticia noticiaAux = noticia.get();
            noticiaAux.setAlta(false);
            rN.save(noticiaAux);
        }
       
    }
    
}
