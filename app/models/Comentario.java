package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class Comentario extends Model{
public String comentario;
	
	@ManyToOne
	@JoinColumn(name="comentarios")
	public Usuario usuario;

	@Override
	public String toString() {
		return comentario;
	}

}
