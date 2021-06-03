package stepDefinition;

import java.util.HashMap;
import org.json.simple.JSONObject;

import apiEngine.model.response.PostResponse;
import context.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Comments extends TestBase {

	TestContext cntxt;
	PostResponse resp_body;

	public Comments(TestContext testContext) {
		this.cntxt = testContext;
	}

	@When("Hit comment API using endpoint {string} on postId {int}")
	public void hit_post_request_using_endpoint(String endPoint, Integer Id) {
		try {

			JSONObject request = new JSONObject();
			request.put("postId", Id);
			request.put("name", name);
			request.put("email", email);
			request.put("body", body);

			HashMap<String, String> header = new HashMap<String, String>();
			header.put("Content-Type", "application/json");

			cntxt.resp = cntxt.req_spec.headers(header).body(request).when().post(endPoint);
			cntxt.scn.log(request.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("Validate the response against created postId {int}")
	public void validate_the_response_against_the_input_details(Integer Id) {
		try {
			PostResponse resp_body = cntxt.resp.getBody().as(PostResponse.class);
			Assert.assertEquals(Id, resp_body.postId);
			cntxt.scn.log("Comment Creation Validation successful");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("Hit comment API using endpoint {string} with empty request")
	public void hit_comment_api_using_endpoint_with_empty_request(String endPoint) {
		try {

			JSONObject request = new JSONObject();
			cntxt.resp = cntxt.req_spec.body(request).when().post(endPoint);
			cntxt.scn.log(request.toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
