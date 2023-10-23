function validateForm() {
  // Reset error messages
  resetErrorMessages();

  
  const name = document.getElementById("name").value;
  const price = document.getElementById("price").value;
  const quantity = document.getElementById("quantity").value;
  

  let isValid = true;

  // Regular expressions for validation
  const priceRegex = /^\d+(\.\d{1,2})?$/; // Allows integers or decimals with up to two decimal places

 

  if (name.trim() === "") {
    displayErrorMessage("name-error", "Book Name is required.");
    isValid = false;
  }

 

  if (!price.match(priceRegex)) {
    displayErrorMessage("price-error", "Price must be a valid number.");
    isValid = false;
  }

  if (quantity.trim() === "" || isNaN(quantity)) {
    displayErrorMessage("quantity-error", "Quantity must be a valid number.");
    isValid = false;
  }
   if (isValid) {
    // If all fields are valid, you can show the success message here.
    alert("Book Added successfully");
  }

  return isValid;
}

function resetErrorMessages() {
  const errorElements = document.querySelectorAll(".error-message");
  errorElements.forEach((element) => (element.textContent = ""));
}

function displayErrorMessage(id, message) {
  const errorElement = document.getElementById(id);
  errorElement.textContent = message;
}
