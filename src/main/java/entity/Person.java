package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQuery (
        name = "findByEmail",
        query = "SELECT p FROM Person p WHERE p.email = :email "
)

@NamedQuery (
        name = "findAll",
        query = "SELECT p FROM Person p"
)

@NamedQuery (
		name = "findLike",
		query = "SELECT p FROM Person p WHERE p.firstName LIKE CONCAT('%', :pattern, '%')"
				+ " OR p.lastName LIKE CONCAT('%', :pattern, '%')"
				+ " OR p.website LIKE CONCAT('%', :pattern, '%')"
)

@Entity(name = "Person")
@Table(name = "TPerson")
public class Person implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id()
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @NotNull(message = "Le champ Prénom est vide")
   @NotBlank(message = "Le champ Prénom est vide")
   @Basic(optional = false)
   @Column(name = "firstname", length = 25, nullable = false)
   private String firstName;

   @NotNull(message = "Le champ Nom est vide")
   @NotBlank(message = "Le champ Nom est vide")
   @Basic(optional = false)
   @Column(name = "lastname", length = 25,nullable = false)
   private String lastName;

   @NotNull(message = "Le champ Email est vide")
   @NotBlank(message = "Le champ Email est vide")
   @Basic(optional = false)
   @Column(name = "email", length = 65,
      nullable = false, unique = true, insertable = true, updatable = false)
   private String email;

   @NotNull(message = "Le champ Webdite est vide")
   @NotBlank(message = "Le champ Website est vide")
   @Basic(optional = false)
   @Column(name = "website", length = 200,
      nullable = false, unique = true)
   private String website;

   @Basic(optional = false)
   @Temporal(TemporalType.DATE)
   @Column(name = "birthday")
   private Date birthday;
   
   @Basic(optional = false)
   @Column(name = "password", length = 30, nullable = false)
   private String PassWord;
   
   @ManyToOne(optional = true)
   @JoinColumn(name = "team")
   private Group team; 
   
 
   @Transient
   public static long updateCounter = 0;

   public Person() {
      super();
   }

   public Person(String firstName, String lastName, Date birthDay, String Email, String WebSite, String PassWord) {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthday = birthDay;
      this.email = Email;
      this.website = WebSite;
      this.PassWord = PassWord;
   }

   @PreUpdate
   public void beforeUpdate() {
      System.err.println("PreUpdate of " + this);
   }

   @PostUpdate
   public void afterUpdate() {
      System.err.println("PostUpdate of " + this);
      //updateCounter++;
   }

   @Override
   public String toString() {
      return "Person(id=" + getId() + "," + "firstName=" + getFirstName() + "," + "lastName=" + getLastName() + "," + 
    		  "birthDay=" + getBirthday() +  "," + "Email=" + getEmail() + "," + "WebSite=" + getWebsite() + "," 
            + "password=" + getPassWord() + ")";
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   
   public String getLastName() {
	      return lastName;
   }

   public void setLastName(String lastName) {
	      this.lastName = lastName;
   }
   
   public Date getBirthday() {
	      return birthday;
   }

   public void setBirthday(Date birthDay) {
	      this.birthday = birthDay;
   }
   
   public String getPassWord() {
	      return PassWord;
   }

   public void setPassWord(String PassWord) {
	      this.PassWord = PassWord;
   }
   
   public Group getTeam() {
		      return team;
	}
	
	public void setTeam(Group team) {
		   this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}