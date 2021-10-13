package com.selenium.training.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatabaseSteps {

	Connection connection;
	ResultSet resultSet;
	
	@When("connection is established using")
	public void connection_is_established_using() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
		System.out.println("Connection is established");
	}

	@When("I run a select query to get the data")
	public void i_run_a_select_query_to_get_the_data() throws SQLException {
		String query = "select * from freshproducts where product_Id = 999";
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
	}

	@Then("I should see the result as oneplus900")
	public void i_should_see_the_result_as_oneplus900() throws SQLException {
		resultSet.next();
		String result = resultSet.getString(3);
		Assert.assertEquals("oneplus900", result);
	}
	
}
