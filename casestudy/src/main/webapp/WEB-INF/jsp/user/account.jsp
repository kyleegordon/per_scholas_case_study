<jsp:include page="../include/header.jsp" />

<div class="main">
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">User Info</h3>
            <table id="account_table">
                <form name="accountForm" method="POST" action="/accountSubmit">
                    <tr>
                        <td>
                            Company Name
                        </td>
                        <td>
                            <input type="text" name="companyName" value="${userProfile.companyName}"required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Contact Email
                        </td>
                        <td>
                            <input type="email" name="email" value="${userProfile.email}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password
                        </td>
                        <td>
                            <input type="password" name="password" value="${userProfile.password}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Confirm Password
                        </td>
                        <td>
                            <input type="password" name="confirmPassword" value="${userProfile.confirmPassword}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Contact Phone #
                        </td>
                        <td>
                            <input type="tel" name="phone" value="${userProfile.phone}" placeholder="555-555-5555" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Website URL
                        </td>
                        <td>
                            <input type="text" name="website" value="${userProfile.website}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number of Employees
                        </td>
                        <td>
                            <input type="number" name="numEmployees" value="${userProfile.numEmployees}" min="1"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Industry
                        </td>
                        <td>
                            <input type="text" name="industry" value="${userProfile.industry}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="securityProfessionals">Do you employ security professionals</label>
                        </td>
                        <td>
                            <input type="radio" id="yes" name="securityProfessionals" value="yes">
                            <label for="yes">Yes</label>
                            <input type="radio" id="no" name="securityProfessionals" value="no" checked>
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
                        <td>
                            <button type="submit" style="text-align: center; padding: 5px; margin-top: 10px;">Edit User Info</button>
                        </td>
                        <td><button style="text-align: center; padding: 5px; margin-top: 10px;"><a href="">Delete Account</a></button></td>
                    </tr>
                </form>
            </table>
        </div>
        <div class="main__img--container">
            <img src="../../../pub/images/undraw_hacker_mind_-6-y85.svg" alt="surveillance image" id="main__img">
        </div>
    </div>
</div>

<div class="services"></div>

<jsp:include page="../include/footer.jsp" />

</body>
</html>