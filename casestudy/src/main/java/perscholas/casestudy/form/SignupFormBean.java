package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import perscholas.casestudy.validation.TwoFieldsAreEqual;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Confirm Password must be the same.")
public class SignupFormBean {

    private Integer id;

    @NotEmpty
    private String companyName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String website;

    @NotEmpty
    private Integer numEmployees;

    @NotEmpty
    private String industry;


    private boolean securityProfessionals;


    private boolean personalData;


    private boolean healthcareData;


    private boolean creditData;

    private boolean otherData;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
