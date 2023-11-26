package models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Transient;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	@Column(nullable = false, unique = true)
	public String email;
	public String nome;
	public String senha;
	
	@Override
	public String toString() {
		return nome;
	}

}
