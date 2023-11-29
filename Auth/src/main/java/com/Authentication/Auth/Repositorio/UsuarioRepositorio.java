package com.Authentication.Auth.Repositorio;

import com.Authentication.Auth.Modelo.Usuario;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{
	Optional<Usuario> findByEmail(String email);
}
