package com.Authentication.Auth.Modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder
@Document(collection="usuarios")
public class Usuario {
	
	@Id
	private String Id;
	private String email;
	private String nombre;
	private String password;
	private String rol;
}
