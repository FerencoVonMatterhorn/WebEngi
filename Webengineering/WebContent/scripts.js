function clearGroupModal() {
	document.getElementById("groupName").value = "";
	document.getElementById("groupDescription").value = "";
	document.getElementById("groupParticipants").value = "";
}

function clearPaymentModal() {
	//document.getElementById("").value = "";
	//document.getElementById("").value = "";
	//document.getElementById("").value = "";
}

var passwordLength = 1;

function validateRegistration() {
	var email = document.getElementById("email").value;
	var password1 = document.getElementById("password1").value;
	var password2 = document.getElementById("password2").value;
	var fname = document.getElementById("fname").value;
	var lname = document.getElementById("lname").value;
	var uname = document.getElementById("uname").value;

	if (validateEmail(email) && validatePasswords(password1, password2)
			&& validateNames(fname, lname, uname)) {
		document.getElementById('submit').disabled = false;
	} else {
		document.getElementById('submit').disabled = true;
	}
}

function validateNames(fname, lname, uname) {
	return (fname.length > 0 && lname.length > 0 && uname.length > 0) ? true
			: false;
}

function validatePasswords(password1, password2) {
	return (((password1.length <= passwordLength) && (password2.length <= passwordLength)) || (password1 != password2)) ? false
			: true;
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}