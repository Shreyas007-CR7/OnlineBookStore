function validateLoginForm() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('pass').value;
    var emailError = document.getElementById('email-error');
    var passError = document.getElementById('pass-error');

    // Reset any previous error messages
    emailError.textContent = '';
    passError.textContent = '';

    if (email.trim() === '' && password.trim() === '') {
        emailError.textContent = 'Please enter your email.';
        passError.textContent = 'Please enter your password.';
        return false;
    } else if (email.trim() === '') {
        emailError.textContent = 'Please enter your email.';
        return false;
    } else if (password.trim() === '') {
        passError.textContent = 'Please enter your password.';
        return false;
    }
 var formData = new FormData();
    formData.append('email', email);
    formData.append('pass', password);

    fetch('/loginhandler', {
        method: 'POST',
        body: formData,
    })
    .then(response => {
        if (response.status === 200) {
            // Valid login - redirect to the home page
            window.location.href = '/home';
        } else if (response.status === 401) {
            // Invalid login - display the error message
            response.text().then(function (data) {
                passError.textContent = data;
            });
        }
    });

    return false;
}
