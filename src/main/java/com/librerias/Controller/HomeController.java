package com.librerias.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.librerias.Model.Categoria;
import com.librerias.Model.Libro;
import com.librerias.Service.IntCategoria;
import com.librerias.Service.IntLibros;

@Controller
public class HomeController {
	
	@Autowired
	private IntLibros VacantesServceImp;
	@Autowired
	private IntCategoria CategoriasServceImp;
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Libro> lista = VacantesServceImp.obtenerTodas();
		List<Categoria> catego = CategoriasServceImp.ObtenerTodas();
		model.addAttribute("libros", lista);
		model.addAttribute("categorias", catego);
		return "home";
	}

}
