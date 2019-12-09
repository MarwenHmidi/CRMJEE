package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entites.Commentaire;
import services.CommentaireService;

@Path("Commentaire")
@SessionScoped
public class CommentaireRessources {

	private List<Commentaire> l;
	@EJB
	CommentaireService cs;
	@Path("/comm/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commentaire> getAll(@PathParam("id") int id) {
		
		l = cs.getCommentsById(id);
		return l;
	}
	@Path("post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addcat(Commentaire cat) {

 cs.ajouter(cat);
			return Response.created(null).build();}

	
	
}
