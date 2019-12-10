package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.spi.Producer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import model.Packs;
import model.ProductPack;
import model.ProductPackPK;
import model.Products;

/**
 * Session Bean implementation class PackProductService
 */
@Stateless
@LocalBean
public class PackProductService implements PackProductServiceRemote, PackProductServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public PackProductService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterProductPack(int packid,List<String>prods) {
		// TODO Auto-generated method stub
	
		for (String nb : prods) {
			
		//SmsSender(" New Pack "+String.valueOf(PackName(packid))+"Product"+String.valueOf(ProductName(Integer.parseInt(nb))));


			ProductPackPK packPK = new ProductPackPK();
		packPK.setPackId(packid);

		packPK.setProductId(Integer.parseInt(nb));
		
		ProductPack pack = new ProductPack();
		pack.setEndDate(new Date());
		pack.setStartDate(new Date());
		pack.setId(packPK);	
		em.persist(pack);

		}
	}
	
	@Override
	public void ajoutProductPack() {
		// TODO Auto-generated method stub
		/*List<Products> products = new ArrayList<Products>();
		Products prod= em.find(Products.class, prodid);
		Packs pack = em.find(Packs.class, packid);
		pack.setPackId(packid);
		products.add(prod);
		packs.
		em.persist(packs);*/	
		ProductPackPK packPK = new ProductPackPK();
		packPK.setPackId(1);
		packPK.setProductId(1);
		ProductPack pack = new ProductPack();
		pack.setEndDate(new Date());
		pack.setStartDate(new Date());
		pack.setId(packPK);		

		em.persist(pack);
		

	}
	
	public  List<Object[]> CustomFind() {
		

		 
		
		 Query query = em.createQuery(
	 		"SELECT  pk.packName,pk.quantity,pk.startDate,pk.endDate,prd.title,prd.price FROM Packs pk INNER JOIN ProductPack p  ON pk.packId=p.id.packId INNER JOIN Products prd ON prd.productId=p.id.productId");
			
		

			 
		 List<Object[]> results = query.getResultList();
			


			 
		    return results;
		}
	
	
	
	
	
	
	
	

	public List<Integer> findPackProductsdid() {
		 
		    return em.createQuery("SELECT distinct(p.id.packId) FROM Packs pk INNER JOIN ProductPack p  ON pk.packId=p.id.packId").getResultList();      
		}
	
	public List<Packs> findaAllPackProductsDid() {
	
		List<Packs> packPKss = new ArrayList<Packs>();
		
		
		List<Integer> le = findPackProductsdid();
		
		for (Integer aRow : le) {
		 List<Packs> qq1 = em.createQuery("SELECT p FROM Packs p  where p.id.packId="+aRow, Packs.class).getResultList()  ; 
		 
		 packPKss.add(qq1.get(0));
		}
		
		    return packPKss;      
		}
	
	
	public List<ProductPack> findPackProductbyid(int id) {
		List<ProductPack> Productspack = em.createQuery("SELECT p FROM ProductPack p  where p.id.packId="+id, ProductPack.class).getResultList(); 
		    return Productspack;      
		}
	
	public List<Products> findProductbyid(int id) {
		List<Products> Products = em.createQuery("SELECT p FROM Products p  where p.id.productId="+id, Products.class).getResultList()  ; 
		    return Products;      
		}
	
	
	

	
	
	
	
	

	
	public List<Packs> findAllPacks() {
		
	    return em.createQuery("SELECT a FROM Packs a", Packs.class).getResultList();      
	}
public List<Products> findAllProducts() {
		
	    return em.createQuery("SELECT a FROM Products a", Products.class).getResultList();      
	}
	


public Object PackName(int id) {
	

	
	 Query query = em.createQuery("SELECT pk.packName FROM Packs pk where pk.packId=:id");
	 query.setParameter("id",id);
	 Object results = query.getSingleResult();
		


	    return results;
	}

public Object ProductName(int id) {
	

	
	 Query query = em.createQuery("SELECT pk.title FROM Products pk where pk.productId=:id");
	 query.setParameter("id",id);
	 Object results = query.getSingleResult();
		


	    return results;
	}







public static final String ACCOUNT_SID = "AC340a5ef4835d2ce3272b3104228f5222";
public static final String AUTH_TOKEN = "3f2ec2da3cbbae25f7ca5d13db99f06b";
public void SmsSender(String msg) {


	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator(new PhoneNumber("+21697582145"),
	        new PhoneNumber("+12562554584"), 
	        msg).create();

	    System.out.println(message.getSid());
}




public void  DeleteProductFromPack(int idProd, int idPack) {
    Query query1 = em.createQuery("DELETE FROM ProductPack pp WHERE pp.id.productId= "+idProd+" and pp.id.packId ="+idPack);
    query1.executeUpdate();
}







}
