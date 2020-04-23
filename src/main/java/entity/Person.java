package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity(name = "Person")
@Table(name = "TPerson")
public class Person implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id()
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Basic(optional = false)
   @Column(name = "firstname", length = 25, nullable = false)
   private String firstName;
   
   @Basic(optional = false)
   @Column(name = "lastname", length = 25,nullable = false)
   private String lastName;

   @Basic(optional = false)
   @Column(name = "email", length = 65,
      nullable = false, unique = true, insertable = true, updatable = false)
   private String Email;
   
   @Basic(optional = false)
   @Column(name = "website", length = 200,
      nullable = false, unique = true)
   private String WebSite;

   @Basic(optional = false)
   @Temporal(TemporalType.DATE)
   @Column(name = "birthday")
   private Date birthDay;
   
   @Basic(optional = false)
   @Column(name = "password", length = 30, nullable = false)
   private String PassWord;
   
 
   @Transient
   public static long updateCounter = 0;

   public Person() {
      super();
   }

   public Person(String firstName, String lastName, Date birthDay, String Email, String WebSite, String PassWord) {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthDay = birthDay;
      this.Email = Email;
      this.WebSite = WebSite;
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
/*
   @Override
   public String toString() {
      return "Person(id=" + getId() + "," + "firstName" + getFirstName() + "," + "lastName" + getLastName() + "," + 
    		  "birthDay" + getBirthDay() +  "," + "Email" + getMail() + "," + "WebSite" + getWebSite() + "," 
            + "password" + getPassWord() + ")";
   }
*/
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
   
   public Date getBirthDay() {
	      return birthDay;
   }

   public void setBirthDay(Date birthDay) {
	      this.birthDay = birthDay;
   }

   public String getMail() {
	      return Email;
   }

   public void setMail(String Email) {
	      this.Email = Email;
   }
   
   public String getPassWord() {
	      return PassWord;
   }

   public void setPassWord(String PassWord) {
	      this.PassWord = PassWord;
   }

   public String getWebSite() {
	      return WebSite;
   }

   public void setWebSite(String WebSite) {
	   this.WebSite = WebSite;
   }
	
}