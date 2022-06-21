package io.swagger.cucumber.steps.user;

import io.cucumber.java8.En;
import io.swagger.cucumber.steps.BaseStepDefinitions;

public class UserStepDefinitions extends BaseStepDefinitions implements En {
    public UserStepDefinitions() {
        Then("^I receive a status of (\\d+)$", (Integer arg0) -> {
        });
        When("^I call the users endpoint$", () -> {
        });
        Given("^I have a valid JWT$", () -> {
        });

    }
}
