package com.gateway.ApiGateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    //below code will bypass the request and not authenticate of request is coming to below end point from gateway
    public static final List<String> openApiEndpoints = List.of(
            "/api/admin/signup",
            "/api/admin/login",
            "/api/matches/",

            "/api/players/"



    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
