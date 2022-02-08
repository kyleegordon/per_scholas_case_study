package perscholas.casestudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.entity.User;

@Controller
@RequestMapping("/user")
public class AccountController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDAO userDao;


    //TODO add Update functionality for user table
    //TODO add Delete functionality for user table
    //TODO access assessment data from database and display assessment results on account page too
    @RequestMapping(value = {"/account"}, method = RequestMethod.GET)
    public ModelAndView userAccount() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/account");

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);


        return response;
    }


}