package ch.bbw.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.bbw.addressbook.Address;
import ch.bbw.addressbook.AddressDAO;

public class AddressDAOMockup implements AddressDAO {

	private List<Address> addresses;
	
	@Override
	public void create(Address address) {
		addresses.add(address);
		
	}

	@Override
	public Address read(int id) {
		return addresses.get(id-1);
	}

	@Override
	public List<Address> readAll() {
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address(1, "Petra", "Muster", "000 0000 0000", new Date()));
		addresses.add(new Address(2, "Peter", "Muster", "000 0000 0000", new Date()));
		addresses.add(new Address(3, "Fritz", "Müller", "000 0000 0000", new Date()));
		addresses.add(new Address(4, "Dario", "Andres", "000 0000 0000", new Date()));
		return addresses;
	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
