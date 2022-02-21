<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="include/header.jsp" />

<div class="main">
    <div style="color: red;">
        <!--    prints errors on page-->
        <c:forEach var = "message" items = "${formBeanKey.errorMessages}" >
        <p><c:out value = "${message}"/><p>
        </c:forEach>
    </div>

    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Create an Account</h3>
            <table id="signup_table">
                <form name="signupForm" method="POST" action="/signupSubmit">
                    <tr>
                        <td>
                            Company Name
                        </td>
                        <td>
                            <input type="text" name="companyName" value="${formBeanKey.companyName}"required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Contact Email
                        </td>
                        <td>
                            <input type="email" name="email" value="${formBeanKey.email}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password
                        </td>
                        <td>
                            <input type="password" name="password" value="${formBeanKey.password}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Confirm Password
                        </td>
                        <td>
                            <input type="password" name="confirmPassword" value="${formBeanKey.confirmPassword}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Contact Phone #
                        </td>
                        <td>
                            <input type="tel" name="phone" value="${formBeanKey.phone}" placeholder="555-555-5555" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Website URL
                        </td>
                        <td>
                            <input type="text" name="website" value="${formBeanKey.website}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number of Employees
                        </td>
                        <td>
                            <input type="number" name="numEmployees" value="${formBeanKey.numEmployees}" min="1"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Industry
                        </td>
                        <td>
                            <input type="text" name="industry" value="${formBeanKey.industry}" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Data Types Managed
                        </td>
                        <td>
                            <input type="checkbox" id="personal_data" name="personalData">
                            <label for="personal_data">Personal</label>
                            <br>
                            <input type="checkbox" id="healthcare_data" name="healthcareData" >
                            <label for="healthcare_data">Healthcare</label>
                            <br>
                            <input type="checkbox" id="credit_data" name="creditData" >
                            <label for="credit_data">Credit Card</label>
                        </td>
                    </tr>
                    <tr style="text-align: center;">
                        <td colspan="2">
                            <button type="submit" style="text-align: center; padding: 5px; margin-top: 10px;">Create Account</button>
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