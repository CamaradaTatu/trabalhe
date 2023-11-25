package controllers;

import java.util.List;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;


public class Usuarios extends Controller{

	public static void telaInicial() {
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
	
	public static void listar(String termo) {
		List<Usuario> usuarios = null;
		if (termo == null || termo.isEmpty()) {
			usuarios = Usuario.findAll();			
		} else {
			usuarios = Usuario.find("lower(nome) like ?1 or lower(email) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		render(usuarios, termo);
	}
	
	public static void salvar(Usuario usu) {

		usu.save();
		flash.success("A pessoa foi cadastrada com sucesso.");
		Usuarios.telaInicial();
	}
}
