package perscholas.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.form.SignupFormBean;

import javax.validation.Valid;

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

    @RequestMapping(value = "/signupSubmit", method = RequestMethod.POST)
    public ModelAndView signupSubmit(@Valid SignupFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.addObject("formBeanKey", form);
        response.setViewName("signup");

        //Create
        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("Error: " + error.getField() + " " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("signup");
        } else {
            //there are no errors, create new user

            User user = new User();
            user.setCompanyName(form.getCompanyName());
            user.setEmail(form.getEmail());
            user.setPassword(form.getPassword());
            user.setConfirmPassword(form.getConfirmPassword());
            user.setPhone(form.getPhone());
            user.setWebsite(form.getWebsite());
            user.setNumEmployees(form.getNumEmployees());
            user.setIndustry(form.getIndustry());
            userDao.save(user);

            response.addObject("userEmail", user.getEmail());
            response.setViewName("redirect:/assessment");
        }
        return response;
    }

}

