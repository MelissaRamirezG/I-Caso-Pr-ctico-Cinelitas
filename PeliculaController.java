/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinelitas.controller;


import Cinelitas.entity.Pelicula;
import Cinelitas.entity.Sala;
import Cinelitas.service.IPeliculaService;
import Cinelitas.service.ISalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author User
 */
@Controller
public class PeliculaController {

    @Autowired
    private IPeliculaService peliculaService;

    @Autowired
    private ISalaService salaService;

    @GetMapping("/pelicula")
    public String index(Model model) {
        List<Pelicula> listapelicula = peliculaService.getAllPelicula();
        model.addAttribute("titulo","Tabla Pelicula");
        model.addAttribute("pelicula",listapelicula);
        return "pelicula";
    }
    
    @GetMapping("/peliculaN")
    public String crearPelicula(Model model) {
        List<Sala> listasalas = salaService.buscartodos();
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("salas",listasalas);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPelicula(@PathVariable("id") Long idPelicula) {
        peliculaService.delete(idPelicula);
        return "redirect:/pelicula";
    }

    @PostMapping("/save")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.savePelicula(pelicula);
        return "redirect:/pelicula";
    }
    
    @GetMapping("/editPelicula/{id}")
    public String editarPelicula(@PathVariable("id") Long idPelicula, Model model) {
        Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
        List<Sala> listasalas = salaService.buscartodos();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("salas", listasalas);
        return "crear";
    }
}
