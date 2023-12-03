package models;

import play.db.jpa.Model;
import models.Comentario;

import javax.persistence.Column;
import javax.persistence.Entity;





@Entity
public class Jogo extends Model{
	public String nome;
	@Column(length = 1000)
	public String descricao;
	
	public double nota;
	public String caminhoImg;
	
	public Jogo() {
		
	}
	
	public Jogo(String nome, String descricao, String caminhoImg) {
		this.nome = nome;
		this.descricao = descricao;
		this.nota = 0;
		this.caminhoImg = caminhoImg;
	}
	
	
}
