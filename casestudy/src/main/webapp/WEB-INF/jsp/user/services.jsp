<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<div class="main">
    <div class="main__container">
        <div class="main__content">
            <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Recommended Services</h3>
            <table id="services_table" class="form_table">
                <form name="servicesForm" method="POST" action="/user/servicesSubmit">

                    <c:forEach items = "${servicesList}" var="service">
                        <tr>
                            <td><input type="checkbox" name="${service.variable}"></td>
                            <td><b>${service.serviceName}</b></td>
                            <td>${service.serviceDescription}</td>
                        </tr>
                    </c:forEach>

                    <tr style="text-align: center;">
                        <td colspan="3">
                            <button type="submit" style="text-align: center; padding: 5px;">Enroll</button>
                        </td>
                    </tr>
                </form>
            </table>
        </div>
        <div class="main__img--container">
            <img src="../../../pub/images/undraw_real_time_sync_re_nky7.svg" alt="multiple devices image" id="main__img">
        </div>
    </div>
</div>

<div class="services" id="login_services"></div>

<jsp:include page="../include/footer.jsp" />

</body>
</html>