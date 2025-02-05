package com.veeraraghavan.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class LoggingFilters implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilters.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("BASE URI :::: {}", requestSpec.getBaseUri());
        logger.info("REQUEST BODY :::: {}", Optional.ofNullable(requestSpec.getBody()));
        logger.info("REQUEST HEADERS :::: {}", requestSpec.getHeaders());
    }

    public void logResponse(Response response) {
        logger.info("RESPONSE STATUS :::: {}", response.getStatusCode());
        logger.info("RESPONSE SESSION ID :::: {}", response.getSessionId());
        logger.info("RESPONSE BODY :::: {}", response.getBody());
    }
}
