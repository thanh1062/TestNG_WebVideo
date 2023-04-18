package testdao;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poly.dao.UserDAO;
import poly.model.User;

public class TestDelete {
	UserDAO udao = new UserDAO();
	static int count, index;

	public int countUser() {
		int temp = 0;
		try {
			List<User> u = udao.findAll();
			temp = u.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@BeforeClass
	public static void OpenConnect() {

	}

	@Before
	public void beforeUser() {
		count = countUser();
	}

	@Test
	public void testDaleteUsernamenull() {
		try {
			String id = "";
			udao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testDaleteUsernamesai() {
		try {
			String id = "tuilaadmin";
			udao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testDaleteUsernamedung() {
		try {
			String id = "asalmen3";
			udao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		index = countUser();
		assertEquals(index, count - 1);
	}

	@After
	public void afterUser() {

	}

	@AfterClass
	public static void CloseConnect() {

	}
}
