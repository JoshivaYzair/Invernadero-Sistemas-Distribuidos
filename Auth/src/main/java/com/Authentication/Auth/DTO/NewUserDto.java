package com.Authentication.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUserDto {
	private String email;
	private String nombre;
	private String password;
	private String rol;
}
