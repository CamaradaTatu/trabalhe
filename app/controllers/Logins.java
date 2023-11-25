package controllers;

import play.mvc.Controller;

import models.Usuario;

public class Logins extends Controller{

	public static void login() {
		render();
	}
	
	public static void cadastrar() {
		render();
	}
	
	public static void logar(String email, String senha) {
			
			Usuario pessoaBanco = Usuario.find("email = ?1 and senha = ?2", email, senha).first();
			if (pessoaBanco != null) {
				session.put("usuarioLogado", pessoaBanco.email);
				session.put("userId", pessoaBanco.id);
				flash.success("Login realizado com sucesso!");
				Usuarios.telaInicial(null);
			}	
			flash.error("Credenciais inválidas");
			login();
		}
		
		public static void logout() {
			session.clear();
			flash.success("Você saiu do sistema");
			login();
		}
	
	}
	

