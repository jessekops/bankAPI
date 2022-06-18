package io.swagger.bankapi.cucumber.steps.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java8.En;
import io.swagger.bankapi.cucumber.steps.BaseStepDefinitions;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;


public class UserStepDefinitions extends BaseStepDefinitions implements En {

    private static final String VALID_TOKEN_USER = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W10sImlhdCI6MTY1MzMxMTc0NiwiZXhwIjoxNjg0ODQ3NzQ2fQ.itSjs-evCYi2P7JAKwT4DY8u5RIASTghoaeQOa33v_s";
    private static final String VALID_TOKEN_ADMIN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOltdLCJpYXQiOjE2NTMzMTE4MjQsImV4cCI6MTY4NDg0NzgyNH0.heZJFGgEEdaUvEhbjnbK7PFfC_BfxOMIvmRq8fjvwMs";
    private static final String EXPIRED_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W10sImlhdCI6MTY1MzMxMTkwNSwiZXhwIjoxNjUzMzExOTA1fQ.mKFrXM15WCXVNbSFNpqYix_xsMjsH_M31hiFf-o7JXs";
    private static final String INVALID_TOKEN = "invalid";


    private final HttpHeaders httpHeaders = new HttpHeaders();
    private final TestRestTemplate restTemplate = new TestRestTemplate();

    private final ObjectMapper mapper = new ObjectMapper();

    public UserStepDefinitions() {

        Given("^I have a valid JWT$", () -> {
        });

        When("^I call the users endpoint$", () -> {
        });

        Then("^I receive a status of (\\d+)$", (Integer status) -> {
        });

        And("^Get a List<User> of length (\\d+)$", (Integer expectedLength) -> {
        });

    }
}
