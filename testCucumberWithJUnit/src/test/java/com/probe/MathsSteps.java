package com.probe;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MathsSteps {
    int firstNumber;
    int secondNumber;
    int result;

    @Given("^first number is ([\\d]*)$")
    public void theFirstNumberIs(int firstNumberParam) throws Throwable {
        this.firstNumber = firstNumberParam;
    }

    @When("^I add ([\\d]*)$")
    public void iAddTheSecondNumber(int secondNumberParam) throws Throwable {
        this.secondNumber = secondNumberParam;
        this.result = this.firstNumber + this.secondNumber;
    }

    @When("^I substract ([\\d]*)$")
    public void iSubstractTheSecondNumber(int secondNumberParam) throws Throwable {
        this.secondNumber = secondNumberParam;
        this.result = this.firstNumber - this.secondNumber;
    }

    @When("^I multiply by ([\\d]*)$")
    public void iMultipleByTheSecondNumber(int secondNumberParam) throws Throwable {
        this.secondNumber = secondNumberParam;
        this.result = this.firstNumber * this.secondNumber;
    }

    @Then("^the result is ([\\d]*)$")
    public void theResultIs(int resultParam) throws Throwable {
        Assert.assertEquals(resultParam, this.result);
    }
}
