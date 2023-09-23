package mario.russo.auth;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.ejb.ObjectNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.useCase.UsuarioService;

@ApplicationScoped
public class CriaToken {
    @Inject
    UsuarioService usuarioService;

    public String getToken(LoginDto login) throws ObjectNotFoundException {
        UsuarioEntity usuario = usuarioService.getByEmail(login.getEmail());

        if (usuario == null) {
            throw new ObjectNotFoundException("usuario Não encontrado");
        }

        if (usuario.getSenha() == login.getSenha()) {
            throw new ObjectNotFoundException("usuario Não encontrado");
        }

        Instant now = Instant.now();
        Instant expirationTime = now.plus(30, ChronoUnit.DAYS);

        String token = Jwt
                .upn(usuario.getEmail())
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .expiresAt(expirationTime)
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();
        return token;
    }
}
