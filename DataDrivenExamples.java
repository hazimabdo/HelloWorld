package demo;
import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataForTests {
	
	

	//@Test(dataProvider = "dataForPost")
public void test_post(String firstName, String lastName, int subjectId) {
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		baseURI = "http://localhost:3000/";
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
		

}
	
	//@Test(dataProvider =  "deletedata" )
	public void test_delete(int userId) {
		
		baseURI = "http://localhost:3000/";
		when().
		delete("/users/"+userId).
		then().
		statusCode(200);
	}
	@Parameters({"userID"})
	@Test
	public void test_delete2(int userId) {
		System.out.println("value for userId is :    "+userId);
		
		baseURI = "http://localhost:3000/";
		when().
		delete("/users/"+userId).
		then().
		statusCode(200);
	}
	
}
