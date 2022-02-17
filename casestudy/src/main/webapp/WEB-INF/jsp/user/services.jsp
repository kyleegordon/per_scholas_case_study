<jsp:include page="../include/header.jsp" />

<div class="main">
    <div class="main__container" id="assessment_container" style="grid-template-columns: 1fr; justify-content: center;">
        <div class="main__content" style="margin: 0 auto;">
            <table id="assessment_table">
                <caption>
                    <h3 style="color:#fff; margin-bottom: 20px; font-size: 2rem;">Security Assessment</h3>
                    Please use the sliding scale to assess your current security practices:<br>
                    1 = We don't do this <br>
                    5 = The process is automated
                </caption>
                <form name="servicesForm" method="POST" action="/user/servicesSubmit">

                    <tr>
                        <td>

                        </td>
                        <td>

                        </td>
                    </tr>

                    <tr style="text-align: center;">
                        <td colspan="2">
                            <button type="submit" style="text-align: center; padding: 5px;">Enroll</button>
                        </td>
                    </tr>
                </form>
            </table>
        </div>
        <!-- <div class="main__img--container">
            <img src="images/undraw_hacker_mind_-6-y85.svg" alt="cyber professional image" id="main__img">
        </div> -->
    </div>
</div>

<div class="services" id="assessment_services"></div>


<jsp:include page="../include/footer.jsp" />
</body>
</html>