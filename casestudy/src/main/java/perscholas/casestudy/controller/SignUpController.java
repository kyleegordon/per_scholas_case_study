package perscholas.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.UserDAO;

@Controller
public class SignUpController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public ModelAndView signup() throws Exception {
        ModelAndView response = new ModelAndView();

        //refers to the name of the jsp file
        response.setViewName("signup");

        return response;
    }
}

