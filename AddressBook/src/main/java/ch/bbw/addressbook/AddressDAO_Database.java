package ch.bbw.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named("AddressDAO")
@ApplicationScoped
public class AddressDAO_Database implements AddressDAO {
	
	private Connection connection;
	
	public AddressDAO_Database() {
	}
	
	@PostConstruct
	private void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://172.25.21.39/addressbook","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	@PreDestroy
	private void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// CRUD Commands: Create Read Update Delete
	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#create(ch.bbw.addressbook.Address)
	 */
//	@Override
	public void create(Address address) {
		try {
			String sql = "INSERT INTO address"
					+ "(FIRSTNAME, LASTNAME, PHONENUMBER, REGISTRATIONDATE,EMAIL,CATEGORY,CITY,GENDER) VALUES"
					+ "(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address.getFirstname());
			preparedStatement.setString(2, address.getLastname());
			preparedStatement.setString(3, address.getPhonenumber());
			preparedStatement.setString(5, address.getEmail());
			preparedStatement.setInt(6, address.getCategory());
			preparedStatement.setString(7, address.getCity());
			preparedStatement.setString(8, address.getGender());
			preparedStatement.setTimestamp(4, new Timestamp(address.getRegistrationDate().getTime()));
			
			preparedStatement .executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#read(int)
	 */
//	@Override
	public Address read(int id) {
		// TODO: read, not implemented yet
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#readAll()
	 */
//	@Override
	public List<Address> readAll() {
		List<Address> list = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet entries = stmt.executeQuery("SELECT * FROM address");
			while (entries.next()) {
				list.add(new Address(
						entries.getInt("id"), entries.getString("firstname"), 
						entries.getString("lastname"), entries.getString("phonenumber"),
						entries.getDate("registrationDate"),entries.getString("email"),entries.getInt("category"),
						entries.getString("city"),entries.getString("gender")));
			}
			entries.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#update(ch.bbw.addressbook.Address)
	 */
//	@Override
	public void update(Address address) {
		// TODO: update, not implemented yet
	}
	
	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#delete(int)
	 */
//	@Override
	public void delete(int id) {
		// TODO: delete, not implemented yet
	}

}
