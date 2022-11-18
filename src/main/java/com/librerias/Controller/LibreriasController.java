package com.librerias.Controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.librerias.Model.Libro;
import com.librerias.Service.IntCategoria;
import com.librerias.Service.IntLibros;
import com.librerias.Utileria.Utileria;


@Controller
@RequestMapping("/libro")
public class LibreriasController {
	
	@Autowired
	private IntLibros VacantesServceImp;
	
	@Autowired
	private IntCategoria CategoriaServiceImp;
	
	@ModelAttribute
	public void setGenerico(Model model) {
		model.addAttribute("categorias", CategoriaServiceImp.ObtenerTodas() );
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Libro> lista = VacantesServceImp.obtenerTodas();
		for(Libro v : lista) {
			System.out.println(v);
		}
		model.addAttribute("vacantes",lista);
		return "libros/listLibros";
	}
	
	@GetMapping("/detalle")
	public String detalles(@RequestParam("id") int idVacante, Model model) {
		Libro libro = VacantesServceImp.buscarPorId(idVacante);
		model.addAttribute("libros", libro);
		return "libros/detalle";
	}
	@GetMapping("/nuevo")
	public String crear (Libro v) {
		return "libros/formLibros";
	}
	@GetMapping("/consultar")
	public String consultar(@RequestParam("id")int idVacante,Model model) {
		Libro v = VacantesServceImp.buscarPorId(idVacante);
		model.addAttribute("libro",v);
		return "libros/formLibros";
	}
	@PostMapping("/guardar")
	public String guardar( Libro v, BindingResult result,@RequestParam("archivoImagen") MultipartFile multiPart,RedirectAttributes model) {
		System.out.print(v);
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "libros/formLibros";
		}
		if (!multiPart.isEmpty()) {

			String ruta = "c:/librerias/src/main/resources/static/images/"; 
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ 
			v.setImagen(nombreImagen);
				}
			}
		if(v.getId() == null) {
			int index = VacantesServceImp.obtenerTodas().size()-1;
			Libro aux = VacantesServceImp.obtenerTodas().get(index);
			v.setId(aux.getId()+1);
			v.setCategoria(CategoriaServiceImp.buscarPorId(v.getCategoria().getId()));
			VacantesServceImp.guardar(v);
		}else {
			int pos = VacantesServceImp.buscarPosicion(v);
			model.addFlashAttribute("msg", "Se modifico³ el vacante");
			v.setCategoria(CategoriaServiceImp.buscarPorId(v.getCategoria().getId()));
			VacantesServceImp.modificar(pos, v);
		}

		return "redirect:/libro/index";
	}
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id")int idVcante) {
		VacantesServceImp.eliminar(idVcante);
		return "redirect:/libro/index";
	}
	@GetMapping("/editar")
	public String editar(@RequestParam("id") int idCategoria , Model model) {
		Libro vaca = VacantesServceImp.buscarPorId(idCategoria);
		model.addAttribute(vaca);
		return "libros/formLibros";
	}
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) throws IllegalArgumentException{
          setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        @Override
        public String getAsText() throws IllegalArgumentException {
          return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) getValue());
        }
      });
    }

}
