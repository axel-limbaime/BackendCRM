package gp2.CRM.User.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/login",
            "/login",
            "/lifecycle",
            "/auth/signup",
            "/auth/teacher",
            "/auth/teachers",
            "/auth/students",
            "/auth/users",
            "/auth/forgot-password",
            "/auth/forgot-password",
            "/auth/users/me",
            "/auth/token",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
