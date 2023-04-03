package com.capybarabooks.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {
	
	@Id//el campo id es la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el campo id sera generado automaticamente por la DB
    @Column(name="id", unique = true, nullable = false)
	
	//Atributos
	private Long id;
	private String editorial;
	private Integer stock;
	private String categoria;
	private String sinopsis;
	private Long isbn;
	private String nombre;
	private Double precio;
	private String autor;
	private String URL_Imagen;
	
	
	
	//Constructor vacio
	public Libro() {

	}//constructor vacio 


	//Constructor con todos los campos
	

	//Getters y Setters
	public Long getId() {
		return id;
	}//getId


	public Libro(Long id, String editorial, Integer stock, String categoria, String sinopsis, Long isbn, String nombre,
			Double precio, String autor, String uRL_Imagen) {
		super();
		this.id = id;
		this.editorial = editorial;
		this.stock = stock;
		this.categoria = categoria;
		this.sinopsis = sinopsis;
		this.isbn = isbn;
		this.nombre = nombre;
		this.precio = precio;
		this.autor = autor;
		URL_Imagen = uRL_Imagen;
	}


	public void setId(Long id) {
		this.id = id;
	}//setId


	public String getNombre() {
		return nombre;
	}//getNombre


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre


	public Double getPrecio() {
		return precio;
	}//getPrecio


	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio


	public String getEditorial() {
		return editorial;
	}//getEditorial


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}//setEditorial


	public String getAutor() {
		return autor;
	}//getAutor


	public void setAutor(String autor) {
		this.autor = autor;
	}//setAutor


	public Integer getStock() {
		return stock;
	}//getStock


	public void setStock(Integer stock) {
		this.stock = stock;
	}//setStock


	public String getCategoria() {
		return categoria;
	}//getCategoria


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}//setCategoria


	public String getSinopsis() {
		return sinopsis;
	}//getSinopsis


	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}//setSinopsis


	public Long getIsbn() {
		return isbn;
	}//getIsbn


	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}//setIsbn


	public String getURL_Imagen() {
		return URL_Imagen;
	}//getURL_Imagen


	public void setURL_Imagen(String uRL_Imagen) {
		URL_Imagen = uRL_Imagen;
	}//setURL_Imagen


	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + ", stock=" + stock + ", categoria=" + categoria + ", sinopsis=" + sinopsis + ", isbn=" + isbn
				+ ", URL_Imagen=" + URL_Imagen + "]";
	}//Overrride
	
	
	
	
	
 
	

}
