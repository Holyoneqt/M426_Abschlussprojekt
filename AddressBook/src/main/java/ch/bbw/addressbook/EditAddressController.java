package ch.bbw.addressbook;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EditAddressController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AddressService addressService;
	
	private Address address;
	private String firstname;
    private String lastname;
    private String phonenumber;
    private Date registrationDate;
    private String email;
    private int category;
    private String city;
    private String gender;
	
	public String init(Address a) {
		this.address = a;
		this.firstname = a.getFirstname();
		this.lastname = a.getLastname();
		this.phonenumber = a.getPhonenumber();
		this.registrationDate = a.getRegistrationDate();
		this.email = a.getEmail();
		this.category = a.getCategory();
		this.city = a.getCity();
		this.gender = a.getGender();
		return "updateAddress.xhtml";
	}
	
	public String update() {
		this.address.setFirstname(firstname);
		this.address.setLastname(lastname);
		this.address.setPhonenumber(phonenumber);
		this.address.setRegistrationDate(registrationDate);
		this.address.setEmail(email);
		this.address.setCategory(category);
		this.address.setCity(city);
		this.address.setGender(gender);
		addressService.update(address);
		return "showAddresses.xhtml";
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
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
