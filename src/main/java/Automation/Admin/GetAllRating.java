package Automation.Admin;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.Restaurant;
import Pojo.Rating.Rating;
import Pojo.Rating.RatingResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetAllRating {
	@Test
public void getallrating() {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/api/admin").setContentType(ContentType.JSON).build();

        ResponseSpecification res = new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        RequestSpecification request =given().spec(req).log().all();
        
        Response resp = request.when().get("/allRatings").then().spec(res).extract().response();
        
        System.out.println(resp.body().asString());
        
        RatingResponse[] responses = resp.as(RatingResponse[].class);
        
       Rating p = new Rating();
       p.setId((long)1);
       p.setUserRating(4.5);
       Restaurant restaurant = new Restaurant();
       restaurant.setId((long)1);
       p.setRestaurant(restaurant);
       
       
        
        RatingResponse ress=responses[0];
        Assert.assertEquals(ress.getId(),p.getId() );
        Assert.assertEquals(ress.getUserRating(),p.getUserRating() );
        Assert.assertEquals(ress.getRestaurant().getId(),p.getRestaurant().getId() );
      
        


	}


}
