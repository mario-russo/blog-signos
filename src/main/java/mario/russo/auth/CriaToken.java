package mario.russo.auth;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.ejb.ObjectNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.Rules;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.dto.AuthenticationTokenDTO;
import mario.russo.core.useCase.UsuarioService;

@ApplicationScoped
public class CriaToken {
    @Inject
    UsuarioService usuarioService;

    public AuthenticationTokenDTO getToken(LoginDto login) throws ObjectNotFoundException {
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
                .groups(arrayToHashSet(usuario.getRules()))
                .expiresAt(expirationTime)
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();
        return new AuthenticationTokenDTO(token, usuario.getId(), usuario.getNome());
    }

    private HashSet<String> arrayToHashSet(List<Rules> array) {
        HashSet<String> hashSet = new HashSet<>();

        for (Rules element : array) {
            hashSet.add(element.name());
        }

        return hashSet;
    }
}
