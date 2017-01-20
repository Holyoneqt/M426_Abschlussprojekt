package ch.bbw.addressbook;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AddressService {
	
	@Inject
	@Named("AddressDAO")
	private AddressDAO addressDAO;
	
	
	public List<Address> getAllAddresses() {
		List<Address> addresses = addressDAO.readAll();
		addresses.sort(new AddressComparator());
		
		return addresses;
	}
	
	public List<Address> getAllAddressesSorted(String sort) {
		List<Address> addresses = addressDAO.readAll();
		addresses.sort(new AddressComparator());
		
		return addresses;
	}
	
	public void registerAddress(Address address) {
		
		// TODO: Hier Registrierungsdatum setzen
		
		address.setRegistrationDate(new Date());
		
		
		addressDAO.create(address);
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
