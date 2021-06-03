package stepDefinition;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {
	
	  protected RequestSpecification req_spec;
	  protected Response resp;
	  protected Scenario scn;
}
