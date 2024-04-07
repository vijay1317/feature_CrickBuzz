package com.gateway.ApiGateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {


    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private RestTemplate restTemplate;
    public AuthenticationFilter() {
        super(Config.class);
    }
// all the logic should be write here also Annotate or enable webflux Dependency
    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {


            if(exchange.getRequest().getMethod() == HttpMethod.POST && routeValidator.isSecured.test(exchange.getRequest())){

                //header contains token or not
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("missing authorization header");
                }
                String authHeader =exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);//geting the token
                if(authHeader!=null && authHeader.startsWith("Bearer ")){
                    authHeader = authHeader.substring(7);//token
                }
                try{
                    System.out.println("Tocken....."+authHeader);
//                    Rest call to Auth Service
                    restTemplate.getForObject("http://localhost:8082/api/admin/validate?token=" + authHeader, String.class);
                }catch (Exception e){
                    System.out.println("exception");
                    throw  new RuntimeException("UnAuthorize access invalid token");
                }
            }

            return chain.filter(exchange);
        }));
    }

    public static class Config{

    }
}
