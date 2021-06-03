package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext cntxt;
	
	public Hooks(TestContext testContext) {
		this.cntxt = testContext;
	}

	@Before
	public void SetUp(Scenario s) {
		this.cntxt.scn = s;
	}

	@After
	public void TearDown() {
		cntxt.req_spec = null;
		cntxt.resp = null;
	}

}
