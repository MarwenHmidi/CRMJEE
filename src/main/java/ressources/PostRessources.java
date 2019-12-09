package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entites.Commentaire;
import entites.Post;
import services.ForumService;
import services.PostService;

@Path("Post")
@SessionScoped
public class PostRessources {
	@EJB
	ForumService fs;
	PostService ps;
	List<Post> l;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getAll() {
		
		l = fs.getallPosts();
		return l;
	}	
	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam(value="id") int id )
	{
		if(fs.getallPosts().stream().anyMatch(obj -> obj.getPost_id() == id)) {
	fs.supprimer(id);
	return Response.status(Status.GONE).entity("true").build();
	}
		return Response.status(Status.NOT_FOUND).entity("false").build();
	}
	
	@POST
	@Path("/ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addcat(Post cat) {

 ps.ajouterpost1(cat);
			return Response.created(null).build();}

}
