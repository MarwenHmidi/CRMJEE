package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Fora database table.
 * 
 */
@Entity
@NamedQuery(name="Fora.findAll", query="SELECT f FROM Fora f")
public class Fora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ForumId")
	private int forumId;

	@Column(name="Date_Pub")
	private Date date_Pub;

	@Column(name="Description")
	private String description;

	@Column(name="Title")
	private String title;

	//bi-directional one-to-one association to Comments
	@OneToOne(mappedBy="fora")
	private Comments comment;

	public Fora() {
	}

	public int getForumId() {
		return this.forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public Date getDate_Pub() {
		return this.date_Pub;
	}

	public void setDate_Pub(Date date_Pub) {
		this.date_Pub = date_Pub;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Comments getComment() {
		return this.comment;
	}

	public void setComment(Comments comment) {
		this.comment = comment;
	}

}