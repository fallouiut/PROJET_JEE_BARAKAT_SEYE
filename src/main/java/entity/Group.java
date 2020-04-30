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
	private String groupName;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REMOVE },	     
	fetch = FetchType.LAZY, mappedBy = "team")
	private Set<Person> persons;

	public Group () {
		
	}
	
	public Group(String GroupName) {
	      super();
	      this.groupName = GroupName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long GroupId) {
		this.id = GroupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String GroupName) {
		this.groupName = GroupName;
	}
	
	@Override
	public String toString() {
		return "Group(id=" + getId() + "," + "GroupName" + getGroupName() + ")";
	}
	
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPerson(Set<Person> person) {
		this.persons = person;
	}

	public void addPerson(Person p) {
		if (persons == null) {
			persons = new HashSet<>();
		}
		persons.add(p);
		p.setTeam(this);
	} 
	
}
