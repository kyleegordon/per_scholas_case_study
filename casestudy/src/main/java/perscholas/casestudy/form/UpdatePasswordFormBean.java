package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import perscholas.casestudy.database.entity.User;
import perscholas.casestudy.validation.TwoFieldsAreEqual;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmNewPassword", fieldTwoName = "newPassword", message = "Password and Confirm Password must be the same.")
public class UpdatePasswordFormBean {

    private Integer id;

    @NotEmpty(message = "Current Password is required")
    private String currentPassword;

    @NotEmpty(message = "New Password is required")
    private String newPassword;

    @NotEmpty(message = "Confirm New Password is required")
    private String confirmNewPassword;

    private List<String> errorMessages = new ArrayList<>();

    private List<User> userList = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}

