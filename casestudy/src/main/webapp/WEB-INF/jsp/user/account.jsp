<jsp:include page="../include/header.jsp" />

<div class="main">
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">User Info</h3>
            <table id="account_table">
                <form name="accountForm" method="POST" action="/user/accountSubmit">
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
                            <input type="email" name="email" value="${userProfile.email}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" readonly/>
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
                            <button type="submit" style="text-align: center; padding: 5px; margin-top: 10px;">Update Account</button>
                            </form>
                        </td>
                        <td><button type="button" style="text-align: center; padding: 5px; margin-top: 10px;"><a href="/user/deleteAccount">Delete Account</a></button></td>
                    </tr>
            </table>
        </div>
        <div class="main__img--container">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Assessment Results</h3>
            <table id="results_table">
                    <tr>
                        <td>
                            Question 1: ${result1}
                        </td>
                        <td>
                            Question 10: ${result10}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Question 2: ${result2}
                        </td>
                        <td>
                            Question 11: ${result11}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Question 3: ${result3}
                        </td>
                        <td>
                            Question 12: ${result12}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Question 4: ${result4}
                        </td>
                        <td>
                            Question 13: ${result13}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Question 5: ${result5}
                        </td>
                        <td>
                            Question 14: ${result14}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Question 6: ${result6}
                        </td>
                        <td>
                            Question 15: ${result15}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Question 7: ${result7}
                        </td>
                        <td>
                            Question 16: ${result16}
                        </td>
                    </tr>
                <tr>
                    <td>
                        Question 8: ${result8}
                    </td>
                    <td>
                        Question 17: ${result17}
                    </td>
                </tr>
                <tr>
                    <td>
                        Question 9: ${result9}
                    </td>
                    <td>
                        Question 18: ${result18}
                    </td>
                </tr>
                    <tr>
                        <td>
                            Overall Score:
                        </td>
                        <td>
                            ${securityScore}
                        </td>
                    </tr>
                    <tr style="text-align: center;">
                        <td>
                            <button type="button" style="text-align: center; padding: 5px; margin-top: 10px;">View Recommended Services</button>
                        </td>
                        <td>
                            <button type="button" style="text-align: center; padding: 5px; margin-top: 10px;">Retake Assessment</button>
                        </td>
                    </tr>
            </table>
        </div>
    </div>
</div>

<div class="services"></div>

<jsp:include page="../include/footer.jsp" />

</body>
</html>