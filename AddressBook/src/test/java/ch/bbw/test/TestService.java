package ch.bbw.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ch.bbw.addressbook.Address;
import ch.bbw.addressbook.AddressService;

public class TestService {

	@Test
	public void testService() {
		AddressService addressService = new AddressService();
		addressService.setAddressDAO(new AddressDAOMockup());
		
		List<Address> list = addressService.getAllAddresses();
		
		List<Address> list2 = addressService.getAllAddresses();
		
		for (int i=0; i<list.size()-1; i++){
			int compLastname = list.get(i).getLastname().compareTo(list.get(i+1).getLastname());
			assertTrue(compLastname==0 || compLastname<0);
			if(compLastname==0){
				int compFirstname = list.get(i).getFirstname().compareTo(list.get(i+1).getFirstname());
				assertTrue(compFirstname==0 || compFirstname<0);
				if(compFirstname==0){
					int compDate = list.get(i).getRegistrationDate().compareTo(list.get(i+1).getRegistrationDate());
					assertTrue(compDate==0 || compDate>0);
				}
			}
		}

		assertTrue(list.get(0).getId() == list2.get(0).getId());
		assertTrue(list.get(1).getId() == list2.get(1).getId());
		assertTrue(list.get(2).getId() == list2.get(2).getId());
		assertTrue(list.get(3).getId() == list2.get(3).getId());
		
		assertTrue(list.size()==4);
		
		
	}

}
