package ManagedBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import model.Packs;
import model.ProductPack;
import services.PackService;

@ManagedBean
@SessionScoped 
public class DataGridView implements Serializable {
     
	
	


	 
  
    private List<Packs> cars;
     
    private Packs selectedCar;
    
    
     
    @EJB
    private PackService service;
     
    @PostConstruct
    public void init()   {


    	

    }
 

    public List<Packs> getCars() {
       List<Packs> lf= new ArrayList<>();
       Date current = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Packs p : service.findAllPacks()) {
//        	System.out.println(sdf.format(p.getEndDate()));
//        			System.out.println(sdf.format(current));
//        	System.out.println(sdf.format(p.getEndDate()).compareTo(sdf.format(current)));

            if(p.getEndDate().compareTo(current)<0)
            {
            	service.supprimerPack(p.getPackId());
            }
            else {
            	lf.add(p);
            }
        }
//        cars = service.findAllPacks();
  cars = lf;

    	
	
        return cars;
    }
 
    public void setService(PackService service) {
        this.service = service;
    }
 
    public Packs getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Packs selectedCar) {
        this.selectedCar = selectedCar;
    }
}