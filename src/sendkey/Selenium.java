package sendkey;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {
	public WebDriver driver;
	public UIMap uimap, uimap1, uimap2;
	public UIMap datafile, datafile1, datafile2;
	public String workingDir;
	Map<String, Object[]> TestNGResults;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	///// SIGN UP /////

	@Test(description = "Fill the SignUp Details", priority = 1)
	public void FillSignUp1() throws Exception {
		try {
			driver.get("http://localhost:8080/WebVideo/register");
			driver.manage().window().maximize();
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(ByName.name("fullname")).click();
			driver.findElement(ByName.name("fullname")).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(ByName.name("email")).click();
			driver.findElement(ByName.name("email")).sendKeys("");
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("2", new Object[] { 1d, "Sign up test when entering blank data",
					"Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("2", new Object[] { 1d, "Sign up test when entering blank data",
					"Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the SignUp Details", priority = 2)
	public void FillSignUp2() throws Exception {
		try {
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("");
			Thread.sleep(1000);
			WebElement fullname = driver.findElement(uimap1.getLocator("Fullname_field"));
			driver.findElement(ByName.name("fullname")).click();
			fullname.sendKeys(datafile1.getData("fullname"));
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap1.getLocator("Password_field"));
			driver.findElement(ByName.name("password")).click();
			password.sendKeys(datafile1.getData("password"));
			Thread.sleep(1000);
			WebElement email = driver.findElement(uimap1.getLocator("Email_field"));
			driver.findElement(ByName.name("email")).click();
			email.sendKeys(datafile1.getData("email"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("3",
					new Object[] { 2d, "Sign up test when username is blank", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("3",
					new Object[] { 2d, "Sign up test when username is blank", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the SignUp Details", priority = 3)
	public void FillSignUp3() throws Exception {
		try {
			WebElement username = driver.findElement(uimap1.getLocator("Username_field"));
			driver.findElement(ByName.name("username")).click();
			username.sendKeys(datafile1.getData("username"));
			Thread.sleep(1000);
			driver.findElement(ByName.name("fullname")).click();
			driver.findElement(ByName.name("fullname")).sendKeys("");
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap1.getLocator("Password_field"));
			driver.findElement(ByName.name("password")).click();
			password.sendKeys(datafile1.getData("password"));
			Thread.sleep(1000);
			WebElement email = driver.findElement(uimap1.getLocator("Email_field"));
			driver.findElement(ByName.name("email")).click();
			email.sendKeys(datafile1.getData("email"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("4",
					new Object[] { 3d, "Sign up test when fullname is blank", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("4",
					new Object[] { 3d, "Sign up test when fullname is blank", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the SignUp Details", priority = 4)
	public void FillSignUp4() throws Exception {
		try {
			WebElement username = driver.findElement(uimap1.getLocator("Username_field"));
			driver.findElement(ByName.name("username")).click();
			username.sendKeys(datafile1.getData("username"));
			Thread.sleep(1000);
			WebElement fullname = driver.findElement(uimap1.getLocator("Fullname_field"));
			driver.findElement(ByName.name("fullname")).click();
			fullname.sendKeys(datafile1.getData("fullname"));
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("");
			Thread.sleep(1000);
			WebElement email = driver.findElement(uimap1.getLocator("Email_field"));
			driver.findElement(ByName.name("email")).click();
			email.sendKeys(datafile1.getData("email"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("5",
					new Object[] { 4d, "Sign up test when password is blank", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("5",
					new Object[] { 4d, "Sign up test when password is blank", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the SignUp Details", priority = 5)
	public void FillSignUp5() throws Exception {
		try {
			WebElement username = driver.findElement(uimap1.getLocator("Username_field"));
			driver.findElement(ByName.name("username")).click();
			username.sendKeys(datafile1.getData("username"));
			Thread.sleep(1000);
			WebElement fullname = driver.findElement(uimap1.getLocator("Fullname_field"));
			driver.findElement(ByName.name("fullname")).click();
			fullname.sendKeys(datafile1.getData("fullname"));
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap1.getLocator("Password_field"));
			driver.findElement(ByName.name("password")).click();
			password.sendKeys(datafile1.getData("password"));
			Thread.sleep(1000);
			driver.findElement(ByName.name("email")).click();
			driver.findElement(ByName.name("email")).sendKeys("");
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("6",
					new Object[] { 5d, "Sign up test when email is blank", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("6",
					new Object[] { 5d, "Sign up test when email is blank", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the SignUp Details", priority = 6)
	public void FillSignUp6() throws Exception {
		try {
			WebElement username = driver.findElement(uimap1.getLocator("Username_field"));
			driver.findElement(ByName.name("username")).click();
			username.sendKeys(datafile1.getData("username"));
			Thread.sleep(1000);
			WebElement fullname = driver.findElement(uimap1.getLocator("Fullname_field"));
			driver.findElement(ByName.name("fullname")).click();
			fullname.sendKeys(datafile1.getData("fullname"));
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap1.getLocator("Password_field"));
			driver.findElement(ByName.name("password")).click();
			password.sendKeys(datafile1.getData("password"));
			Thread.sleep(1000);
			driver.findElement(ByName.name("email")).click();
			driver.findElement(ByName.name("email")).sendKeys("vtk");
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("7", new Object[] { 6d, "Sign up test when entering the wrong email address",
					"Please include an '@' in the email address", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("7", new Object[] { 6d, "Sign up test when entering the wrong email address",
					"Please include an '@' in the email address", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the SignUp Details", priority = 7)
	public void FillSignUp7() throws Exception {
		try {
			driver.get("http://localhost:8080/WebVideo/register");
			driver.manage().window().maximize();
			WebElement username = driver.findElement(uimap1.getLocator("Username_field"));
			driver.findElement(ByName.name("username")).click();
			username.sendKeys(datafile1.getData("username"));
			Thread.sleep(1000);
			WebElement fullname = driver.findElement(uimap1.getLocator("Fullname_field"));
			driver.findElement(ByName.name("fullname")).click();
			fullname.sendKeys(datafile1.getData("fullname"));
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap1.getLocator("Password_field"));
			driver.findElement(ByName.name("password")).click();
			password.sendKeys(datafile1.getData("password"));
			Thread.sleep(1000);
			WebElement email = driver.findElement(uimap1.getLocator("Email_field"));
			driver.findElement(ByName.name("email")).click();
			email.sendKeys(datafile1.getData("email"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("signup")).click();
			Thread.sleep(1000);
			TestNGResults.put("8", new Object[] { 7d, "Sign up test when all correct",
					"Display message and go to home page", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("8", new Object[] { 7d, "Sign up test when all correct",
					"Display message and go to home page", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	///// SIGN IN /////

	@Test(description = "Fill the Login Details", priority = 8)
	public void LoginDetail1() throws Exception {
		try {
			driver.get("http://localhost:8080/WebVideo/login");
			driver.manage().window().maximize();
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("");
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("9",
					new Object[] { 8d, "Login test when entering blank data", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("9",
					new Object[] { 8d, "Login test when entering blank data", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 9)
	public void LoginDetail2() throws Exception {
		try {
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("abc");
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("10",
					new Object[] { 9d, "Login test when username is empty", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("10",
					new Object[] { 9d, "Login test when username is empty", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 10)
	public void LoginDetail3() throws Exception {
		try {
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("tuine");
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("");
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("11",
					new Object[] { 10d, "Login test when password is empty", "Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("11",
					new Object[] { 10d, "Login test when password is empty", "Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 11)
	public void LoginDetail4() throws Exception {
		try {
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("tuine");
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("abc");
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("12", new Object[] { 11d, "Login test when entering wrong username, password",
					"Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("12", new Object[] { 11d, "Login test when entering wrong username, password",
					"Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 12)
	public void LoginDetail5() throws Exception {
		try {
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("tuine");
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(datafile.getData("password"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("13", new Object[] { 12d, "Login test when entering wrong username",
					"Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("13", new Object[] { 12d, "Login test when entering wrong username",
					"Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 13)
	public void LoginDetail6() throws Exception {
		try {
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("username"));
			Thread.sleep(1000);
			driver.findElement(ByName.name("password")).click();
			driver.findElement(ByName.name("password")).sendKeys("abc");
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("14", new Object[] { 13d, "Login test when entering wrong password",
					"Please fill out this field", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("14", new Object[] { 13d, "Login test when entering wrong password",
					"Please fill out this field", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 14)
	public void FillLogin7() throws Exception {
		try {
			driver.get("http://localhost:8080/WebVideo/login");
			driver.manage().window().maximize();
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("username"));
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(datafile.getData("password"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("login")).click();
			Thread.sleep(1000);
			TestNGResults.put("15", new Object[] { 14d, "Login test when all correct",
					"Display message and go to home page", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("15", new Object[] { 14d, "Login test when all correct",
					"Display message and go to home page", "Failed" });
			AssertJUnit.assertTrue(false);
		}
	}

	///// UPDATE USER /////

	@Test(description = "Fill the Update User", priority = 15)
	public void FillDetails() throws Exception {
		try {
			driver.findElement(ByName.name("adminuser")).click();
			Thread.sleep(2000);
			driver.findElement(ByName.name("userlist")).click(); // tab 2
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"videoList\"]/table/tbody/tr[3]/td[5]/a[1]")).click(); // user 2
			Thread.sleep(2000);
			driver.findElement(ByName.name("username")).click();
			driver.findElement(ByName.name("username")).sendKeys("");
			Thread.sleep(1000);
			WebElement fullname = driver.findElement(uimap2.getLocator("Fullname_field"));
			fullname.sendKeys(datafile2.getData("fullname"));
			Thread.sleep(1000);
			WebElement password = driver.findElement(uimap2.getLocator("Password_field"));
			password.sendKeys(datafile2.getData("password"));
			Thread.sleep(1000);
			WebElement email = driver.findElement(uimap2.getLocator("Email_field"));
			email.sendKeys(datafile2.getData("email"));
			Thread.sleep(2000);
			driver.findElement(ByName.name("updateuser")).click();
			Thread.sleep(1000);
			TestNGResults.put("16", new Object[] { 15d, "Update User test when all correct",
					"Update details and display messages", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("16", new Object[] { 15d, "Update User test when all correct",
					"Update details and display messages", "Failed" });
			Assert.assertTrue(false);
		}
	}

	///// DELETE USER /////

	@Test(description = "Delete User", priority = 16)
	public void DeleteUser() throws Exception {
		try {
			driver.findElement(ByName.name("adminuser")).click();
			Thread.sleep(2000);
			driver.findElement(ByName.name("userlist")).click(); // tab 2
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"videoList\"]/table/tbody/tr[3]/td[5]/a[1]")).click(); // user 2
			Thread.sleep(2000);
			driver.findElement(ByName.name("deleteuser")).click();
			Thread.sleep(2000);
			driver.findElement(ByName.name("userlist")).click(); // tab 2
			Thread.sleep(5000);
			TestNGResults.put("17", new Object[] { 16d, "Remove user from database when click button",
					"Delete user and display message", "Passed" });
		} catch (Exception e) {
			e.printStackTrace();
			TestNGResults.put("17", new Object[] { 16d, "Delete user from database when click button",
					"Delete user and display message", "Failed" });
			Assert.assertTrue(false);
		}
	}

	@BeforeClass(alwaysRun = true)
	public void suiteSetup() {
		try {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("TestNG Result");
			TestNGResults = new LinkedHashMap<String, Object[]>();
			// Thêm test result vào file excel ở cột header
			TestNGResults.put("1", new Object[] { "STEP NO.", "ACTION", "EXPECTED OUTPUT", "ACTUAL OUTPUT" });
			try {
				// Lấy địa chỉ làm việc hiện tại và tải dữ liệu vào file
				workingDir = System.getProperty("user.dir");
				datafile = new UIMap(workingDir + "\\Resources\\login\\datafile.properties");
				uimap = new UIMap(workingDir + "\\Resources\\login\\locator.properties");
				datafile1 = new UIMap(workingDir + "\\Resources\\register\\datafile.properties");
				uimap1 = new UIMap(workingDir + "\\Resources\\register\\locator.properties");
				datafile2 = new UIMap(workingDir + "\\Resources\\user\\datafile.properties");
				uimap2 = new UIMap(workingDir + "\\Resources\\user\\locator.properties");
				// Cài đặt địa chỉ Driver và chạy
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				Thread.sleep(5000);
			} catch (Exception ex) {
				throw new IllegalStateException("Can't start the Chrome web driver", ex);
			}
		} catch (Exception e) {
		}
	}

	@AfterClass
	public void suiteTearDown() {
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			XSSFRow row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				XSSFCell cell = row.createCell(cellnum++);
				if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}
			}
			try {
				XSSFSheet sheet = workbook.getSheetAt(0);
				makeStyle(workbook, sheet.getRow(0));
				sheet.autoSizeColumn(0);
				sheet.autoSizeColumn(1);
				sheet.autoSizeColumn(2);
				sheet.autoSizeColumn(3);
				FileOutputStream out = new FileOutputStream(new File("TestNG-Report-Selenium.xlsx"));
				workbook.write(out);
				Desktop.getDesktop().open(new File("TestNG-Report-Selenium.xlsx"));
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Successfully save Selenium Webdriver TestNG result to Excel File!!!");
		driver.close();
		driver.quit();
	}

	public static void makeStyle(XSSFWorkbook workbook, XSSFRow row) {
		XSSFCellStyle style = workbook.createCellStyle();// create style
		XSSFFont font = workbook.createFont(); // create font
		font.setFontHeightInPoints((short) 12); // set font size
		font.setColor(IndexedColors.BLUE.getIndex()); // set color text
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // set background
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true); // make font bold
		style.setFont(font); // set it to bold
		for (int i = 0; i < row.getLastCellNum(); i++) {
			row.getCell(i).setCellStyle(style); // Set the style
		}
	}
}
