// package mario.russo;

// import java.util.List;

// import jakarta.inject.Inject;
// import jakarta.transaction.Transactional;
// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;
// import mario.russo.core.domain.Conteudo;
// import mario.russo.infra.adapter.ConteudoRepositoryImpl;

// @Path("/conteudo")
// public class GreetingResource {
//     @Inject
//     ConteudoRepositoryImpl repository;

//     @GET
//     @Produces(MediaType.APPLICATION_JSON)
//     public List<Conteudo> hello() {
//        List<Conteudo> conteudo =repository.listAll();
//         return conteudo;
//     }
//     // @GET("/{id}")
//     // @Produces(MediaType.APPLICATION_JSON)
//     // public List<Conteudo> hello() {
//     //    List<Conteudo> conteudo =repository.listAll();
//     //     return conteudo;
//     // }
//     @POST
//     @Transactional
//     @Produces(MediaType.APPLICATION_JSON)
//     public void save(Conteudo conteudo) {
//         repository.save(conteudo);
//     }
// }
