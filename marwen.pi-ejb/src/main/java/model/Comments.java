package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Comments database table.
 * 
 */
@Entity
@NamedQuery(name="Comments.findAll", query="SELECT c FROM Comments c")
public class Comments implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CommentId")
	private int commentId;

	@Column(name="Content")
	private String content;

	@Column(name="ForumId")
	private int forumId;

	//bi-directional one-to-one association to Fora
	@OneToOne
	@JoinColumn(name="CommentId")
	private Fora fora;

	public Comments() {
	}

	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getForumId() {
		return this.forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public Fora getFora() {
		return this.fora;
	}

	public void setFora(Fora fora) {
		this.fora = fora;
	}

}