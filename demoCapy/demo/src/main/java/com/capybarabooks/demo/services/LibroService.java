package com.capybarabooks.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capybarabooks.demo.model.Libro;
import com.capybarabooks.demo.repositories.LibroRepository;

@Service
public class LibroService {
	
	//Se crea el objeto de la clase LibroRepository
	private final LibroRepository libroRepository;
	
	@Autowired
	//Se usa el objeto como parametro de mi constructor
	public LibroService(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}
	
	//CREATE
		public void crearLibro(Libro lib) {
			Optional<Libro> libroBuscado =
					libroRepository.findByNombre(lib.getNombre());
			if (libroBuscado.isPresent()) {
				throw new IllegalStateException ("El libro con el nombre"+ "[" + lib.getNombre()+ "] ya existe"); 
			} else {
				libroRepository.save(lib);
			}//else//if
			
		}
	
	//READ
	public List<Libro> leerLibros(){
		return libroRepository.findAll();
	}// read
	
	//Leer un libro
	public Libro leerLibro(Long libId) {
		return libroRepository.findById(libId).orElseThrow(()-> new IllegalStateException("El Libro"
				+ "con el id " + libId + " no existe"));
	}
	
	
	
	//UPDATE
	public void actualizarLibro(Long libId, String nombre, Double precio, String autor , String URL_Imagen) {
		if (libroRepository.existsById(libId)) {
			Libro libroABuscar = libroRepository.getById(libId);
			if (nombre != null) libroABuscar.setNombre(nombre);
			if (autor != null) libroABuscar.setAutor(autor);
			if (precio != 0) libroABuscar.setPrecio(precio);
			if (URL_Imagen != null) libroABuscar.setURL_Imagen(URL_Imagen);
			//Cuando termino de editar el objeto..
			libroRepository.save(libroABuscar);		
		}else {
			System.out.println("El libro con el id " + libId + " no existe");
		}
	}
	
	
	//DELATE
	public void borrarLibro(Long libId) {
		if (libroRepository.existsById(libId)) {
			libroRepository.deleteById(libId);
		}
		
	}

}
