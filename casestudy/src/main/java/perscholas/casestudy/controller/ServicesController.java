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
import perscholas.casestudy.database.dao.SurveyDAO;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.dao.UserRoleDAO;
import perscholas.casestudy.database.entity.Results;
import perscholas.casestudy.database.entity.Services;
import perscholas.casestudy.database.entity.Survey;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.form.ServiceEnrollFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private SurveyDAO surveyDao;


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
        Set<Services> enrolledServices = user.getServices();
        Integer questionNum = 18;

        // add service to list to be displayed on jsp page if score < 3,
        // the service is not already on the list, and the user is not already enrolled in service
        for (int i = (results.size() - 1); i >= (results.size() - 18); i--){
            Integer currentResult = results.get(i).getAnswer();
            if (currentResult < 3){
                Survey survey = surveyDao.findById(results.get(i).getQuestionId());
                Services service = survey.getService();
                if (!services.contains(service) && !enrolledServices.contains(service))
                {
                    services.add(service);
                }
            }
            questionNum--;
        }

        //adds service for credit data
        if (!services.contains(servicesDao.findById(5)) && !enrolledServices.contains(servicesDao.findById(5))){
            if (user.isCreditData()){
                services.add(servicesDao.findById(5));
            }
        }

        //adds service for healthcare data
        if (!services.contains(servicesDao.findById(6)) && !enrolledServices.contains(servicesDao.findById(6))){
            if (user.isHealthcareData()){
                services.add(servicesDao.findById(6));
            }
        }

        //adds service for personal data
        if (!services.contains(servicesDao.findById(7)) && !enrolledServices.contains(servicesDao.findById(7))){
            if (user.isPersonalData()){
                services.add(servicesDao.findById(7));
            }
        }

        response.addObject("servicesList", services);
        response.setViewName("/user/services");

        return response;
    }

    @RequestMapping(value = { "/servicesSubmit" }, method = RequestMethod.POST)
    public ModelAndView servicesSubmit(@Valid ServiceEnrollFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);

        Set<Services> enrollServices = user.getServices();

        if(form.isDeviceManagement() && !enrollServices.contains(servicesDao.findById(1))){
            enrollServices.add(servicesDao.findById(1));
        }

        if(form.isIdentityManagement() && !enrollServices.contains(servicesDao.findById(2))){
            enrollServices.add(servicesDao.findById(2));
        }

        if(form.isNetworkManagement() && !enrollServices.contains(servicesDao.findById(3))){
            enrollServices.add(servicesDao.findById(3));
        }

        if(form.isProactiveServices() && !enrollServices.contains(servicesDao.findById(4))){
            enrollServices.add(servicesDao.findById(4));
        }

        if(form.isPci() && !enrollServices.contains(servicesDao.findById(5))){
            enrollServices.add(servicesDao.findById(5));
        }

        if(form.isHiipa() && !enrollServices.contains(servicesDao.findById(6))){
            enrollServices.add(servicesDao.findById(6));
        }

        if(form.isPii() && !enrollServices.contains(servicesDao.findById(7))){
            enrollServices.add(servicesDao.findById(7));
        }

        user.setServices(enrollServices);

        userDao.save(user);

        response.setViewName("redirect:/user/account");

        return response;
    }

    @RequestMapping(value = { "/unenrollServicesSubmit" }, method = RequestMethod.GET)
    public ModelAndView unenrollServicesSubmit(@Valid ServiceEnrollFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);

        Set<Services> services = user.getServices();

        if(form.isDeviceManagement() && services.contains(servicesDao.findById(1))){
            services.remove(servicesDao.findById(1));
        }

        if(form.isIdentityManagement() && services.contains(servicesDao.findById(2))){
            services.remove(servicesDao.findById(2));
        }

        if(form.isNetworkManagement() && services.contains(servicesDao.findById(3))){
            services.remove(servicesDao.findById(3));
        }

        if(form.isProactiveServices() && services.contains(servicesDao.findById(4))){
            services.remove(servicesDao.findById(4));
        }

        if(form.isPci() && services.contains(servicesDao.findById(5))){
            services.remove(servicesDao.findById(5));
        }

        if(form.isHiipa() && services.contains(servicesDao.findById(6))){
            services.remove(servicesDao.findById(6));
        }

        if(form.isPii() && services.contains(servicesDao.findById(7))){
            services.remove(servicesDao.findById(7));
        }

        user.setServices(services);

        userDao.save(user);
        response.setViewName("redirect:/user/account");

        return response;
    }
}