package com.Authentication.Auth.Controlador;

import com.Authentication.Auth.DTO.AuthUserDto;
import com.Authentication.Auth.DTO.NewUserDto;
import com.Authentication.Auth.DTO.RequestDto;
import com.Authentication.Auth.DTO.TokenDto;
import com.Authentication.Auth.Modelo.Usuario;
import com.Authentication.Auth.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioControlador {

	@Autowired
	UsuarioServicio authUserService;

	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto) {
		TokenDto tokenDto = authUserService.login(dto);
		if (tokenDto == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(tokenDto);
	}

	@PostMapping("/validate")
	public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto) {
		TokenDto tokenDto = authUserService.validate(token, dto);
		if (tokenDto == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(tokenDto);
	}

	@PostMapping("/registrar")
	public ResponseEntity<Usuario> create(@RequestBody NewUserDto dto) {
		Usuario authUser = authUserService.save(dto);
		if (authUser == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(authUser);
	}
}
