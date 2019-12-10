package ManagedBean;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.persistence.Column;
import javax.persistence.Query;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.json.JSONArray;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import ManagedBean.DataGridView;
import model.Packs;
import services.PackService;

@ManagedBean
@SessionScoped 
public class PacksupdateBean implements Serializable{

	private String destination="C:\\Users\\Marwen\\4ERP-BI2\\marwen.pi\\marwen.pi-web\\src\\main\\webapp\\resources\\uploads\\";


    @EJB
    PackService packService;
    
    private UploadedFile file;
    
	private String description;
	private Date endDate;
	private String imgUrl;
	private String packName;
	private int quantity; 
	private Date startDate;
	private String typePack;
	private List<Packs> packs;
	private int idforupdate;
	private String imgUrls="1111.png";


	
	

  
    
    
    
	
	
	public String getImgUrls() {
		
		return imgUrls;
	}


	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}


	public int getIdforupdate() {
		return idforupdate;
	}


	public void setIdforupdate(int idforupdate) {
		this.idforupdate = idforupdate;
	}



	private Date currentday = new Date();
	
	
	public Date getCurrentday() {
		return currentday;
	}


	public void setCurrentday(Date currentday) {
		
		this.currentday = currentday;
	}


	public List<Packs> getPacks() {
	
		
		packs=packService.findAllPacks();
		return packs;

}



	
	
	
	


public void setPacks(List<Packs> packs) {
	this.packs = packs;
}

	public PackService getPackService() {
		return packService;
	}
	public void setPackService(PackService packService) {
		this.packService = packService;
	}
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
	

	public void supprimer(int employeid) {
		packService.supprimerPack(employeid);
	}
	
	private String pn;
	
	
	public String getPn() {
		pn=Json();
		return pn;
	}


	public void setPn(String pn) {
		this.pn = pn;
	}


	public String Json() {
         
		String  pp="";

	      
      	for (Object[] aRow : packService.findPackbyname(pn)) {
            String packname = (String) aRow[0];
            int quantity =(int) aRow[1];
            Date startdate = (Date) aRow[2];
            Date enddate = (Date) aRow[3];
         setImgUrls((String) aRow[4]);    
            pp="PackName : "+packname+"Quantity : "+quantity+"StartDate : "+startdate.toString()+"EndDate :"+enddate.toString();
  	}
	//String  pp=(String)packService.findPackbyname(pn);


   	 
	
//		  JSONArray jsonArray = new JSONArray(packService.findPackbyname(pn));
		
	return pp;
	}
	
	
	

	
	
	public String redirectproduct(Packs pack) {		
		  this.setPackName(pack.getPackName());
		  this.setDescription(pack.getDescription());
		  this.setImgUrl(pack.getImgUrl());
		  this.setStartDate(pack.getStartDate());
		  this.setEndDate(pack.getEndDate());
		  this.setTypePack(pack.getTypePack());
		  this.setQuantity(pack.getQuantity());
		  this.setIdforupdate(pack.getPackId());

		  return "/PackShow?faces-redirect=true";


		}
	
	 public void reset() {
	        PrimeFaces.current().resetInputs("form:panel");
	    }
	
	public String modifier(Packs pack) {		
	  this.setPackName(pack.getPackName());
	  this.setDescription(pack.getDescription());
	  this.setImgUrl(pack.getImgUrl());
	  this.setStartDate(pack.getStartDate());
	  this.setEndDate(pack.getEndDate());
	  this.setTypePack(pack.getTypePack());
	  this.setQuantity(pack.getQuantity());
	  this.setIdforupdate(pack.getPackId());

	  return "/Packupdate?faces-redirect=true";


	}
	
	public String update() throws IOException {
		 upload();
		    TransferTile(file.getFileName(),file.getInputstream());
		packService.modifierPacks(new Packs(description,endDate,file.getFileName(),packName,quantity,startDate,typePack,idforupdate));
		  return "/PackShow?faces-redirect=true";

	}
	
	
	
	

	 
	 
	 //upload
	  public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }
	 
	 
	 
	    public void upload() {
	    	
	        if (file != null) {
	            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	    }
	     
	    
	    public void handleFileUpload(FileUploadEvent event) {
	        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
	
	
	    public void TransferTile(String fileName,InputStream in) {
	    try {
	    OutputStream out = new FileOutputStream(new File(destination+fileName)); 
	    		int reader = 0;
	    		byte[] bytes = new byte[(int) file.getSize()] ; 
	    		while ((reader = in.read(bytes)) != -1) 
	    			{out.write(bytes,0, reader); }
	    		in.close(); 
	    		out.flush(); 
	    		out.close(); 
	    }
	    			catch (IOException e) 
	    {  System.out.println(e.getMessage());}
	    }
	    
}
	   

