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

public class GetAllRestaurant {
	public static void main(String[] args) {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/api/admin").setContentType(ContentType.JSON).build();

        ResponseSpecification res = new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        RequestSpecification request =given().spec(req).log().all();
        
        Response resp = request.when().get("/allResto").then().spec(res).extract().response();
        
        System.out.println(resp.body().asString());
        
        RestaurantResponse[] responses = resp.as(RestaurantResponse[].class);
        
        Restaurant p = new  Restaurant();
        p.setId((long)3);
        p.setName("cafe briyani");
        p.setCategory("hotel");
        p.setLocation("hydrabad");
        p.setContact("cafeee@gmail.com");
        
        RestaurantResponse ress=responses[2];
        Assert.assertEquals(ress.getId(), p.getId());
        Assert.assertEquals(ress.getName(), p.getName());
        Assert.assertEquals(ress.getCategory(), p.getCategory());
        Assert.assertEquals(ress.getContact(), p.getContact());
        


	}

}
