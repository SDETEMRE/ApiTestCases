package test.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import test.pages.WikiApi;
import test.utilities.ConfigurationReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;


public class HttpGETrequests {

    WikiApi wikiApi = new WikiApi();
    @Given("A client of the API")
    public void a_client_of_the_api() {
        baseURI= ConfigurationReader.get("baseURI");
    }
    @When("A search for pages containing for {string} is executed")
    public void a_search_for_pages_containing_for_is_executed(String value) {
        wikiApi.getRequest(value);
    }
    @Then("A page with the title {string} is found")
    public void a_page_with_the_title_is_found(String value) {
        wikiApi.findTitle(value);

    }

    @Given("The result for {string} search contains {string}")
    public void the_result_for_search_contains(String value, String value2) {
        Response response = given().accept(ContentType.JSON)
                .queryParam("q",value)
                .get(baseURI);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> list = jsonPath.getList("pages.title");
        Assert.assertTrue(list.contains(value2));
    }
    @When("The page details for {string} are requested")
    public void the_page_details_for_sesame_street_are_requested(String value) {
        Response response = given().accept(ContentType.JSON)
                .queryParam("q",value)
                .get(baseURI);

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getMap("pages[0]"));
    }
    @Then("It has a latest timestamp")
    public void it_has_a_latest_timestamp() {

        Response response = given().accept(ContentType.JSON)
                .queryParam("q","Sesame Street")
                .get(baseURI);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);

        Assert.assertTrue(response.header("date").contains(formattedDateTime));
    }
}


