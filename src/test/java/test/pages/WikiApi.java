package test.pages;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class WikiApi {

    public Response responseBody;

    public void getRequest(String value){

        Response response = given().accept(ContentType.JSON)
                .queryParam("q",value)
                .get(baseURI);
        //response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        responseBody = response;
    }

    public void findTitle(String value){
        JsonPath jsonPath = responseBody.jsonPath();
        List<String> title = jsonPath.getList("pages.title");
        System.out.println(title);
        Assert.assertTrue(title.contains(value));
    }

}
