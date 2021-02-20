package com.jsonserver;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
public class Students {
	
	@BeforeClass
	public void setUp() {
		baseURI="http://localhost:3000";
	}
	@Test
	public void createStudent() throws JsonProcessingException {
//	    JSONObject data= new JSONObject();
//		data.put("id",102);
//		data.put("firstname","salim");
//		data.put("lastname","summit");
//		data.put("email","summitbro11@gmail.com");
//		data.put("programm","FULL STACK DEV");
//		List<String> courseList=new ArrayList<>();
//		courseList.add("Java");
//		courseList.add("CSS");
//		data.put("courses",courseList);
//		
//		//JSONObject map= new JSONObject(data);
//		
//		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(data.toJSONString()).
//		when().post("/students").then().statusCode(201);
		
		
		StudentPOJO st= new StudentPOJO();
		st.setId(103);
		st.setFirstname("adam");
		st.setLastname("lallana");
		st.setEmail("adamlallana@gmail.com");
		st.setProgramm("Web Designer");
		List<String> courseList=new ArrayList<>();
		courseList.add("HTML");
		courseList.add("C#");
		st.setCourses(courseList);
		
		ObjectMapper obm= new ObjectMapper();
		obm.writeValueAsString(st);
		given().contentType(ContentType.JSON).body(st).when().post("/students");
	}
	@Test
	public void getStudents() {
		StudentPOJO stpojo=given().get("/students/101").as(StudentPOJO.class);
		System.out.println(stpojo.toString());
		Assert.assertEquals(stpojo.getId(),(Integer)101);
	}
}
