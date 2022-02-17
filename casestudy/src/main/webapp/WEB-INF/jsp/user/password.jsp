<jsp:include page="../include/header.jsp" />

<div class="main">
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Change Password</h3>
            <table id="password_table">
                <%--    action url references spring security--%>
                <form method="POST" action="/user/updatePasswordSubmit">
                    <tr>
                        <td>
                            Current Password
                        </td>
                        <td>
                            <input type="password" name="currentPassword" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            New Password
                        </td>
                        <td>
                            <input type="password" name="newPassword" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Confirm New Password
                        </td>
                        <td>
                            <input type="password" name="confirmNewPassword" required />
                        </td>
                    </tr>
                    <tr style="text-align: center;">
                        <td colspan="2">
                            <input type="submit" value="Submit">
                        </td>
                    </tr>
                </form>
            </table>
        </div>
        <div class="main__img--container">
            <img src="../../../pub/images/undraw_unlock_-24-mb.svg" alt="surveillance image" id="main__img">
        </div>
    </div>
</div>

<div class="services" id="login_services"></div>

<jsp:include page="../include/footer.jsp" />

</body>
</html>