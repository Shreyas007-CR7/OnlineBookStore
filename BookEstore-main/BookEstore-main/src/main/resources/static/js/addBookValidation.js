function validateForm() {
  // Reset error messages
  resetErrorMessages();

  const barcode = document.getElementById("barcode").value;
  const name = document.getElementById("name").value;
  const author = document.getElementById("author").value;
  const price = document.getElementById("price").value;
  const quantity = document.getElementById("quantity").value;
  const image = document.getElementById("image").value;
  const bookdesc = document.getElementById("bookdesc").value;

  let isValid = true;

  // Regular expressions for validation
  const priceRegex = /^\d+(\.\d{1,2})?$/; // Allows integers or decimals with up to two decimal places

  if (barcode.trim() === "") {
    displayErrorMessage("barcode-error", "Barcode is required.");
    isValid = false;
  }

  if (name.trim() === "") {
    displayErrorMessage("name-error", "Book Name is required.");
    isValid = false;
  }

  if (author.trim() === "") {
    displayErrorMessage("author-error", "Author is required.");
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

  if (image.trim() === "") {
    displayErrorMessage("imageUrl-error", "Image URL is required.");
    isValid = false;
  }

  if (bookdesc.trim() === "") {
    displayErrorMessage("description-error", "Book Description is required.");
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
