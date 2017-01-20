package ch.bbw.addressbook;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddressViewController {
	
	@Inject
	private AddressService addressService;
	
	private String orderBy = "lastname";
	
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private int category;
    private String city;
    private String gender;
    
    private String message;
        
    public AddressViewController() {
    	message = "";
	}

    private void clearFields() {
        firstname = "";
        lastname = "";
        phoneNumber = "";    	
    }
        
    public void orderByChanged(ValueChangeEvent e) {
    	this.orderBy = e.getNewValue().toString();
    	System.out.println("ORDER BY:" + this.orderBy);
    }
    
    public void saveAddress() {
        Address address = new Address(0, firstname, lastname, phoneNumber,email,category,city,gender);
        addressService.registerAddress(address);
        message = "The address was saved successfully.";
        clearFields();
    }
    
    public List<Address> getAddresses() {
        return addressService.getAllAddresses(orderBy);
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
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

	public String getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
