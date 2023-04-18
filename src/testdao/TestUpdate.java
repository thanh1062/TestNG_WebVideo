package testdao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poly.dao.UserDAO;
import poly.model.User;

public class TestUpdate {

	UserDAO udao = new UserDAO();

	@BeforeClass
	public static void OpenConnect() {

	}

	@Before
	public void beforeUser() {

	}

	@Test
	public void testUpdateNullusername() {
		boolean t;
		User uip = new User();
		try {
			uip.setId("");
			uip.setPassword("123456");
			uip.setFullname("Vũ Trung Kien");
			uip.setEmail("vtk@fpt.edu.vn");
			uip.setAdmin(false);
			udao.update(uip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User ubf = udao.findById(uip.getId());
		if (ubf != null) {
			boolean temp = uip.getId().equals(ubf.getId()) && uip.getPassword().equals(ubf.getPassword())
					&& uip.getFullname().equals(ubf.getFullname()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();

			t = temp;
		} else {
			t = false;
		}

		assertFalse(t);
	}

	@Test
	public void testUpdateNullpass() {
		boolean t;
		User uip = new User();
		try {
			uip.setId("kienvt");
			uip.setPassword("");
			uip.setFullname("Vũ Trung Kien");
			uip.setEmail("vtk@fpt.edu.vn");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			e.printStackTrace();
		}
		User ubf = udao.findById(uip.getId());
		if (ubf != null) {
			boolean temp = uip.getId().equals(ubf.getId()) && uip.getPassword().equals(ubf.getPassword())
					&& uip.getFullname().equals(ubf.getFullname()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			t = temp;
		} else {
			t = false;
		}
		assertFalse(t);
	}

	@Test
	public void testUpdateNullname() {
		boolean t;
		User uip = new User();
		try {
			uip.setId("kienvt");
			uip.setPassword("123456");
			uip.setFullname("");
			uip.setEmail("vtk@fpt.edu.vn");
			uip.setAdmin(false);
			udao.update(uip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User ubf = udao.findById(uip.getId());
		if (ubf != null) {
			boolean temp = uip.getId().equals(ubf.getId()) && uip.getPassword().equals(ubf.getPassword())
					&& uip.getFullname().equals(ubf.getFullname()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			t = temp;
		} else {
			t = false;
		}
		assertFalse(t);
	}

	@Test
	public void testUpdateNullemail() {
		boolean t;
		User uip = new User();
		try {
			uip.setId("kienvt");
			uip.setPassword("123456");
			uip.setFullname("Vũ Trung Kiên");
			uip.setEmail("");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			e.printStackTrace();
		}
		User ubf = udao.findById(uip.getId());
		if (ubf != null) {
			boolean temp = uip.getId().equals(ubf.getId()) && uip.getPassword().equals(ubf.getPassword())
					&& uip.getFullname().equals(ubf.getFullname()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			t = temp;
		} else {
			t = false;
		}
		assertFalse(t);
	}

	@Test
	public void testUpdateEmailError() {
		boolean t;
		User uip = new User();
		try {
			uip.setId("kienvt");
			uip.setPassword("123456");
			uip.setFullname("Vũ Trung Kiên");
			uip.setEmail("vtk4019");
			uip.setAdmin(false);
			udao.update(uip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User ubf = udao.findById(uip.getId());
		if (ubf != null) {
			boolean temp = uip.getId().equals(ubf.getId()) && uip.getPassword().equals(ubf.getPassword())
					&& uip.getFullname().equals(ubf.getFullname()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			t = temp;
		} else {
			t = false;
		}
		assertFalse(t);
	}

	@After
	public void afterUser() {

	}

	@AfterClass
	public static void CloseConnect() {

	}
}
