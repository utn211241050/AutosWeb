package com.librerias.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.librerias.Model.Categoria;
import com.librerias.Service.IntCategoria;

@RequestMapping("/categoria")
@Controller
public class CategoriaController {

	@Autowired
	private IntCategoria CategoriaService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Categoria> lista = CategoriaService.ObtenerTodas();
		for(Categoria c : lista) {
			System.out.println(c);
		}
		model.addAttribute("categorias",lista);
		return "categorias/listCategorias";
	}
	@PostMapping("/guardar")
	public String guardar(
			Categoria categoria, 
			BindingResult result,
			RedirectAttributes model) {
		if(result.hasErrors()) {
			System.out.println("Error");
			return "categorias/formCategoria";
		}else {
		//System.out.println(categoria);
		if ( categoria.getId() == null) {
			int index = CategoriaService.ObtenerTodas().size()-1;
			Categoria aux = CategoriaService.ObtenerTodas().get(index);
			categoria.setId(aux.getId()+1);
			model.addFlashAttribute("msg", "Se guardo la categoria");
			CategoriaService.agregar(categoria);
		}else {
			int posicion = CategoriaService.buscarPosicion(categoria);
			//System.out.println(posicion);
			model.addFlashAttribute("msg", "Se modifico³ la categoria");
			CategoriaService.modificar(posicion, categoria);
		}
	/*	categoria.setId(categoriaService.obtenerTodas().size()+1);
		System.out.println(categoria);
		categoriaService.agregar(categoria);*/
		
		return "redirect:/categoria/index";
	}
	}
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id")int idCategoria) {
		CategoriaService.eliminar(idCategoria);
		return "redirect:/categoria/index";
	}
	@GetMapping("/consultar")
	public String consultar(@RequestParam("id")int idCategoria,Model model) {
		Categoria categoria = CategoriaService.buscarPorId(idCategoria);
		model.addAttribute("categoria",categoria);
		return "categorias/formCategoria";
	}
	@GetMapping("/crear")
	public String nuevaCategoria(Categoria c) {
		return "categorias/formCategoria";
	}
	
}
