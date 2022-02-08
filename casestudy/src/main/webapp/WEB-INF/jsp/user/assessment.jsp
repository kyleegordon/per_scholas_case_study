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
                <form name="assessmentForm" method="POST" action="/user/assessmentSubmit">
                    <input type="hidden" name="email" value="${formBeanKey.email}">

                    <tr>
                        <td>
                            <label for="question1">Maintain up to date hardware inventory</label>
                        </td>
                        <td>
                            <label for="question2">Maintain up to date software inventory</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question1" name="question1" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question2" name="question2" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question3">All company devices are encrypted</label>
                        </td>
                        <td>
                            <label for="question4">All company devices are managed by the organization</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question3" name="question3" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question4" name="question4" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question5">Every employee has a unique account</label>
                        </td>
                        <td>
                            <label for="question6">Only authorized users are able to access company systems</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question5" name="question5" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question6" name="question6" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question7">Software is kept up to date</label>
                        </td>
                        <td>
                            <label for="question8">Centralized management systems log critical events</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question7" name="question7" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question8" name="question8" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question9">Multi-factor authentication is enabled to access email</label>
                        </td>
                        <td>
                            <label for="question10">Antivirus software is installed on all devices</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question9" name="question9" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question10" name="question10" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question11">Critical business data is backed up</label>
                        </td>
                        <td>
                            <label for="question12">Guests WIFI is separate from company WIFI</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question11" name="question11" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question12" name="question12" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question13">Networking equipment is kept up to date</label>
                        </td>
                        <td>
                            <label for="question14">New employees receive security awareness training</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question13" name="question13" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question14" name="question14" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question15">Contact list for service providers is kept up to date</label>
                        </td>
                        <td>
                            <label for="question16">Appropriate licenses have been purchased for software use</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question15" name="question15" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question16" name="question16" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="question17">Cyber security incident response has been planned in advance</label>
                        </td>
                        <td>
                            <label for="question18">Organization security measures are routinely tested</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="range" class="slider" id="question17" name="question17" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                        <td>
                            <input type="range" class="slider" id="question18" name="question18" min="1" max="5" step="1" value="0" oninput="this.nextElementSibling.value = this.value">
                            <output>1</output>
                        </td>
                    </tr>

                    <tr style="text-align: center;">
                        <td colspan="2">
                            <button type="submit" style="text-align: center; padding: 5px;">Submit</button>
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
<script src="../../../pub/js/assessment_form.js"></script>
</body>
</html