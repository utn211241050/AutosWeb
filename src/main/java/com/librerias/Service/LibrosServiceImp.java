package com.librerias.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.librerias.Model.Categoria;
import com.librerias.Model.Libro;

@Service
public class LibrosServiceImp implements IntLibros {
	private List<Libro> lista;
	private List<Categoria> cat;
	
	public LibrosServiceImp() {
		lista = new LinkedList<Libro>();
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/mm/yy");
		
		try {
			Libro v = new Libro();
			v.setId(1);
			v.setTitulo("MUSTANG");
			v.setEditorial("Alianza editorial");
			v.setFecha(LocalDate.of(2015, 10, 21));
			v.setPrecio(750000.00);
			v.setnPaginas(2022);
			v.setImagen("product-item6.jpg");
			
			Categoria cate = new Categoria();
			cate.setId(1);
			cate.setNombre("FORD");
			cate.setDescripcion("Estados Unidos");
			
			v.setCategoria(cate);
			
			Libro v1 = new Libro();
			v1.setId(2);
			v1.setTitulo("350z");
			v1.setEditorial("Porrua");
			v1.setFecha(LocalDate.of(2008, 06, 01));
			v1.setPrecio(450000.00);
			v1.setnPaginas(2020);
			v1.setImagen("product-item7.jpg");
			
			Categoria cate1 = new Categoria();
			cate1.setId(2);
			cate1.setNombre("NISSAN");
			cate1.setDescripcion("Japon");
			
			v1.setCategoria(cate1);
			Libro v2 = new Libro();
			v2.setId(3);
			v2.setTitulo("RX-7");
			v2.setEditorial("Debolsillo");
			v2.setFecha(LocalDate.of(2002, 02, 05));
			v2.setPrecio(500000.00);
			v2.setnPaginas(2021);
			v2.setImagen("product-item8.jpg");
			
			Categoria cate3 = new Categoria();
			cate3.setId(3);
			cate3.setNombre("MAZDA");
			cate3.setDescripcion("Japon");
			
			v2.setCategoria(cate3);
			
			lista.add(v);
			lista.add(v1);
			lista.add(v2);
		}catch(DateTimeParseException ex) {
			System.out.println("Error: "+ ex.getMessage());
		}

	}
	@Override
	public List<Libro> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Libro vaca) {
		lista.add(vaca);
		
	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));
		
	}

	@Override
	public Libro buscarPorId(Integer idVacante) {
		for(Libro vaca:lista) {
			if(vaca.getId() == idVacante) {
				return vaca;
			}
		}
		return null;
	}

	public long numVacantes() {
		return lista.size();
	}

	@Override
	public void modificar(int posicion, Libro v) {
		lista.set(posicion, v);
		
	}

	@Override
	public int buscarPosicion(Libro v) {
		int index = 0; Libro aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==v.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
	}

}
