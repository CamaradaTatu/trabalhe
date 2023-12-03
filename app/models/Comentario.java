package models;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import play.db.jpa.Model;
import models.Jogo;
import models.Usuario;

@Entity
public class Comentario extends Model {

	@Column(length = 1000)
	@Required
	@MaxSize(1000)
	public String comentario;

	@Required
	@Min(1)
	@Max(20)
	public int nota;

	@ManyToOne
	@JoinColumn(name = "Jogo")
	public Jogo jogo;

	@ManyToOne
	@JoinColumn(name = "Autor")
	public Usuario usuario;
}
