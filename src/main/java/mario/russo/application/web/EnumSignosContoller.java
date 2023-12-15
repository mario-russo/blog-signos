package mario.russo.application.web;

import java.util.Arrays;
import java.util.stream.Collectors;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mario.russo.core.domain.SignoZodiaco;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("signos")
public class EnumSignosContoller {

    @GET
    public Response listAllSignos() {
        return Response.ok().entity(Arrays.asList(SignoZodiaco.values())).build();
    }
}
