package perscholas.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("index");

        return response;
    }

    @RequestMapping(value = { "/about" }, method = RequestMethod.GET)
    public ModelAndView about() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("about");

        return response;
    }
}
