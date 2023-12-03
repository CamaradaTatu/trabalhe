package models;

import javax.persistence.Entity;



import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	@Column(nullable = false, unique = true)
	@Required
	@Email //Retire em caso de não saber o problema
	public String email;
	
	@Required
	@MaxSize(16)
	public String nome;
	
	@Required
	@MaxSize(18)
	@MinSize(4)
	public String senha;
	
	@Override
	public String toString() {
		return nome;
	}

}
