package edu.chl.dat076.foodfeed.controller;


import edu.chl.dat076.foodfeed.model.dao.UserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Serves Registration and view of user profiles.
 *
 */
@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(Model model, @Validated User usr, BindingResult result, HttpServletRequest request) {
        logger.info("Registering new user");
        logger.info("Provided password: "+usr.getPassword());
        userDao.create(usr);
        logger.info("Password after DB create: "+usr.getPassword());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usr.getUsername(), usr.getPassword());
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
        
        return "redirect:/";
    }

    /*
     * Form for registering a new user
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showById(@PathVariable String id, Model model) {
        logger.info("showing user with id: "+id);
        model.addAttribute("user", userDao.find(id));
        return "user/show";
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String show(Model model){
        logger.info("showing the authenticated user");
        
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        
        logger.info("the shown principal is "+auth.getName());
        
        User usr = userDao.find(auth.getName());
        
        model.addAttribute("user", usr);
        
        return "user/show";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        logger.info("Showing form to log in.");
        return "user/login";
    }
}
