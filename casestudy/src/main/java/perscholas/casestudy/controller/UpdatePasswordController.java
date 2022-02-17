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

@Controller
@RequestMapping("/user")
public class UpdatePasswordController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;


    @RequestMapping(value = {"/updatePassword"}, method = RequestMethod.GET)
    public ModelAndView updatePassword() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("/user/password");

        return response;
    }

    @RequestMapping(value = {"/updatePasswordSubmit"}, method = RequestMethod.POST)
    public ModelAndView updatePasswordSubmit() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("/user/account");

        return response;
    }
}