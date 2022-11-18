package com.librerias.Service;

import java.util.List;

import com.librerias.Model.Categoria;

public interface IntCategoria {

	public List<Categoria>ObtenerTodas();
	public void agregar (Categoria categoria);
	public Categoria buscarPorId (Integer idCategoria); 
	public void eliminar (Integer idCtargoria);
	int ids();
	void modificar(int posicion, Categoria cat);
	public int buscarPosicion(Categoria categoria);
	
}
