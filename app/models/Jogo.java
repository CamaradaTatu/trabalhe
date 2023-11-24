package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Jogo extends Model{
	public String nome;
	public String descricao;
	public double nota;
	
	public Jogo() {
		
	}
	
	public Jogo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.nota = 0;
	}
	
	
	
	
}
