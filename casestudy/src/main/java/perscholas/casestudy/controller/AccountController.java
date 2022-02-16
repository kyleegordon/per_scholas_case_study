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
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.form.SignupFormBean;
import perscholas.casestudy.form.UpdateFormBean;

import javax.validation.Valid;

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

            //add user role
            user = userDao.save(user);

        }
        return response;
    }


}