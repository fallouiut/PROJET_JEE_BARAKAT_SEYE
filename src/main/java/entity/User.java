package entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component()
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    
	@NotNull(message = "Le champs email est vide")
	@NotBlank(message = "Le champs email est vide")
	@Email(message = "Veuillez saisir un email valide")
	private String email;
	
	@NotNull(message = "Le champ mot de passe est vide")
	@NotBlank(message = "Le champ mot de passe est vide")
	private String password;
    
    private Person relatedPerson;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

	public Person getRelatedPerson() {
		return relatedPerson;
	}

	public void setRelatedPerson(Person relatedPerson) {
		this.relatedPerson = relatedPerson;
	}

}