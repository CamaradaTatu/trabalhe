package controllers;

import java.util.ArrayList;
import java.util.List;


import models.Comentario;
import models.Jogo;
import models.Usuario;
import play.data.validation.Valid;
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
	
	public static void salvar(@Valid Comentario C, String email, Long idJogo) {
		
		Usuario usu = Usuario.find("email = ?1", email).first();
		Jogo jogo = Jogo.findById(idJogo);
		
		C.jogo = jogo;
		C.usuario = usu;
		String condicional = null;
		List<Comentario> comentarios = Comentario.findAll();
		for (int i = 0; i < comentarios.size(); i++) {
			if(comentarios.get(i).jogo == jogo && comentarios.get(i).usuario == usu) {
				condicional = "";
			}
			
		}
		if (condicional == null && !validation.hasErrors()) {
			flash.success("Sua crítica foi adicionada em nosso site!");
			C.save();
		}
		
		else {
			flash.error("você ja possui uma crítica para este jogo!");
		}	
		
		listaComentario(idJogo);
		// listar();
	}
	
	public static void listaComentario(Long idJogo) {
		Jogo jSelecionado = Jogo.findById(idJogo);
		String email = session.get("usuarioLogado");
		List<Comentario> comentarios = Comentario.findAll();
		List<Comentario> comentariosR = new ArrayList<Comentario>();
		List<Comentario> comentariosM = new ArrayList<Comentario>();
		List<Comentario> comentariosB = new ArrayList<Comentario>();
		
		// o trecho abaixo itera sobre todos os comentários para achar todos os comentários relacionados ao jogo selecionado(jSelecionado) e dividi-los em ruim, médio ou bom.
		for (int i = 0; i < comentarios.size(); i++) {
			if (comentarios.get(i).jogo == jSelecionado) {
				if(comentarios.get(i).nota >= 1 && comentarios.get(i).nota <= 7) {
					comentariosR.add(comentarios.get(i));
				}
				else if(comentarios.get(i).nota >= 8 && comentarios.get(i).nota <= 14) {
					comentariosM.add(comentarios.get(i));
				}
				else if(comentarios.get(i).nota >= 15 && comentarios.get(i).nota <= 20) {
					comentariosB.add(comentarios.get(i));
				}
			}
		}
		render(jSelecionado, email, comentariosR, comentariosM, comentariosB);
		
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
