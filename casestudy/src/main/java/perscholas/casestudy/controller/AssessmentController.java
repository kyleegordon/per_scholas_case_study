package perscholas.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.casestudy.database.dao.AssessmentDAO;
import perscholas.casestudy.database.dao.UserDAO;
import perscholas.casestudy.database.entity.Assessment;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.form.AssessmentFormBean;
import perscholas.casestudy.form.SignupFormBean;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class AssessmentController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AssessmentDAO assessmentDao;

    @RequestMapping(value = { "/assessment" }, method = RequestMethod.GET)
    public ModelAndView assessment() throws Exception {
        ModelAndView response = new ModelAndView();

        //refers to the name of the jsp file
        response.setViewName("user/assessment");

        return response;
    }


    @RequestMapping(value = "/assessmentSubmit", method = RequestMethod.POST)
    public ModelAndView assessmentSubmit(@Valid AssessmentFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        //this gets username from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //uses currentPrincipalName to find user info from the database
        User user = userDao.findByEmail(currentPrincipalName);
        response.addObject("userProfile", user);


        //collects data from assessment form and saves it to assessment database with user_id as a foreign key
        Assessment assessment = new Assessment();
        assessment.setId(user.getId());
        assessment.setQuestion1(form.getQuestion1());
        assessment.setQuestion2(form.getQuestion2());
        assessment.setQuestion3(form.getQuestion3());
        assessment.setQuestion4(form.getQuestion4());
        assessment.setQuestion5(form.getQuestion5());
        assessment.setQuestion6(form.getQuestion6());
        assessment.setQuestion7(form.getQuestion7());
        assessment.setQuestion8(form.getQuestion8());
        assessment.setQuestion9(form.getQuestion9());
        assessment.setQuestion10(form.getQuestion10());
        assessment.setQuestion11(form.getQuestion11());
        assessment.setQuestion12(form.getQuestion12());
        assessment.setQuestion13(form.getQuestion13());
        assessment.setQuestion14(form.getQuestion14());
        assessment.setQuestion15(form.getQuestion15());
        assessment.setQuestion16(form.getQuestion16());
        assessment.setQuestion17(form.getQuestion17());
        assessment.setQuestion18(form.getQuestion18());

        //TODO Still need to calculate and add security score
        assessmentDao.save(assessment);
        response.setViewName("redirect:/user/account");
        return response;
    }
}
