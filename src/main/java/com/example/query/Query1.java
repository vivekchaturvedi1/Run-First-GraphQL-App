package com.example.query;

import com.example.request.SampleRequest;
import com.example.response.SampleResponse;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.SPACE;

@Component
public class Query1 implements GraphQLQueryResolver {

	private static final Logger logger = LoggerFactory.getLogger(Query1.class);

	public String firstQuery () {
		logger.info("{}#firstQuery() is called !", this.getClass().getSimpleName());
		return "First Query Data";
	}
	
	public String secondQuery () {
		logger.info("{}#secondQuery() is called !", this.getClass().getSimpleName());
		return "Second Query Data";
	}

	public String fullName (String firstName, String lastName) {
		logger.info("{}#fullName() is called !", this.getClass().getSimpleName());
		return firstName + SPACE + lastName;
	}

	public String fullNameWithAge (String firstName, String secondName, Integer age) {
		logger.info("{}#fullNameWithAge() is called with Age: {}!", this.getClass().getSimpleName(), age);
		return firstName + SPACE + secondName + " Age is " + age.toString();
	}

	public String fullNameWithJsonInput (SampleRequest request) {
		logger.info("{}#fullNameWithJsonInput() is called  | Input Request : {}", this.getClass().getSimpleName(), request);
		return request.getFirstName() + SPACE + request.getLastName();
	}

	public SampleResponse fullNameWithJsonInputAndModelResp (SampleRequest request) {
		logger.info("{}#fullNameWithJsonInputAndModelResp() is called  | Input Request : {}", this.getClass().getSimpleName(), request);
		SampleResponse response = new SampleResponse();
		response.setResponse(request.getFirstName()  + SPACE + request.getLastName());
		logger.info("Inside {}#fullNameWithJsonInputAndModelResp() method | Output Response : {}",this.getClass().getSimpleName(), response);
		return response;
	}

}
