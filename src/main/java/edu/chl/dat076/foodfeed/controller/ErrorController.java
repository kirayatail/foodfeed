package edu.chl.dat076.foodfeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Shows error pages for 403 and 404s.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String error404() {
        return "error/404";
    }

    @RequestMapping("/403")
    public String error403() {
        return "error/403";
    }
}
