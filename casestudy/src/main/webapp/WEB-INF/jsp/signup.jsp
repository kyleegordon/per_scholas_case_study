<jsp:include page="include/header.jsp" />

<div class="main">
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Create an Account</h3>
            <table id="signup_table">
                <form name="signupForm">
                    <tr>
                        <td>
                            <label for="company_name">Company Name</label>
                        </td>
                        <td>
                            <input type="text" id="company_name" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="email">Contact Email</label>
                        </td>
                        <td>
                            <input type="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">Password</label>
                        </td>
                        <td>
                            <input type="password" id="password" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="phone">Contact Phone #</label>
                        </td>
                        <td>
                            <input type="tel" id="phone" placeholder="555-555-5555" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="website">Website URL</label>
                        </td>
                        <td>
                            <input type="text" id="website" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="employees">Number of Employees</label>
                        </td>
                        <td>
                            <input type="number" id="employees" min="1"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="industry">Industry</label>
                        </td>
                        <td>
                            <input type="text" id="industry" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="security_professionals">Do you employ security professionals</label>
                        </td>
                        <td>
                            <input type="radio" id="yes" name="security_professionals" value="yes">
                            <label for="yes">Yes</label>
                            <input type="radio" id="no" name="security_professionals" value="no" checked>
                            <label for="no">No</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="data_types">Data Types Managed</label>
                        </td>
                        <td>
                            <input type="checkbox" id="data1" name="data_types" value="Personal">
                            <label for="data1">Personal</label>
                            <br>
                            <input type="checkbox" id="data2" name="data_types" value="Healthcare">
                            <label for="data2">Healthcare</label>
                            <br>
                            <input type="checkbox" id="data3" name="data_types" value="Credit">
                            <label for="data3">Credit Card</label>
                            <br>
                            <input type="checkbox" id="data4" name="data_types" value="Other">
                            <label for="data4">Other</label>
                        </td>
                    </tr>
                    <tr style="text-align: center;">
                        <td colspan="2">
                            <input type="button" value="Create Account" onclick="return collectData()" style="text-align: center; padding: 5px; margin-top: 10px;">
                        </td>
                    </tr>
                </form>
            </table>
        </div>
        <div class="main__img--container">
            <img src="../../../pub/images/undraw_programmer_re_owql.svg" alt="cyber professional image" id="main__img">
        </div>
    </div>
</div>

<div class="services" id="signup_services"></div>

<jsp:include page="include/footer.jsp" />
<script src="../../pub/js/signup_form.js"></script>
</body>
</html>