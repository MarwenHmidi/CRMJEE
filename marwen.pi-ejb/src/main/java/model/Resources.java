package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Resources database table.
 * 
 */
@Entity
@NamedQuery(name="Resources.findAll", query="SELECT r FROM Resources r")
public class Resources implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResourceId")
	private int resourceId;

	@Column(name="Date_Location")
	private Date date_Location;

	@Column(name="TypeResource")
	private String typeResource;

	public Resources() {
	}

	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public Date getDate_Location() {
		return this.date_Location;
	}

	public void setDate_Location(Date date_Location) {
		this.date_Location = date_Location;
	}

	public String getTypeResource() {
		return this.typeResource;
	}

	public void setTypeResource(String typeResource) {
		this.typeResource = typeResource;
	}

}