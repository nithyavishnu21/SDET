package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import context.TestBase;

public class Users extends TestBase {

	TestContext cntxt;

	public Users(TestContext testContext) {
		this.cntxt = testContext;
	}

	@Given("API is up and running")
	public void api_is_up_and_running() {
		cntxt.req_spec = given().baseUri(uri);
	}

	@When("Hit the Get Request with the endpoint {string}")
	public void hit_the_url_with_the_endpoint(String endPoint) {
		cntxt.resp = cntxt.req_spec.when().get(endPoint);
		cntxt.scn.log("Get request triggered");
	}

	@Then("API returns the response with status code as {int}")
	public void api_returns_the_response_with_status_code_as(Integer code) {
		int statusCode = cntxt.resp.getStatusCode();
		try {
			switch (statusCode) {
			case 200:
				cntxt.scn.log("SUCCESS");
				break;
			case 201:
				cntxt.scn.log("CREATED NEWLY");
				break;
			case 404:
				cntxt.scn.log("NO DATA FOUND");
				break;
			case 500:
				cntxt.scn.log("INTERNAL SERVER ERROR");
				break;
			default:
				cntxt.scn.log("UNKNOWN ERROR");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("Users will be returned")
	public void users_will_be_returned() {
		cntxt.scn.log(cntxt.resp.asString());
		
	}

	@And("Get the number of users")
	public void get_the_number_of_users() {
		cntxt.scn.log("Number of users returned: " + cntxt.resp.jsonPath().getList("$").size());
	}

	@When("Hit the Get Request with the endpoint {string} for the userId {int}")
	public void hit_the_url_with_the_endpoint_with(String endPoint, Integer user_id) {
		cntxt.resp = cntxt.req_spec.when().get(endPoint + user_id);
		cntxt.scn.log("Get request triggered to fetch invalid user details");
	}

}
