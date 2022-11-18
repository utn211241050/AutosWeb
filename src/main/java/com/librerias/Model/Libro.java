package com.librerias.Model;

import java.time.LocalDate;


public class Libro {
	private Integer id;
	private String titulo;
	private Categoria categoria;
	private LocalDate fecha;
	private Integer nPaginas;
	private String imagen= "";
	private String editorial;
	private Double precio;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getnPaginas() {
		return nPaginas;
	}
	public void setnPaginas(Integer nPaginas) {
		this.nPaginas = nPaginas;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", fecha=" + fecha
				+ ", nPaginas=" + nPaginas + ", imagen=" + imagen + ", editorial=" + editorial + ", precio=" + precio
				+ "]";
	}
	
	
	
}
