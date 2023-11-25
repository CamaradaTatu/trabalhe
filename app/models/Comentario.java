package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class Comentario extends Model{
	
public String comentario;
public int nota;
	
	@ManyToOne
	@JoinColumn(name="Jogo")
	public Jogo jogo;
	
	@ManyToOne
	@JoinColumn(name="Autor")
	public Usuario usuario;
}
