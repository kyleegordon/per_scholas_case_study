package perscholas.casestudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.dao.UserRoleDAO;
import perscholas.casestudy.database.entity.Survey;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ServicesController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;


    @RequestMapping(value = { "/services" }, method = RequestMethod.GET)
    public ModelAndView services() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("/user/services");

        return response;
    }

    @RequestMapping(value = { "/servicesSubmit" }, method = RequestMethod.POST)
    public ModelAndView servicesSubmit() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("/user/account");

        return response;
    }
}