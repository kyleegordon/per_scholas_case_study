package perscholas.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public ModelAndView signup() throws Exception {
        ModelAndView response = new ModelAndView();

        //refers to the name of the jsp file
        response.setViewName("signup");

        return response;
    }
}

