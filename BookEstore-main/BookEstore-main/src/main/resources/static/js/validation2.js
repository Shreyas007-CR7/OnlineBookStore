function validateForm() {
  var firstName = document.getElementById("firstName").value;
  var lastName = document.getElementById("lastName").value;
  var addrs = document.getElementById("addrs").value;
  var email = document.getElementById("email").value;
  var pass = document.getElementById("pass").value;

  var isValid = true;

  // Function to display error message
  function showErrorMessage(fieldId, message) {
    var errorElement = document.getElementById(fieldId + "-error");
    errorElement.textContent = message;
    isValid = false;
  }

  // Function to clear error message
  function clearErrorMessage(fieldId) {
    var errorElement = document.getElementById(fieldId + "-error");
    errorElement.textContent = "";
  }

  // Regular expressions for validation
  var nameRegex = /^[A-Za-z ]+$/;
  var emailRegex = /^\S+@\S+\.\S+$/;
  var passRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;

  // Validate first name
  if (firstName.trim() === "") {
    showErrorMessage("firstName", "First name is required.");
  } else if (!nameRegex.test(firstName)) {
    showErrorMessage("firstName", "Invalid first name. It must contain only letters.");
  } else {
    clearErrorMessage("firstName");
  }

  // Validate last name
  if (lastName.trim() === "") {
    showErrorMessage("lastName", "Last name is required.");
  } else if (!nameRegex.test(lastName)) {
    showErrorMessage("lastName", "Invalid last name. It must contain only letters.");
  } else {
    clearErrorMessage("lastName");
  }

  // Validate address
  if (addrs.trim() === "") {
    showErrorMessage("addrs", "Address is required.");
  } else {
    clearErrorMessage("addrs");
  }

  // Validate email
  if (email.trim() === "") {
    showErrorMessage("email", "Email is required.");
  } else if (!emailRegex.test(email)) {
    showErrorMessage("email", "Invalid email address.");
  } else {
    clearErrorMessage("email");
  }

  // Validate password
  if (pass.trim() === "") {
    showErrorMessage("pass", "Password is required.");
  } else if (!passRegex.test(pass)) {
    showErrorMessage("pass", "Invalid password. It must contain at least one number, one uppercase letter, one lowercase letter, and be at least 8 characters long.");
  } else {
    clearErrorMessage("pass");
  }

  return isValid;
}
