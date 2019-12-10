package services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import model.Packs;
import model.ProductPack;

/**
 * Session Bean implementation class PackService
 */
@Stateless
@LocalBean
public class PackService implements PackServiceRemote, PackServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
    public PackService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterPack(Packs Pack) {
		// TODO Auto-generated method stub
		em.persist(Pack);
	}

	@Override
	public void modifierPack(int idPack, String packName) {
		// TODO Auto-generated method stub
		Packs pack = em.find(Packs.class, idPack);
		pack.setPackName(packName);
		em.merge(pack);
	}

	@Override
	public void modifierPacks(Packs pack) {
		
		em.merge(pack);
	}
	
	@Override
	public void supprimerPack(int idPack) {
		// TODO Auto-generated method stub
		System.out.println("sssssssssssssssss"+idPack);
		Packs pack = em.find(Packs.class, idPack);
		em.remove(pack);
	}
	
	public List<Packs> findAllPacks() {
	
	    return em.createQuery("SELECT a FROM Packs a", Packs.class).getResultList();      
	}

	public  List<Object[]> nbproductpack() {
		
//		String hql = "select sum(p.price), p.category.name from Product p group by category";
//		Query query = session.createQuery(hql);
//		List<Object[]> listResult = query.list();
//		 
//		for (Object[] aRow : listResult) {
//		    Double sum = (Double) aRow[0];
//		    String category = (String) aRow[1];
//		    System.out.println(category + " - " + sum);
//		}

//		 Query query = em.createQuery("SELECT pk.packName,Count(*) FROM Products pd INNER JOIN ProductPack ppk ON pd.productId=ppk.id.productId"
//	 		+ "INNER JOIN Packs pk ON pk.packId=ppk.id.packId GROUP BY pk.packName");
		 
		
	 Query query = em.createQuery("SELECT Count(pk),pk.packName as name FROM Packs pk INNER JOIN ProductPack p  ON pk.packId=p.id.packId  GROUP BY pk.packName");
	 List<Object[]> results = query.getResultList();
		


		 
	    return results;
	}


	
	public  List<Object[]> nbpackstartdate() {
		

		
	 Query query = em.createQuery("SELECT startDate,Count(pk)  FROM Packs pk GROUP BY pk.startDate");
	 List<Object[]> results = query.getResultList();
		


		 
	    return results;
	}

	public  List<Object[]> nbpackenddate() {
		

		
		 Query query = em.createQuery("SELECT endDate,Count(pk)  FROM Packs pk GROUP BY pk.endDate");
		 List<Object[]> results = query.getResultList();
			


		    return results;
		}
	

	
	
	public List<Object[]> findPackbyname(String name) {
		
		
		 Query query = em.createQuery("SELECT pk.packName,pk.quantity,pk.startDate,pk.endDate,pk.imgUrl FROM Packs pk where pk.packName=:id");
		 query.setParameter("id", name);
		 List<Object[]> results = query.getResultList();
			


		    return results;
		}
	
	
	
	
	
	public Packs findPackbynamee(String name) {
		

		 Query query = em.createQuery("SELECT pk FROM Packs pk where pk.packName=:id",Packs.class);
		 query.setParameter("id", name);
		 Packs results =(Packs) query.getSingleResult();
			


		    return results;
		}
	
	
	
	  public static final String ACCOUNT_SID = "AC340a5ef4835d2ce3272b3104228f5222";
	  public static final String AUTH_TOKEN = "3f2ec2da3cbbae25f7ca5d13db99f06b";
	public void SmsSender() {
	

		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber("+21697582145"),
		        new PhoneNumber("+12562554584"), 
		        "sss").create();

		    System.out.println(message.getSid());
	}
	
	
	
	

}
