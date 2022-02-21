package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.validation.EmailUnique;
import perscholas.casestudy.validation.TwoFieldsAreEqual;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Confirm Password must be the same.")
public class SignupFormBean {

    private Integer id;

    @NotEmpty(message = "Company Name is required")
    private String companyName;

    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$", message = "Email must match pattern")
    @EmailUnique(message = "Email must be unique")
    private String email;

    @NotEmpty(message = "Password is required")
    @Length(min=5, max=25,
            message="Password must be between 5 and 25 characters in length")
    private String password;

    @NotEmpty(message = "Confirm Password is required")
    private String confirmPassword;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @NotEmpty(message = "Website is required")
    private String website;

    @NotNull(message = "Number of Employees is required")
    private Integer numEmployees;

    @NotEmpty(message = "Industry is required")
    private String industry;


    private boolean personalData;


    private boolean healthcareData;


    private boolean creditData;


    private List<String> errorMessages = new ArrayList<>();

    private List<User> userList = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
