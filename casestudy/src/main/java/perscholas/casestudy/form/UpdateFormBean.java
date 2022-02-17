package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import perscholas.casestudy.database.entity.User;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class UpdateFormBean {

    private Integer id;

    @NotEmpty(message = "Company Name is required")
    private String companyName;

    @NotEmpty
    private String email;


    @NotEmpty(message = "Phone is required")
    private String phone;

    @NotEmpty(message = "Website is required")
    private String website;

    @NotNull(message = "Number of Employees is required")
    private Integer numEmployees;

    @NotEmpty(message = "Industry is required")
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

