function getAssessmentData() {

    //collects data from assessment form and saves in an object
    var formData = new FormData(document.querySelector("[name='assessmentForm']"));
    var qNum = 1;
    const assessmentData = {};
    for(var pair of formData.entries()){
        assessmentData["question" + qNum] = pair[1];
        qNum++;
    }

    assessmentData["score"] = calculateSecurityScore(assessmentData);

    alert("Here are your results:\n" + JSON.stringify(assessmentData, null, 4));
}




//calculates security score as a percentage out of 100
function calculateSecurityScore(obj) {
    var totalPoints = 0;

    for (const [key, value] of Object.entries(obj)) {
        totalPoints += Number(value);
    }

    var percentScore = Math.round((totalPoints / 90) * 100);

    return percentScore;
}