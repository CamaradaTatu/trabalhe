package controllers;

import java.util.List;

import models.Usuario;
import models.Comentario;
import models.Jogo;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Comentarios extends Controller {

	public static void cadastrarComentário() {
		List<Jogo> jogos = Jogo.findAll();
		String email = session.get("usuarioLogado");
		render(jogos,email);
	}

	/*
	 * public static void criticas() { List<Usuario> comentarios =
	 * Usuario.findAll(); render(comentarios); }
	 */
	
	public static void salvar(Comentario C, String email, Long idJogo) {
		
		Usuario usu = Usuario.find("email = ?1", email).first();
		Jogo jogo = Jogo.findById(idJogo);
		
		C.jogo = jogo;
		C.usuario = usu;
		
		
		C.save();
		Usuarios.telaInicial();
		// listar();
	}

	/*
	 * public static void listar() { List<Comentario> comentarios =
	 * Comentario.findAll(); render(comentarios); } public static void editar(Long
	 * id) { Comentario c = Comentario.findById(id);
	 * renderTemplate("Comentarios/criticas.html", c); }
	 * 
	 * public static void remover(Long id) { Comentario c = Comentario.findById(id);
	 * c.delete(); flash.success("o comentario foi removida com sucesso."); }
	 * 
	 * public static void detalhar(Long id) { Comentario comentario =
	 * Comentario.findById(id); render(comentario); }
	 */
}
