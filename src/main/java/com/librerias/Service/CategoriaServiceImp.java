package com.librerias.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.librerias.Model.Categoria;

@Service
public class CategoriaServiceImp implements IntCategoria {

private List<Categoria> lista = null;
	
	public CategoriaServiceImp() {
		
		lista = new LinkedList<Categoria>();
		
		Categoria cs = new  Categoria();
		cs.setId(1);
		cs.setNombre("FORD");
		cs.setDescripcion("Estados Unidos");
		
		Categoria cs1 = new  Categoria();
		cs1.setId(2);
		cs1.setNombre("NISSAN");
		cs1.setDescripcion("Japon");
		
		Categoria cs2 = new  Categoria();
		cs2.setId(3);
		cs2.setNombre("MAZDA");
		cs2.setDescripcion("Japon");
		
		lista.add(cs);
		lista.add(cs1);
		lista.add(cs2);
	}
	@Override
	public List<Categoria> ObtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void agregar(Categoria categoria) {
		lista.add(categoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria categoria:lista) {
			if(categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCtargoria) {
		lista.remove(buscarPorId(idCtargoria));
	}

	@Override
	public int ids() {
		int id=0;
		for(Categoria cat:lista) {
			id = cat.getId();
		}
		return id;
	}

	@Override
	public void modificar(int posicion, Categoria cat) {
		lista.set(posicion, cat);

	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
	}

}
