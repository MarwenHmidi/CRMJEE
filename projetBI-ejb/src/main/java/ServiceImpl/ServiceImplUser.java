package ServiceImpl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Service.UserService;
import model.Client;
import model.User;

@Stateless
@LocalBean
public class ServiceImplUser implements UserService {
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public User getUserByEmailAndPassword(String email, String password) {

		TypedQuery<User> query = em.createQuery("select e from User e WHERE e.email=:email and e.password=:password ",
				User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}

}
