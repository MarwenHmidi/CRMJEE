package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIColumn;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import model.Packs;
import services.PackService;

@Named("dtEditView")
@ViewScoped
public class EditView implements Serializable {
     
    private List<Packs> cars1;
    private List<Packs> cars2;
         
    @Inject
    private  PackService service;
     
    @PostConstruct
    public void init() {
        cars1 = service.findAllPacks();
        cars2 = service.findAllPacks();
    }
 
    public List<Packs> getCars1() {
        return cars1;
    }
 
    public List<Packs> getCars2() {
        return cars2;
    }
     
    public List<String> getBrands() {
    	List<String> s  = new ArrayList<>();
    	for (Packs p : service.findAllPacks()) {
			s.add(p.getPackName());
		}
        return s;
    }
     
    public List<String> getColors() {
    	List<String> s  = new ArrayList<>();
    	for (Packs p : service.findAllPacks()) {
			s.add(p.getDescription());
		}
        return s;   
        }
 
    public void setService(PackService service) {
        this.service = service;
    }
     
    public void onRowEdit(RowEditEvent event) {
    	System.out.print("marwenhmidi69"+event.getObject().toString());
        FacesMessage msg = new FacesMessage("Car Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	System.out.print("aaaaaaaaaaaa"+event.getObject().toString());
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}            