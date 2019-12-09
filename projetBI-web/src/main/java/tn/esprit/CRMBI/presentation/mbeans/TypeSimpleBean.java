package tn.esprit.CRMBI.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


public class TypeSimpleBean {

	private List<String> listeTypeSimpleAttribut;

	public List<String> getLsttypeAttribut() {

		listeTypeSimpleAttribut = new ArrayList<String>();
		listeTypeSimpleAttribut.add("String");
		listeTypeSimpleAttribut.add("int");
		listeTypeSimpleAttribut.add("float");
		listeTypeSimpleAttribut.add("double");
		listeTypeSimpleAttribut.add("boolean");
		listeTypeSimpleAttribut.add("Date");
		
		return listeTypeSimpleAttribut;
	}
}
