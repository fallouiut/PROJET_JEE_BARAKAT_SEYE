package entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

public class SearchQuery implements Serializable {

	@NotNull(message = "Le champs de requête est vide")
	private String query;
	
	public SearchQuery() {
		
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getQuery() { return this.query; }
}
