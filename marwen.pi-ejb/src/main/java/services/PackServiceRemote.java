package services;

import java.util.List;

import javax.ejb.Remote;

import model.Packs;
import model.ProductPack;


@Remote
public interface PackServiceRemote {
	public void ajouterPack(Packs Pack);
	public void modifierPack (int idPack, String packName);
	public void supprimerPack (int idPack);
	public  List<Packs> findAllPacks();
	public void modifierPacks(Packs pack);
	public  List<Object[]> nbproductpack();
	public void SmsSender();
	public  Object findPackbyname(String name);
	public Packs findPackbynamee(String name);

}
