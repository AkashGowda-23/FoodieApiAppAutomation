package Automation.Admin;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.Order.Order;
import Pojo.Order.OrderResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetAllOrders {
@Test	
public void getallorder() {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/api/admin").setContentType(ContentType.JSON).build();

        ResponseSpecification res = new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        RequestSpecification request =given().spec(req).log().all();
        
        Response resp = request.when().get("/Getallorders").then()
        		
        				.spec(res).extract().response();
        
        System.out.println(resp.body().asString());
        
        OrderResponse[] responses = resp.as(OrderResponse[].class);
        
        Order p = new Order();
        p.setId((long)3);
        p.setRestaurantName("malnaddd");
        p.setQuantity(2);
        p.setDishName("oreo");
        
        
        OrderResponse ress=responses[0];
        Assert.assertEquals(ress.getId(),p.getId() );
        Assert.assertEquals(ress.getQuantity(),p.getQuantity() );
        Assert.assertEquals(ress.getRestaurantName(),p.getRestaurantName() );
        Assert.assertEquals(ress.getDishName(),p.getDishName() );
        
	}

}
