package com.librerias.Service;

import java.util.List;

import com.librerias.Model.Libro;

public interface IntLibros {
	
	public List<Libro> obtenerTodas();
	public void guardar(Libro vaca);
	public void eliminar(Integer idVacante);
	public Libro buscarPorId(Integer idVacante);
	void modificar(int posicion, Libro v);
	int buscarPosicion(Libro v);

}
