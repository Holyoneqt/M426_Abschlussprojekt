package ch.bbw.addressbook;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

	@Override
	public int compare(Address arg0, Address arg1) {
		if (arg0.getLastname().equals(arg1.getLastname())) {
			if(arg0.getFirstname().equals(arg1.getFirstname())){
				if(arg0.getRegistrationDate().equals(arg1.getRegistrationDate())){
					return 0;
				}
				else{
					return arg0.getRegistrationDate().compareTo(arg1.getRegistrationDate());
				}
			}
			else{
				return arg0.getFirstname().compareTo(arg1.getFirstname());
			}
		  }
		  return arg0.getLastname().compareTo(arg1.getLastname());
	}

}
