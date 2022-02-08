package perscholas.casestudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class AccountController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);


    //TODO access user data from database to populate the User Info form
    //TODO add Update functionality for user table
    //TODO add Delete functionality for user table
    @RequestMapping(value = {"/account"}, method = RequestMethod.GET)
    public ModelAndView userAccount() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/account");
        return response;
    }


}