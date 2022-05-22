function loginValidation() {
var uname = document.form.uname.value;
var password = document.form.password.value;
  if (uname.length<=0) {
    alert("Enter valid User name");
    return false;
  }
  if (password.length<8) {
    alert("Password length must be greater than 8");
    return false;
  }
  return true;
}