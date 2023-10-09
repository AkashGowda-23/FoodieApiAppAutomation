package Automation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import Pojo.Restaurant;
import Pojo.RestaurantResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddRestaurant {
	public static void main(String[] args) {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/restaurants")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.build();

		Restaurant p = new Restaurant();
		p.setId((long) 20);
		p.setName("raddison");
		p.setLocation("banglore");
		p.setContact("radd@gmail.com");
		p.setCategory("hotel");

		RequestSpecification request = given().spec(req).body(p).log().all();

		Response resp = request.when().post("/addresto").then().spec(res).extract().response();

		RestaurantResponse response = resp.as(RestaurantResponse.class);

		Assert.assertEquals(response.getId(), p.getId());
		Assert.assertEquals(response.getName(), p.getName());
		Assert.assertEquals(response.getCategory(), p.getCategory());
		Assert.assertEquals(response.getContact(), p.getContact());

	}

}
