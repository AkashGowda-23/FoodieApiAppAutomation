package Automation.user;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import Pojo.Restaurant;
import Pojo.Rating.Rating;
import Pojo.Rating.RatingResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GiveRating {
	
	public static void main(String[] args) {



		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/api/User")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.build();

   Rating p = new Rating();
   p.setUserRating((double) 21);
 
   
   Restaurant restaurant = new Restaurant();
   restaurant.setId((long)1);
   p.setRestaurant(restaurant);
   
   


		RequestSpecification request = given().spec(req).body(p).log().all();

		Response resp = request.when().post("/giveRating").then().spec(res).extract().response();
		
		RatingResponse response = resp.as(RatingResponse .class);
		
		Assert.assertEquals(response.getRestaurant().getId(),p.getRestaurant().getId());
		Assert.assertEquals(response.getUserRating(), p.getUserRating());

		
		
	
	
	
	}
}
