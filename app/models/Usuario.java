package models;

import javax.persistence.Entity;

import javax.persistence.Transient;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	public String email;
	public String nome;
	public String senha;
	
	@Override
	public String toString() {
		return email + " " + senha;
	}

}
