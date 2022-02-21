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
            <table id="results_table" style="text-align: left;">
                    <tr>
                        <td>
                            Hardware Inventory: ${result1}
                        </td>
                        <td>
                            Software Inventory: ${result2}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Device Encryption: ${result3}
                        </td>
                        <td>
                            Device Management: ${result4}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Employee Accounts: ${result5}
                        </td>
                        <td>
                            Account Management: ${result6}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Software Updates: ${result7}
                        </td>
                        <td>
                            Critical Event Logging: ${result8}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Multi-factor Authentication: ${result9}
                        </td>
                        <td>
                            Anti-virus: ${result10}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Data Backups: ${result11}
                        </td>
                        <td>
                            WIFI: ${result12}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Network Equipment: ${result13}
                        </td>
                        <td>
                            Security Awareness: ${result14}
                        </td>
                    </tr>
                <tr>
                    <td>
                        Service Providers: ${result15}
                    </td>
                    <td>
                        Software Licensing: ${result16}
                    </td>
                </tr>
                <tr>
                    <td>
                       Response Planning: ${result17}
                    </td>
                    <td>
                        Testing: ${result18}
                    </td>
                </tr>
                    <tr>
                        <td>
                            Overall Score:
                        </td>
                        <td>
                            ${securityScore}% ${securityGrade}
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

<div class="services"></div>

<jsp:include page="../include/footer.jsp" />

</body>
</html>