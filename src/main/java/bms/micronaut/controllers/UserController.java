package bms.micronaut.controllers;

import bms.micronaut.models.UserModel;
import bms.micronaut.services.UserService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/register")
public class UserController {

    @Inject
    UserService userService;

    @Post
    public String saveUser(@Body UserModel userModel) throws Exception {

        return userService.saveUser(userModel);
    }
}
