package controllers;

import java.util.List;
import models.Usuario;
import models.Comentario;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Comentarios extends Controller{ 

	public static void criticas() {
		List<Usuario> comentarios = Usuario.findAll();
		render(comentarios);
	}
	
	public static void salvar(Comentario C) {
		C.save();
		listar();
	}
	
	public static void listar() {
		List<Comentario> comentarios = Comentario.findAll();
		render(comentarios);
	}
	public static void editar(Long id) {
		Comentario c = Comentario.findById(id);
		renderTemplate("Comentarios/criticas.html", c);
	}
	
	public static void remover(Long id) {
		Comentario c = Comentario.findById(id);
		c.delete();
		flash.success("o comentario foi removida com sucesso.");
	}
	
	public static void detalhar(Long id) {
		Comentario comentario = Comentario.findById(id);
		render(comentario);
	}
	
}
