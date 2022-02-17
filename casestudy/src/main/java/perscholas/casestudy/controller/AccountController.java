package perscholas.casestudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.ResultsDAO;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.dao.UserRoleDAO;
import perscholas.casestudy.database.entity.Results;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.database.entity.UserRole;
import perscholas.casestudy.form.SignupFormBean;
import perscholas.casestudy.form.UpdateFormBean;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class AccountController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

//    @Autowired
//    private ResultsDAO resultsDao;


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

        //TODO decide how I want to display survey results and finish implementing it
        List<Results> results = user.getResults();
        Integer securityScore = 0;
        System.out.println(results);
        for (int i = 0; i < results.size(); i++){
            System.out.println("Result " + i + ": " + results.get(i).getAnswer());
            securityScore += (Integer) results.get(i).getAnswer();
            response.addObject("result" + (i+1), results.get(i).getAnswer());
        }

        securityScore = (securityScore*100)/90;
        System.out.println("Secutiry Score: " + securityScore);
        response.addObject("securityScore", securityScore);


        return response;
    }

    @RequestMapping(value = {"/accountSubmit"}, method = RequestMethod.POST)
    public ModelAndView updateAccount(@Valid UpdateFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/account");

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);
        System.out.println("username: " + user.getEmail());
        System.out.println("password: " + user.getPassword());

        //Update
        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("Error: " + error.getField() + " " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("user/account");
        } else {
            //there are no errors, update user

            user.setCompanyName(form.getCompanyName());
            user.setPhone(form.getPhone());
            user.setWebsite(form.getWebsite());
            user.setNumEmployees(form.getNumEmployees());
            user.setIndustry(form.getIndustry());
            userDao.save(user);

            user = userDao.save(user);

        }
        return response;
    }

    @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
    public ModelAndView deleteAccount() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/index");

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        UserRole userRole = userRoleDao.findByUserId(user.getId());

        userRoleDao.delete(userRole);

        userDao.delete(user);

        return response;
    }

}