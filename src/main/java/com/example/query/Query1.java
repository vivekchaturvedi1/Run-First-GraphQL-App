package com.example.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
}
