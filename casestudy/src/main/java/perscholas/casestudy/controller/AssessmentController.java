package perscholas.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import perscholas.casestudy.database.dao.AssessmentDAO;
import perscholas.casestudy.database.dao.SurveyDAO;
import perscholas.casestudy.database.dao.ResultsDAO;
import perscholas.casestudy.database.dao.UserDAO;
//import perscholas.casestudy.database.entity.Assessment;
import perscholas.casestudy.database.entity.Survey;
import perscholas.casestudy.database.entity.Results;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.form.AssessmentFormBean;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AssessmentController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private SurveyDAO surveyDao;

    @Autowired
    private ResultsDAO resultsDao;

//    @Autowired
//    private AssessmentDAO assessmentDao;

    @RequestMapping(value = { "/assessment" }, method = RequestMethod.GET)
    public ModelAndView assessment() throws Exception {
        ModelAndView response = new ModelAndView();

        //get questions to be displayed on assessment form
        List<Survey> questions= surveyDao.findAll();
        for (int i = 0; i < questions.size(); i++){
            response.addObject("question" + (i + 1), questions.get(i).getQuestion());
        }

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

        System.out.println("User id: " + user.getId());


        //collects data from assessment form and saves it to assessment database with user_id as a foreign key
//        Assessment assessment = new Assessment();
//        assessment.setId(user.getId());
//        assessment.setQuestion1(form.getQuestion1());
//        assessment.setQuestion2(form.getQuestion2());
//        assessment.setQuestion3(form.getQuestion3());
//        assessment.setQuestion4(form.getQuestion4());
//        assessment.setQuestion5(form.getQuestion5());
//        assessment.setQuestion6(form.getQuestion6());
//        assessment.setQuestion7(form.getQuestion7());
//        assessment.setQuestion8(form.getQuestion8());
//        assessment.setQuestion9(form.getQuestion9());
//        assessment.setQuestion10(form.getQuestion10());
//        assessment.setQuestion11(form.getQuestion11());
//        assessment.setQuestion12(form.getQuestion12());
//        assessment.setQuestion13(form.getQuestion13());
//        assessment.setQuestion14(form.getQuestion14());
//        assessment.setQuestion15(form.getQuestion15());
//        assessment.setQuestion16(form.getQuestion16());
//        assessment.setQuestion17(form.getQuestion17());
//        assessment.setQuestion18(form.getQuestion18());

        LocalDateTime date = LocalDateTime.now();

        Results result1 = new Results();
        result1.setUserId(user.getId());
        result1.setQuestionId(1);
        result1.setAnswer(form.getQuestion1());
        result1.setDate(date);
        resultsDao.save(result1);

        Results result2 = new Results();
        result2.setUserId(user.getId());
        result2.setQuestionId(2);
        result2.setAnswer(form.getQuestion2());
        result2.setDate(date);
        resultsDao.save(result2);

        Results result3 = new Results();
        result3.setUserId(user.getId());
        result3.setQuestionId(3);
        result3.setAnswer(form.getQuestion3());
        result3.setDate(date);
        resultsDao.save(result3);

        Results result4 = new Results();
        result4.setUserId(user.getId());
        result4.setQuestionId(4);
        result4.setAnswer(form.getQuestion4());
        result4.setDate(date);
        resultsDao.save(result4);

        Results result5 = new Results();
        result5.setUserId(user.getId());
        result5.setQuestionId(5);
        result5.setAnswer(form.getQuestion5());
        result5.setDate(date);
        resultsDao.save(result5);

        Results result6 = new Results();
        result6.setUserId(user.getId());
        result6.setQuestionId(6);
        result6.setAnswer(form.getQuestion6());
        result6.setDate(date);
        resultsDao.save(result6);

        Results result7 = new Results();
        result7.setUserId(user.getId());
        result7.setQuestionId(7);
        result7.setAnswer(form.getQuestion7());
        result7.setDate(date);
        resultsDao.save(result7);

        Results result8 = new Results();
        result8.setUserId(user.getId());
        result8.setQuestionId(8);
        result8.setAnswer(form.getQuestion8());
        result8.setDate(date);
        resultsDao.save(result8);

        Results result9 = new Results();
        result9.setUserId(user.getId());
        result9.setQuestionId(9);
        result9.setAnswer(form.getQuestion9());
        result9.setDate(date);
        resultsDao.save(result9);

        Results result10 = new Results();
        result10.setUserId(user.getId());
        result10.setQuestionId(10);
        result10.setAnswer(form.getQuestion10());
        result10.setDate(date);
        resultsDao.save(result10);

        Results result11 = new Results();
        result11.setUserId(user.getId());
        result11.setQuestionId(11);
        result11.setAnswer(form.getQuestion11());
        result11.setDate(date);
        resultsDao.save(result11);

        Results result12 = new Results();
        result12.setUserId(user.getId());
        result12.setQuestionId(12);
        result12.setAnswer(form.getQuestion12());
        result12.setDate(date);
        resultsDao.save(result12);

        Results result13 = new Results();
        result13.setUserId(user.getId());
        result13.setQuestionId(13);
        result13.setAnswer(form.getQuestion13());
        result13.setDate(date);
        resultsDao.save(result13);

        Results result14 = new Results();
        result14.setUserId(user.getId());
        result14.setQuestionId(14);
        result14.setAnswer(form.getQuestion14());
        result14.setDate(date);
        resultsDao.save(result14);

        Results result15 = new Results();
        result15.setUserId(user.getId());
        result15.setQuestionId(15);
        result15.setAnswer(form.getQuestion15());
        result15.setDate(date);
        resultsDao.save(result15);

        Results result16 = new Results();
        result16.setUserId(user.getId());
        result16.setQuestionId(16);
        result16.setAnswer(form.getQuestion16());
        result16.setDate(date);
        resultsDao.save(result16);

        Results result17 = new Results();
        result17.setUserId(user.getId());
        result17.setQuestionId(17);
        result17.setAnswer(form.getQuestion17());
        result17.setDate(date);
        resultsDao.save(result17);

        Results result18 = new Results();
        result18.setUserId(user.getId());
        result18.setQuestionId(18);
        result18.setAnswer(form.getQuestion18());
        result18.setDate(date);
        resultsDao.save(result18);

        //TODO Still need to calculate and add security score
//        assessmentDao.save(assessment);
        response.setViewName("redirect:/user/account");
        return response;
    }
}
