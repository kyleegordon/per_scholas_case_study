function collectData() {

    //verifies that a company name is entered
    if (document.signupForm.company_name.value ==""){
        alert("Please enter your company name");
        return false;
    } else {
        var companyName = document.getElementById('company_name').value;
    }

    //verifies that an email is entered and matches regex
    if (document.signupForm.email.value ==""){
        alert("Please enter your company email address");
        return false;
    } else {
        var email = document.getElementById('email').value;
        const regex = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$";
        const match = email.match(regex);

        if (!match) {
            alert("Please enter a valid email address");
            return false;
        }
    }

    //verifies that a password is entered
    if (document.signupForm.password.value ==""){
        alert("Please enter a password");
        return false;
    } else {
        var password = document.getElementById('password').value;
    }

    //verifies that an phone number is entered and matches regex
    if (document.signupForm.phone.value ==""){
        alert("Please enter a contact phone number");
        return false;
    } else {
        var phone = document.getElementById('phone').value;
        const regex = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
        const match = phone.match(regex);

        if (!match) {
            alert("Please enter a phone number in the correct format: 555-555-5555");
            return false;
        }
    }

    //verifies that a website url is entered
    if (document.signupForm.website.value ==""){
        alert("Please enter your company's website url'");
        return false;
    } else {
        var website = document.getElementById('website').value;
    }

    //verifies that the number of company employees is entered and is >= 1
    if (document.signupForm.employees.value == 0){
        alert("Please enter the number of employees at your company");
        return false;
    } else {
        var numEmployees = document.getElementById('employees').value;

        if (numEmployees < 1) {
            alert("Please enter the number of employees at your company (min 1)")
            return false;
        }
    }

    //verifies that an industry is entered
    if (document.signupForm.industry.value ==""){
        alert("Please enter your company's industry'");
        return false;
    } else {
        var industry = document.getElementById('industry').value;
    }

    //assigns yes or no to securityProfessionals based on radio input
    var securityProfessionals = document.querySelector('input[name="security_professionals"]:checked').value;

    //creates an array of selected data_types checkboxes
    var checkboxes = document.querySelectorAll('input[name="data_types"]:checked');
    var values = [];
    checkboxes.forEach((checkbox) => {
        values.push(checkbox.value);
    });

    //creates an object to hold the account data
    const accountData = {
        companyName: companyName,
        email: email,
        passsword: password,
        phone: phone,
        website: website,
        numEmployees: numEmployees,
        industry: industry,
        securityProfessionals: securityProfessionals,
        dataTypes: values
    };

    alert("Your account has been created:\n" + JSON.stringify(accountData, null, 4));
    return true;
}