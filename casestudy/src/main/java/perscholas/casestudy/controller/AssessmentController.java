package perscholas.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssessmentController {

    @RequestMapping(value = { "/assessment" }, method = RequestMethod.GET)
    public ModelAndView assessment() throws Exception {
        ModelAndView response = new ModelAndView();

        //refers to the name of the jsp file
        response.setViewName("assessment");

        return response;
    }
}
