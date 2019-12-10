package services;

import java.util.List;

import javax.ejb.Remote;

import model.Packs;
import model.ProductPack;
import model.Products;


@Remote
public interface PackProductServiceRemote {
	
	public void ajouterProductPack(int packid,List<String>prods);
	public void ajoutProductPack();
	public  List<Object[]> CustomFind();
	public List<Integer> findPackProductsdid();
	public List<ProductPack> findPackProductbyid(int id);
		public List<Products> findProductbyid(int id);
		public List<Packs> findaAllPackProductsDid();
		public void SmsSender(String msg);
		public Object PackName(int id);
		public Object ProductName(int id);
		public void  DeleteProductFromPack(int idProd, int idPack);
}
