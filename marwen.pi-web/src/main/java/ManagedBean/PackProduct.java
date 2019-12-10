package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Packs;
import model.Products;
import services.PackProductService;
@ManagedBean
@SessionScoped
public class PackProduct implements Serializable {
	
	@EJB
	PackProductService packService;
	
	
	
    
	private String description;
	private Date endDate;
	private String imgUrl;
	private String packName;
	private int quantity; 
	private Date startDate;
	private String typePack;
	
	
	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public Date getEndDate() {
		return endDate;
	}







	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}







	public String getImgUrl() {
		return imgUrl;
	}







	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}







	public String getPackName() {
		return packName;
	}







	public void setPackName(String packName) {
		this.packName = packName;
	}







	public int getQuantity() {
		return quantity;
	}







	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}







	public Date getStartDate() {
		return startDate;
	}







	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}







	public String getTypePack() {
		return typePack;
	}







	public void setTypePack(String typePack) {
		this.typePack = typePack;
	}

	private List<Products> products;

	private List<Packs> packs;
	
	private int packId;
	private List<String> productId;

    
private List<String> display;



	public List<String> getDisplay() {
		display=display();
		
	
	return display;
}

private String f1;
private Long f2;
private Date f3;
private Date f4;
private String f5;
private Long f6;



public String getF1() {
	System.out.print("tohemi"+productname());
	f1=productname();
	return f1;
}







public void setF1(String f1) {
	
	this.f1 = f1;
}


public String productname() {
	return (String)packService.ProductName(1);
}





public Long getF2() {
	return f2;
}







public void setF2(Long f2) {
	this.f2 = f2;
}







public Date getF3() {
	return f3;
}







public void setF3(Date f3) {
	this.f3 = f3;
}







public Date getF4() {
	return f4;
}







public void setF4(Date f4) {
	this.f4 = f4;
}







public String getF5() {
	return f5;
}







public void setF5(String f5) {
	this.f5 = f5;
}







public Long getF6() {
	return f6;
}







public void setF6(Long f6) {
	this.f6 = f6;
}







public void setDisplay(List<String> display) {
	this.display = display;
}







	public List<String>  display() {
	   	List<Object[]> le = packService.CustomFind();

	   	List<String> strings = new ArrayList<>(le.size());
	   	for (Object[] object : le) {
	   		f1=(String)object[0];
	   		f2=(Long)object[1];
	   		f3=(Date)object[2];
	   		f4=(Date)object[3];
	   		f5=(String)object[4];
	   		f6=(Long)object[5];
	   	
	   	}
		
	 
	 	
		//pk.packName,pk.quantity,pk.startDate,pk.endDate,prd.title,prd.price
//	 	for (Object[] aRow : le) {
 			 		
//	 		display.addAll(aRow.toString());
	 		
	 		
	return strings;
	}
	 	







	public List<Products> getProducts() {
	
		
		
		products=packService.findAllProducts();

		return products;
	}




	public void setProducts(List<Products> products) {
		this.products = products;
	}




	public String addProduct() {

	 packService.ajouterProductPack(packId, productId);
    return "/PackProductShow?faces-redirect=true";

	}




	public List<Packs> getPacks() {
			
			packs=packService.findAllPacks();
			return packs;
	
	}




	public void setPacks(List<Packs> packs) {
		this.packs = packs;
	}




	
	
	
	public String redirectPack(Packs pack) {		
		  this.setPackName(pack.getPackName());
		  this.setDescription(pack.getDescription());
		  this.setImgUrl(pack.getImgUrl());
		  this.setStartDate(pack.getStartDate());
		  this.setEndDate(pack.getEndDate());
		  this.setTypePack(pack.getTypePack());
		  this.setQuantity(pack.getQuantity());

		  return "/PackProductDetailed?faces-redirect=true";


		}


	public int getPackId() {
		return packId;
	}




	public void setPackId(int packId) {
		this.packId = packId;
	}




	public PackProductService getPackService() {
		return packService;
	}




	public void setPackService(PackProductService packService) {
		this.packService = packService;
	}




	public List<String> getProductId() {
		return productId;
	}




	public void setProductId(List<String> productId) {
		this.productId = productId;
	}






	public String DeleteProductfromPack(int productid, int packid) {
        packService.DeleteProductFromPack(productid, packid);
           return "/PackProductShow?faces-redirect=true";

       }




}
