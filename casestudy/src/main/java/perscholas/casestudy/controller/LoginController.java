package perscholas.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = {  "/login" }, method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        return response;
    }


    @RequestMapping(value = {  "/logoutSuccess" }, method = RequestMethod.GET)
    public ModelAndView logoutSuccess() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/login/login");
        return response;
    }



}
