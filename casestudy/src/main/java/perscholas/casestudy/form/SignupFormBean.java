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

    @NotNull
    private Integer numEmployees;

    @NotEmpty
    private String industry;


    private boolean securityProfessionals;


    private boolean personalData;


    private boolean healthcareData;


    private boolean creditData;

    private boolean otherData;

    private List<String> errorMessages = new ArrayList<>();

    private List<User> userList = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
