package Automation.Restaurant;

import org.testng.Assert;

import Pojo.Dish.Dish;
import Pojo.Dish.DishResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class UpdateDish {
public static void main(String[] args) {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/restaurants").setContentType(ContentType.JSON).build();

	    ResponseSpecification res = new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    
	    Dish d =new Dish();
	    d.setName("Fish Curry");
	    d.setCategory("non veg");
	    
        
        RequestSpecification request =given().spec(req).pathParam("dishId",4).body(d).log().all();
        
        Response resp = request.when().put("/dish/{dishId}/modify").then().spec(res).extract().response();
        
        System.out.println(resp.body().asString());
        
        DishResponse response = resp.as(DishResponse.class);
        
        Assert.assertEquals(response.getName(), d.getName());
        Assert.assertEquals(response.getDescription(),d.getDescription());
        
        
	}


}
