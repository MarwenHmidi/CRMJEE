package ManagedBean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import model.Products;
import services.PackProductService;

@ManagedBean
@RequestScoped
public class PickListBean {
  private DualListModel<Products> listModel;

  @EJB
  private PackProductService service;
  
  @PostConstruct
  public void init() {
      //initial unselected list


  }

  
  public void onTransfer(TransferEvent event) {
      StringBuilder builder = new StringBuilder();
      for(Object item : event.getItems()) {
          builder.append(((Products) item).getProductId()).append("<br />");
      }
       
      FacesMessage msg = new FacesMessage();
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      msg.setSummary("Items Transferred");
      msg.setDetail(builder.toString());
       
      FacesContext.getCurrentInstance().addMessage(null, msg);
  }  
  
  
  
  
  
  public DualListModel<Products> getListModel() {
      List<Products> sourceList = service.findAllProducts();

      //initial selected list
      List<Products> destinationList = new ArrayList<>();
      listModel = new DualListModel<Products>(sourceList, destinationList);
	  for (Products p : listModel.getTarget()) {
		  System.out.println("sourceList"+ p.getTitle());

	}
	  
      return listModel;
  }

  public void setListModel(DualListModel<Products> listModel) {
	  
      this.listModel = listModel;
  }
}