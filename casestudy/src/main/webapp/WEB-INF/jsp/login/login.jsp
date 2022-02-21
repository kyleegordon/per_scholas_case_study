<jsp:include page="../include/header.jsp" />

<div class="main">
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Login</h3>
            <table id="login_table" class="form_table">
                <%--    action url references spring security--%>
                <form method="POST" action="/login/loginSecurityPost">
                    <tr>
                        <td>
                            <label for="username">Email: </label>
                        </td>
                        <td>
                            <input type="text" id="username" name="username" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">Password: </label>
                        </td>
                        <td>
                            <input type="password" id="password" name="password" required/>
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
            <img src="../../../pub/images/undraw_hacker_mind_-6-y85.svg" alt="surveillance image" id="main__img">
        </div>
    </div>
</div>

<div class="services" id="login_services"></div>

<jsp:include page="../include/footer.jsp" />

</body>
</html>