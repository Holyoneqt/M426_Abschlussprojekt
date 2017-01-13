package ch.bbw.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ch.bbw.addressbook.Address;
import ch.bbw.addressbook.AddressComparator;

public class TestComparator {

	@Test
	public void test() {
		Date date = new Date();
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address(0, "bbb", "bbb", "123",date));
		addresses.add(new Address(1, "aaa", "aaa", "123",date));
		
		AddressComparator ac = new AddressComparator();
		
		assertEquals(0, ac.compare(addresses.get(0),addresses.get(0)));
		assertTrue(ac.compare(addresses.get(0),addresses.get(1)) > 0);
	}

	
	
}
