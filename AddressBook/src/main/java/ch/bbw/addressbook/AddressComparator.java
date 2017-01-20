package ch.bbw.addressbook;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

	private String orderBy;

	public AddressComparator() {
		this("lastname");
	}

	public AddressComparator(String order) {
		this.orderBy = order;
	}

	@Override
	public int compare(Address arg0, Address arg1) {
		switch (orderBy) {
		case "lastname":
			return sortLastname(arg0, arg1);
		case "firstname":
			return sortFirstname(arg0, arg1);
		case "phonenumber":
			return sortLastname(arg0, arg1);
		case "regdate":
			return sortRegDate(arg0, arg1);
		default:
			return 0;
		}
	}

	private int sortLastname(Address a1, Address a2) {
		if (a1.getLastname().equals(a2.getLastname())) {
			if (a1.getFirstname().equals(a2.getFirstname())) {
				if (a1.getRegistrationDate().equals(a2.getRegistrationDate())) {
					return 0;
				} else {
					return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
				}
			} else {
				return a1.getFirstname().compareTo(a2.getFirstname());
			}
		}
		return a1.getLastname().compareTo(a2.getLastname());
	}

	private int sortFirstname(Address a1, Address a2) {
		if (a1.getFirstname().equals(a2.getFirstname())) {
			if (a1.getLastname().equals(a2.getLastname())) {
				if (a1.getRegistrationDate().equals(a2.getRegistrationDate())) {
					return 0;
				} else {
					return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
				}
			} else {
				return a1.getLastname().compareTo(a2.getLastname());
			}
		}
		return a1.getFirstname().compareTo(a2.getFirstname());
	}

	private int sortRegDate(Address a1, Address a2) {
		if (a1.getRegistrationDate().equals(a2.getRegistrationDate())) {
			if (a1.getLastname().equals(a2.getLastname())) {
				if (a1.getFirstname().equals(a2.getFirstname())) {
					return 0;
				} else {
					return a1.getFirstname().compareTo(a2.getFirstname());
				}
			} else {
				return a1.getLastname().compareTo(a2.getLastname());
			}
		}
		return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
	}

}
