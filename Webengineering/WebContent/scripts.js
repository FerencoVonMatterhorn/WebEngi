function deleteEntries() {
	document.getElementById("groupName").value = "";
	document.getElementById("groupDescription").value = "";
	document.getElementById("groupParticipants").value = "";
	document.getElementById("paymentName").value = "";
	document.getElementById("groupParticipants").value = "";
	document.getElementById("groupParticipants").value = "";
}

function validateRegistration() {
	var email = document.getElementById("email").value;
	var password1 = document.getElementById("password1").value;
	var password2 = document.getElementById("password2").value;
	var fname = document.getElementById("fname").value;
	var lname = document.getElementById("lname").value;
	var uname = document.getElementById("uname").value;

	if (validateEmail(email) && validatePassword(password1, password2)
			&& validateNames(fname, lname, uname)) {
		document.getElementById('submit').disabled = false;
	} else {
		document.getElementById('submit').disabled = true;
	}
}

function validateNames(fname, lname, uname) {
	if (fname.length > 0 && lname.length > 0 && uname.length > 0) {
		return true;
	}
	return false;
}

function validatePassword(password1, password2) {
	if (password1 != password2) {
		return false
	}
	return true;
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}