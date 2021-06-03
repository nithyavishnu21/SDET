package stepDefinition;

import java.util.HashMap;
import org.json.simple.JSONObject;
import apiEngine.model.response.PostResponse;
import context.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Posts extends TestBase {

	TestContext cntxt;
	PostResponse resp_body;

	public Posts(TestContext testContext) {
		this.cntxt = testContext;
	}

	@When("Hit post creation API using endpoint {string} for userId {int}")
	public void hit_post_request_using_endpoint(String endPoint, Integer Id) {
		try {
			
			JSONObject request = new JSONObject();
			request.put("title", title);
			request.put("userId", Id);
			request.put("body", body);

			HashMap<String, String> header = new HashMap<String, String>();
			header.put("Content-Type", "application/json");

			cntxt.resp = cntxt.req_spec.headers(header).body(request).when().post(endPoint);
			cntxt.scn.log(request.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("Id is created")
	public void id_is_created() {
		cntxt.scn.log("Response Body is: " + cntxt.resp.asString());
		cntxt.scn.log("Id: " + cntxt.resp.jsonPath().get("id"));
	}

	@And("Validate the response against created userId {int}")
	public void validate_the_response_against_the_input_details(Integer Id) {
		try {
			PostResponse resp_body = cntxt.resp.getBody().as(PostResponse.class);
			Assert.assertEquals(Id, resp_body.userId);
			cntxt.scn.log("Post Creation Validation successful");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
