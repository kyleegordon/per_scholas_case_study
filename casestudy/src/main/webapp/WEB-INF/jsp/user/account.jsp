<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<div class="main">
    <div style="color: red;">
        <!--    prints errors on page-->
        <c:forEach var = "message" items = "${formBeanKey.errorMessages}" >
        <p><c:out value = "${message}"/><p>
        </c:forEach>
    </div>
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">User Info</h3>
            <table id="account_table" class="form_table">
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
                            <input type="text" name="website" value="${userProfile.website}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number of Employees
                        </td>
                        <td>
                            <input type="number" name="numEmployees" value="${userProfile.numEmployees}" min="1" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Industry
                        </td>
                        <td>
                            <input type="text" name="industry" value="${userProfile.industry}" required />
                        </td>
                    </tr>

                    <tr style="text-align: center;">
                        <td colspan="2">
                            <button type="submit" style="text-align: center; padding: 5px; margin-top: 10px;">Update Account</button>
                            </form>

                            <button type="button" style="text-align: center; padding: 5px; margin-top: 10px;"><a href="/user/updatePassword">Change Password</a></button>

                            <button type="button" style="text-align: center; padding: 5px; margin-top: 10px;"><a href="/user/deleteAccount">Delete Account</a></button>
                        </td>
                    </tr>
            </table>
        </div>
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Assessment Results</h3>
            <table id="results_table" style="text-align: left; font-size: 1.2rem;" class="form_table">
                    <tr>
                        <td>
                            Hardware Inventory: <span class="change-color"><b>${result1}</b></span>
                        </td>
                        <td>
                            Software Inventory: <span class="change-color"><b>${result2}</b></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Device Encryption: <span class="change-color"><b>${result3}</b></span>
                        </td>
                        <td>
                            Device Management: <span class="change-color"><b>${result4}</b></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Employee Accounts: <span class="change-color"><b>${result5}</b></span>
                        </td>
                        <td>
                            Account Management: <span class="change-color"><b>${result6}</b></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Software Updates: <span class="change-color"><b>${result7}</b></span>
                        </td>
                        <td>
                            Critical Event Logging: <span class="change-color"><b>${result8}</b></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Multi-factor Authentication: <span class="change-color"><b>${result9}</b></span>
                        </td>
                        <td>
                            Anti-virus: <span class="change-color"><b>${result10}</b></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Data Backups: <span class="change-color"><b>${result11}</b></span>
                        </td>
                        <td>
                            WIFI: <span class="change-color"><b>${result12}</b></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Network Equipment: <span class="change-color"><b>${result13}</b></span>
                        </td>
                        <td>
                            Security Awareness: <span class="change-color"><b>${result14}</b></span>
                        </td>
                    </tr>
                <tr>
                    <td>
                        Service Providers: <span class="change-color"><b>${result15}</b></span>
                    </td>
                    <td>
                        Software Licensing: <span class="change-color"><b>${result16}</b></span>
                    </td>
                </tr>
                <tr>
                    <td>
                       Response Planning: <span class="change-color"><b>${result17}</b></span>
                    </td>
                    <td>
                        Testing: <span class="change-color"><b>${result18}</b></span>
                    </td>
                </tr>
                    <tr>
                        <td>
                            Overall Score:
                        </td>
                        <td>
                            ${securityScore}% <span class="change-color"><b>${securityGrade}</b></span>
                        </td>
                    </tr>
                    <tr style="text-align: center;">
                        <td>
                            <button type="button" style="text-align: center; padding: 5px; margin-top: 10px;"><a href="/user/services">View Recommended Services</a></button>
                        </td>
                        <td>
                            <button type="button" style="text-align: center; padding: 5px; margin-top: 10px;"><a href="/user/assessment">Retake Assessment</a></button>
                        </td>
                    </tr>
            </table>
        </div>
    </div>
</div>

<div class="services" id="account_services">
    <div style="margin:0 10% 0 10%;" class="enrolled_services_div services__container">
        <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Enrolled Services</h3>
        <table id="enrolled_services_table" class="form_table">
            <form name="servicesForm" method="GET" action="/user/unenrollServicesSubmit">

                <c:forEach items="${servicesSet}" var="service">
                    <tr class="enrolled_row">
                        <td><input type="checkbox" name="${service.variable}"></td>
                        <td>${service.serviceName}:</td>
                        <td>${service.serviceDescription}</td>
                    </tr>
                </c:forEach>

                <tr style="text-align: center;">
                    <td colspan="2">
                        <button type="submit" style="text-align: center; padding: 5px;">Unenroll</button>
                    </td>
                </tr>
            </form>
        </table>
    </div>
</div>

<jsp:include page="../include/footer.jsp" />
<script>
    var myDiv =  document.getElementsByClassName('enrolled_services_div')
    var tableRows = document.getElementsByClassName('enrolled_row');

    if (tableRows.length == 0)
    {
        alert("if statement success")
        myDiv[0].style.display = 'none';
    }

    var elements = document.getElementsByClassName('change-color');

    for (var i in elements) {
        if (elements[i].textContent == 'A') {
            elements[i].className = "colorA"
        } else if (elements[i].textContent == 'B') {
            elements[i].className = "colorB";
        } else if (elements[i].textContent == 'C') {
            elements[i].className = "colorC";
        } else if (elements[i].textContent == 'D') {
            elements[i].className = "colorD";
        } else {
            elements[i].className = "colorF";
        }
    }



</script>
</body>
</html>