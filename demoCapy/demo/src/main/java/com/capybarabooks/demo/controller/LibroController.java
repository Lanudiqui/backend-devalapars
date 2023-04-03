package com.capybarabooks.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capybarabooks.demo.model.Libro;
import com.capybarabooks.demo.services.LibroService;

@RestController
@RequestMapping(path = "/CapybaraBooks/libros/")
public class LibroController {
	
	private final LibroService libroService;
	
	@Autowired
	public LibroController(LibroService libroService) {
		this.libroService = libroService;
	}
	
	
	//HTTP GETG
	@GetMapping
	public List<Libro> getLibro() {
		return libroService.leerLibros();
	}
	
	@GetMapping(path = "{libId}")
	public Libro getLibro(@PathVariable("libId")Long libId) {
		return libroService.leerLibro(libId);
	}
	
	
	//HTTP POST 
	@PostMapping
	public void postLibro(@RequestBody Libro libId) {
		libroService.crearLibro(libId);
	}
	
	
	
	//HTTP PUT
	@PutMapping(path = "{libId}")
	public void updateLibro(@PathVariable("libId")Long libId,
			 @RequestParam(required=false) String nombre, 
	         @RequestParam(required=false) String autor,
	         @RequestParam(required= false) Double precio,
	         @RequestParam(required=false) String url_Imagen) {
		libroService.actualizarLibro(libId, nombre, precio, autor, url_Imagen);
	}//update libro
	
	
	//HTTP DELETE
	@DeleteMapping(path = "{libId}")
	public void deleteLibro(@PathVariable("libId")Long libId) {
		libroService.borrarLibro(libId);
	}
	

}
