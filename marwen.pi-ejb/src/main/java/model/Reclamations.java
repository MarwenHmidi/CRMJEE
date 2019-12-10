package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reclamations database table.
 * 
 */
@Entity
@Table(name="reclamations")
@NamedQuery(name="Reclamations.findAll", query="SELECT r FROM Reclamations r")
public class Reclamations implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Idrec")
	private int idrec;

	private String contenu;

	private Date date;

	private String etat;

	private String objet;

	private String titre;

	private String type;

	public Reclamations() {
	}

	public int getIdrec() {
		return this.idrec;
	}

	public void setIdrec(int idrec) {
		this.idrec = idrec;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getObjet() {
		return this.objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}