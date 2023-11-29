package com.Authentication.Auth.Servicio;

import com.Authentication.Auth.DTO.AuthUserDto;
import com.Authentication.Auth.DTO.NewUserDto;
import com.Authentication.Auth.DTO.RequestDto;
import com.Authentication.Auth.DTO.TokenDto;
import com.Authentication.Auth.Modelo.Usuario;
import com.Authentication.Auth.Repositorio.UsuarioRepositorio;
import com.Authentication.Auth.Seguridad.JwtService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtService jwtProvider;
	
		public Usuario save(NewUserDto dto) {
			Optional<Usuario> user = usuarioRepositorio.findByEmail(dto.getEmail());
			if (user.isPresent()) {
				return null;
			}
			String password = passwordEncoder.encode(dto.getPassword());
			Usuario authUser = Usuario.builder()
			.email(dto.getEmail())
			.nombre(dto.getNombre())
			.password(password)
			.rol(dto.getRol())
			.build();
			return usuarioRepositorio.save(authUser);
		}

	public TokenDto login(AuthUserDto dto) {
		Optional<Usuario> user = usuarioRepositorio.findByEmail(dto.getEmail());
		if (!user.isPresent()) {
			return null;
		}
		if (passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
			return new TokenDto(jwtProvider.createToken(user.get()));
		}
		return null;
	}

	public TokenDto validate(String token, RequestDto request) {
		if (!jwtProvider.validate(token, request)) {
			return null;
		}
		String username = jwtProvider.getEmailFromToken(token);
		if (!usuarioRepositorio.findByEmail(username).isPresent()) {
			return null;
		}
		return new TokenDto(token);
	}
}
