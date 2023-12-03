package controllers;

import java.util.List;
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
				flash.success("A pessoa foi cadastrada com sucesso.");
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
}
