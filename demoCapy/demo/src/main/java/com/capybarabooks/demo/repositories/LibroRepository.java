package com.capybarabooks.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capybarabooks.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

		@Query("SELECT p FROM Libro p WHERE p.nombre=?1")
		Optional<Libro> findByNombre(String nombre);
}
