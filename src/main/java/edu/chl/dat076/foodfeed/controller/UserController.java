package edu.chl.dat076.foodfeed.controller;

import edu.chl.dat076.foodfeed.exception.AccessDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Serves Registration and view of user profiles.
 *
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String doRegister() {
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterForm() {
        return null;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String show(@PathVariable long id, Model model) {

        return null;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        logger.info("Showing form to log in.");
        return "user/login";
    }
}
