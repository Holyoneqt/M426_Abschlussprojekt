package ch.bbw.addressbook;

import java.util.Date;

public class Address {

	private int id;
	private String firstname;
    private String lastname;
    private String phonenumber;
    private Date registrationDate;
    private String email;
    private int category;
    private String city;
    private String gender;

    public Address(int id, String firstname, String lastname, String phonenumber, String email, int category, String city, String gender) {
    	this(id, firstname, lastname, phonenumber, null, email, category, city, gender);
    }
    public Address(int id, String firstname, String lastname, String phonenumber, Date registrationDate, String email, int category, String city, String gender) {
    	this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.registrationDate = registrationDate;
        this.email = email;
        this.category = category;
        this.city = city;
        this.gender = gender;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
