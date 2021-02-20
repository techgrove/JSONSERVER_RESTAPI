package serialization_deserialization;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import static  io.restassured.RestAssured.*;

public class UsersAPI_TEST {

	@BeforeClass
	public void init() {
	 baseURI="http://localhost:3000";
	}
	@Test 
	//Creating user via Serialization 
	public void createUser() {
		
		Users u1=new Users();
		u1.setFirstname("kevin");
		u1.setLastname("yujin");
		u1.setSubjectId(21);
		u1.setId(12);
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(u1).when().post("/users").then().statusCode(201);
	}
	@Test
	//Getting user via deserialization
	public void getUser() {
		Users user=given().get("/users/12").as(Users.class);
		String fname=user.getFirstname();
		String lname=user.getLastname();
		int sId=user.getSubjectId();
		int id=user.getId();
		
		Assert.assertEquals(fname,"kevin");
		Assert.assertEquals(lname,"yujin");
		Assert.assertEquals(sId,21);
		Assert.assertEquals(id,12);
	}
	
}
