package serialization_deserialization;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;


import static  io.restassured.RestAssured.*;

public class Subject_Api_Test {
	Logger logger=Logger.getLogger(Subject_Api_Test.class);	
	@BeforeClass
	public void init() {
	 logger.info("Base uri given and launched");
	}
	@Test
	public void testing() {
		logger.info("Test is running");
	}
	@AfterClass
	public void afterClass(){
		logger.info("i am terminating the terminal");
		Assert.assertEquals(12,13);
	}
}
