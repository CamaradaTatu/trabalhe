package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Comentario;
import models.Jogo;
import models.Usuario;
import play.mvc.Controller;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.With;

public class Usuarios extends Controller {

	public static void telaInicial() {
		Jogo relAnt = Jogo.findById(Long.valueOf(1));
		Jogo sucAno = Jogo.findById(Long.valueOf(3));
		Jogo expDif = Jogo.findById(Long.valueOf(2));

		render(relAnt, sucAno, expDif);

	}

	public static void listaJogos(String termo) {

		List<Jogo> jogos = Jogo.findAll();

		if (termo != null || !termo.isEmpty()) {

			jogos = Jogo.find("lower(nome) like ?1", "%" + termo.toLowerCase() + "%").fetch();
			render(jogos);
		}
		
		render(jogos);
	}

	public static void editar(long id) {
		Usuario u = Usuario.findById(id);
		renderTemplate("Usuarios/form.html", u);
	}

	public static void remover(Long id) {
		Usuario u = Usuario.findById(id);
		u.delete();
		flash.success("A pessoa foi removida com sucesso.");

	}

	public static void salvar(@Valid Usuario usu) {

		try {
			if(!validation.hasErrors()) {
				usu.save();
				Logins.logar(usu.email, usu.senha);
			}
			else {
				Logins.cadastrar();
			}
		} catch (javax.persistence.PersistenceException e) {
			Throwable cause = e.getCause();
			if (cause instanceof org.hibernate.exception.ConstraintViolationException) {
				flash.error("tentativa de cadastro invalido, tente outro email.");
				Logins.cadastrar();
			} else {
				e.printStackTrace();
			}
		}
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
}
