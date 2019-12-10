package ManagedBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import model.Packs;
import services.PackService;

@Named
@RequestScoped
public class ChartView implements Serializable {
 

    private PieChartModel pieModel1;
    private LineChartModel dateModel;
    private BarChartModel animatedModel2;
    private BarChartModel barModel;
    
    
    private String colorPopup;
 




   @EJB
   private PackService service;
 


   public String getColorPopup() {
       return colorPopup;
   }

   public void setColorPopup(String colorPopup) {
       this.colorPopup = colorPopup;
   } 

  
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
   
 
    public PieChartModel getPieModel1() {
        createPieModel1();
        return pieModel1;
    }
 
    public BarChartModel getBarModel() {
        createBarModels();
        return barModel;
    }
    
    public LineChartModel getDateModel() 
{
        createDateModel();

        return dateModel;
    }
 
    
    public BarChartModel getAnimatedModel2() {
        createAnimatedModels();
        return animatedModel2;
    }
   
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        
        for (Packs p : service.findAllPacks()) {
            pieModel1.set(p.getPackName(), p.getQuantity());

		}
     
 
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
 
    
    private void createDateModel() {
        dateModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        for (Packs p : service.findAllPacks()) {
            series1.set(p.getStartDate(), p.getPackId());

        }
        
   
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        for (Packs p : service.findAllPacks()) {
            series1.set(p.getEndDate(), p.getPackId());

        }
 
 
        dateModel.addSeries(series1);
        dateModel.addSeries(series2);
 
        dateModel.setTitle("Zoom for Details");
        dateModel.setZoom(true);
        //dateModel.getAxis(AxisType.Y).setLabel("Values");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setTickFormat("%b %#d, %y");
 
        dateModel.getAxes().put(AxisType.X, axis);

        
        
        
    }
    
    private BarChartModel initBarModel() {

    	
        BarChartModel model = new BarChartModel();
 
        ChartSeries packname = new ChartSeries();
        packname.setLabel("StartDate");
      	List<Object[]> l = service.nbproductpack();

       
      	for (Object[] aRow : l) {
            String name = (String) aRow[1];
            int count =((Long) aRow[0]).intValue();

            packname.set(name, count);
   	  
  	}

// 
//        ChartSeries nbprod = new ChartSeries();
//        nbprod.setLabel("Number of Products");
//        
//   for (Object[] aRow : l) {
//	  	  int count =((Long) aRow[0]).intValue();
//
//   	nbprod.set(count, count);
//
// 	  
//	}
        

       
      
      	
      	
 
        model.addSeries(packname);
 
        return model;
    }
 

 
    private void createAnimatedModels() {
 
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Bar Charts");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
//        yAxis = animatedModel2.getAxis(AxisType.Y);
//        yAxis.setMin(0);
//        yAxis.setMax(200);
    }
  
    private void createBarModels() {
        createBarModel();
    }
    
    
    private BarChartModel initBarModel2() {
        BarChartModel model = new BarChartModel();
    	List<Object[]> start = service.nbpackstartdate();
      	List<Object[]> end = service.nbpackenddate();
        ChartSeries series1 = new ChartSeries();
        series1.setLabel("Pack Name");
      

//       
//      	 for (Packs p : service.findAllPacks()) {
//      		series1.set(p.getStartDate(), p.getPackId());
//
//         }
//    	
//
//      	
//     
// 
//       ChartSeries series2 = new ChartSeries();
//       series2.setLabel("EndDate");
//       
//       for (Packs p : service.findAllPacks()) {
//    	   series2.set(p.getEndDate(),p.getPackId());
//
//       }
  	
      	
      	
       	for (Object[] aRow : start) {
            Date date = (Date) aRow[0];
            int count =((Long) aRow[1]).intValue();
            series1.set(date, count);
   	  
  	}

     ChartSeries series2 = new ChartSeries();
    series2.setLabel("EndDate");
      	for (Object[] aRow : end) {
            Date date = (Date) aRow[0];
            int count =((Long) aRow[1]).intValue();
            series2.set(date, count);
  	}

    model.addSeries(series1);
    model.addSeries(series2);
    return model;
}
    
    private void createBarModel() {
        barModel = initBarModel2();
 
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
        barModel.setAnimate(true);

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("StartDate/EndDate");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("PackId");
        yAxis.setMin(0);
        yAxis.setMax(50);
    }
    
    
    

    
    
}
