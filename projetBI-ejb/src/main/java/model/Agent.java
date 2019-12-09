package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Agents database table.
 * 
 */
@Entity
@Table(name="Agents")
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AgentId")
	private int agentId;

	@Column(name="AgentName")
	private String agentName;

	@Column(name="TasktId")
	private int tasktId;

	@Column(name="Type")
	private String type;

	public Agent() {
	}

	public int getAgentId() {
		return this.agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public int getTasktId() {
		return this.tasktId;
	}

	public void setTasktId(int tasktId) {
		this.tasktId = tasktId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}