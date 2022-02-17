package perscholas.casestudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.dao.UserRoleDAO;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.form.UpdateFormBean;
import perscholas.casestudy.form.UpdatePasswordFormBean;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UpdatePasswordController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = {"/updatePassword"}, method = RequestMethod.GET)
    public ModelAndView updatePassword() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("/user/password");

        return response;
    }

    @RequestMapping(value = {"/updatePasswordSubmit"}, method = RequestMethod.POST)
    public ModelAndView updatePasswordSubmit(@Valid UpdatePasswordFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);

        System.out.println("Current Password: " + user.getPassword());
        System.out.println("Current Form Password: " + form.getCurrentPassword());

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
            String encryptedPassword = passwordEncoder.encode(form.getCurrentPassword());
            System.out.println("Encrypted Form Password: " + encryptedPassword);

            if(user.getPassword().equals(encryptedPassword)){
                System.out.println("New Form Password: " + form.getNewPassword());
                String encryptedNewPassword = passwordEncoder.encode(form.getNewPassword());
                System.out.println("New Encrypted Form Password: " + encryptedNewPassword);
                user.setPassword(encryptedNewPassword);
                userDao.save(user);
                response.setViewName("redirect:/login/logout");
                return response;
            }


        }

        response.setViewName("/user/password");

        return response;
    }
}