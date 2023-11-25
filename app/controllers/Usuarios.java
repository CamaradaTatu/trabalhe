package controllers;

import java.util.List;
import models.Jogo;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.Before;
import play.mvc.With;


public class Usuarios extends Controller{

	public static void telaInicial(String termo) {
		Usuarios.listar(termo);
		render();
	}
	public static void listaJogos() {
		render();
	}
	
	public static void editar(long id) {
		Usuario u = Usuario.findById(id);
		renderTemplate("Usuarios/form.html", u);
	}
	
	public static void remover(Long id) {
		Usuario u = Usuario.findById(id);
		u.delete();
		flash.success("A pessoa foi removida com sucesso.");
		listar(null);
	}
	
	 static void listar(String termo) {
		 List<Jogo> jogos = null;
			if (termo == null || termo.isEmpty()) {
				render(jogos, termo);
			} else {
				jogos = Jogo.find("lower(nome) like ?1","%"+ termo.toLowerCase() +"%").fetch();
			}
			render(jogos, termo);
	}
	
	public static void salvar(Usuario usu) {

		usu.save();
		flash.success("A pessoa foi cadastrada com sucesso.");
		Usuarios.telaInicial(null);
	}
}
