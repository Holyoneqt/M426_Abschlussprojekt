package ch.bbw.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ch.bbw.addressbook.Address;
import ch.bbw.addressbook.AddressDAO;
import ch.bbw.addressbook.AddressService;

public class JUnitMockito {

	private AddressDAO addressDAO;
	private List<Address> addresses;
	
	@Before
	public void setup(){
		
		addresses = new ArrayList<>();
		addresses.add(new Address(1, "Petra", "Muster", "000 0000 0000", new Date()));
		addresses.add(new Address(2, "Peter", "Muster", "000 0000 0000", new Date()));
		addresses.add(new Address(3, "Fritz", "Müller", "000 0000 0000", new Date()));
		addresses.add(new Address(4, "Dario", "Andres", "000 0000 0000", new Date()));
		
		addressDAO = Mockito.mock(AddressDAO.class);
		Mockito.when(addressDAO.readAll()).thenReturn(addresses);
	}
	
	@Test
	public void testSort(){
		
		AddressService addressService = new AddressService();
		addressService.setAddressDAO(addressDAO);
		
		List<Address> listFromService = addressService.getAllAddresses();
		
		Mockito.verify(addressDAO, Mockito.atLeastOnce()).readAll();
		
		assertTrue(listFromService.get(0).getId() == 4);
		assertTrue(listFromService.get(1).getId() == 2);
		assertTrue(listFromService.get(2).getId() == 1);
		assertTrue(listFromService.get(3).getId() == 3);
		
		assertTrue(listFromService.size()==4);
		
	}
	
}
