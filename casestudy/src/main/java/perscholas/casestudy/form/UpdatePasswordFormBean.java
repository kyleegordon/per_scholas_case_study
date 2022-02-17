package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;
import perscholas.casestudy.validation.TwoFieldsAreEqual;

import javax.validation.constraints.NotEmpty;

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

}
