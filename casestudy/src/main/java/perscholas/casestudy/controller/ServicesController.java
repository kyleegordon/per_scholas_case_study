package perscholas.casestudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.ServicesDAO;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.dao.UserRoleDAO;
import perscholas.casestudy.database.entity.Results;
import perscholas.casestudy.database.entity.Services;
import perscholas.casestudy.database.entity.Survey;
import perscholas.casestudy.database.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class ServicesController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private ServicesDAO servicesDao;


    @RequestMapping(value = { "/services" }, method = RequestMethod.GET)
    public ModelAndView services() throws Exception {
        ModelAndView response = new ModelAndView();
        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);

        List<Results> results = user.getResults();
        List<Services> services = new ArrayList<>();
        Integer questionNum = 18;
        for (int i = (results.size() - 1); i >= (results.size() - 18); i--){
            Integer currentResult = results.get(i).getAnswer();
            if (currentResult < 3){
                Services service = servicesDao.findById(questionNum);
                services.add(service);
            }
            questionNum--;
        }

        response.addObject("servicesList", services);

        response.setViewName("/user/services");

        return response;
    }

    @RequestMapping(value = { "/servicesSubmit" }, method = RequestMethod.POST)
    public ModelAndView servicesSubmit() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("redirect:/user/account");

        return response;
    }
}