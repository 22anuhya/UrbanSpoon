function signUpvalidation() {
var name = document.form.name.value;
var uname = document.form.uname.value;
var email = document.form.email.value;
var password = document.form.password.value;
var rpassword = document.form.repeatPassword.value;
var atposition=email.indexOf("@");  
var dotposition=email.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length || email.length<2){  
  alert("Please enter a valid e-mail address ");  
  return false;  
  }  
  if (name.length<=0) {
    alert("Enter valid First name");
    return false;
  }
  if (uname.length<=0) {
    alert("Enter valid User name");
    return false;
  }
  if (password.length<8) {
    alert("Password length must be greater than 8");
    return false;
  }
  if(password!=rpassword){
      alert("Passwords did not match");
      return false;
  }
}