package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "Group")
@Table(name = "TGroup")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Basic(optional = false)
	@Column(name = "group_name", length = 200, nullable = false)
	private String GroupName;

	public Group () {
		
	}
	
	public Group(String GroupName) {
	      super();
	      this.GroupName = GroupName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long GroupId) {
		this.id = GroupId;
	}

	public String getGroupName() {
		return GroupName;
	}

	public void setGroupName(String GroupName) {
		this.GroupName = GroupName;
	}
	
	@Override
	public String toString() {
		return "Group(id=" + getId() + "," + "GroupName" + getGroupName() + ")";
	}
	
}
