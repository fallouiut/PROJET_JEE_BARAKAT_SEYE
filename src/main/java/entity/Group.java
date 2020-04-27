package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REMOVE },	     
	fetch = FetchType.LAZY, mappedBy = "team")
	private Set<Person> person;

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
	
	public Set<Person> getPerson() {
		return person;
	}

	public void setPerson(Set<Person> person) {
		this.person = person;
	}

	public void addPerson(Person p) {
		if (person == null) {
			person = new HashSet<>();
		}
		person.add(p);
		p.setTeam(this);
	} 
	
}
