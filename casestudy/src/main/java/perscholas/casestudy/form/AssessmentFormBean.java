package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.validation.TwoFieldsAreEqual;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class AssessmentFormBean {

    private Integer id;

    private String email;

    private Integer question1;

    private Integer question2;

    private Integer question3;

    private Integer question4;

    private Integer question5;

    private Integer question6;

    private Integer question7;

    private Integer question8;

    private Integer question9;

    private Integer question10;

    private Integer question11;

    private Integer question12;

    private Integer question13;

    private Integer question14;

    private Integer question15;

    private Integer question16;

    private Integer question17;

    private Integer question18;

    private Integer securityScore;



    private List<String> errorMessages = new ArrayList<>();


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
