package perscholas.casestudy.controller;

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
import perscholas.casestudy.database.entity.Services;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.database.entity.UserRole;
import perscholas.casestudy.form.UpdateFormBean;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private ResultsDAO resultsDAO;

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

        List<Results> results = user.getResults();
        Integer securityScore = 0;
        int questionNum = 18;
        for (int i = (results.size() - 1); i >= (results.size() - 18); i--){
           Integer currentResult = results.get(i).getAnswer();
            String resultGrade;

           switch(results.get(i).getAnswer()){
               case 5:
                   resultGrade = "A";
                   break;
               case 4:
                   resultGrade = "B";
                   break;
               case 3:
                   resultGrade = "C";
                   break;
               case 2:
                   resultGrade = "D";
                   break;
               default:
                   resultGrade = "F";
           }
            securityScore += currentResult;
            response.addObject("result" + questionNum, resultGrade);
            questionNum--;
        }

        String securityGrade;
        securityScore = (securityScore*100)/90;
        if(securityScore < 60){
            securityGrade = "F";
        } else if(securityScore < 70){
            securityGrade = "D";
        } else if(securityScore < 80){
            securityGrade = "C";
        } else if(securityScore < 90){
            securityGrade = "B";
        } else{
            securityGrade = "A";
        }

        response.addObject("securityScore", securityScore);
        response.addObject("securityGrade", securityGrade);

        Set<Services> servicesSet = user.getServices();
        response.addObject("servicesSet", servicesSet);

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

        List<Results> results = resultsDAO.findAllByUserId(user.getId());

        if (results.size() > 0) {
            resultsDAO.deleteAll(results);
        }

        if (user.getServices().size() > 0) {
            Set<Services> emptyServiceSet = new HashSet<>();
            user.setServices(emptyServiceSet);
            userDao.save(user);
        }

        if (userRole != null) {
            userRoleDao.delete(userRole);
        }

        userDao.delete(user);

        return response;
    }

}