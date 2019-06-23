function addUser() {
	var left, right, newUser, newPercent;
	left = document.getElementById("leftModal");
	right = document.getElementById("rightModal");
	
	var userNum = left.childNodes.length - 1;
	
	newUser = document.createElement("input");
	newUser.setAttribute("id", userNum);
	newUser.setAttribute("name", "P" + userNum);
	newUser.setAttribute("class", "mt-2 form-control autocomplete");
	newUser.setAttribute("type", "text");
	newUser.setAttribute("placeholder", "Name");
	
	newPercent = document.createElement("input");
	newPercent.setAttribute("id", userNum);
	newPercent.setAttribute("name", "P" + userNum +"P");
	newPercent.setAttribute("class", "mt-2 form-control");
	newPercent.setAttribute("placeholder", "Beteiligung in %");
	newUser.setAttribute("type", "text");
	
	
	//TODO add actionlistener to newUser
	
	left.appendChild(newUser);
	right.appendChild(newPercent);
}

function searchUserForGroup(inp, search) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			autocompleteMultiple(inp, JSON.parse(this.responseText));
		}
	};
	xhttp.open("POST", "searchUser", true);
	xhttp.setRequestHeader("searchQuery", search);
	xhttp.send();
}
function autocompleteMultiple(inp, arr) {
	var currentFocus;
	inp.addEventListener("input", function(e) {
		var a, b, i, val = this.value;
		var splitChar = ", ";
		var lastString = "";
		if (~val.indexOf(splitChar)) {
			var newArr = val.split(splitChar);
			val = newArr[newArr.length - 1];
			for (var j = 0; j < newArr.length - 1; j++) {
				lastString += newArr[j] + ", ";
			}
		}
		closeAllLists();
		if (!val) {
			return false;
		}
		currentFocus = -1;
		a = document.createElement("DIV");
		a.setAttribute("id", this.id + "autocomplete-list");
		a.setAttribute("class", "autocomplete-items");
		this.parentNode.appendChild(a);
		for (i = 0; i < arr.length; i++) {
			if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
				b = document.createElement("DIV");
				b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
				b.innerHTML += arr[i].substr(val.length);
				b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
				b.addEventListener("click", function(e) {
					inp.value = lastString + this.getElementsByTagName("input")[0].value + ", ";
					closeAllLists();
				});
				a.appendChild(b);
			}
		}
	});
	inp.addEventListener("keydown", function(e) {
		var x = document.getElementById(this.id + "autocomplete-list");
		if (x)
			x = x.getElementsByTagName("div");
		if (e.keyCode == 40) {
			currentFocus++;
			addActive(x);
		} else if (e.keyCode == 38) {
			currentFocus--;
			addActive(x);
		} else if (e.keyCode == 13) {
			e.preventDefault();
			if (currentFocus > -1) {
				if (x)
					x[currentFocus].click();
			}
		}
	});
	function addActive(x) {
		if (!x)
			return false;
		removeActive(x);
		if (currentFocus >= x.length)
			currentFocus = 0;
		if (currentFocus < 0)
			currentFocus = (x.length - 1);
		x[currentFocus].classList.add("autocomplete-active");
	}
	function removeActive(x) {
		for (var i = 0; i < x.length; i++) {
			x[i].classList.remove("autocomplete-active");
		}
	}
	function closeAllLists(elmnt) {
		var x = document.getElementsByClassName("autocomplete-items");
		for (var i = 0; i < x.length; i++) {
			if (elmnt != x[i] && elmnt != inp) {
				x[i].parentNode.removeChild(x[i]);
			}
		}
	}
	document.addEventListener("click", function(e) {
		closeAllLists(e.target);
	});
}

function searchUserForPayment(inp, search) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			autocompleteSingle(inp, JSON.parse(this.responseText));
		}
	};
	xhttp.open("POST", "searchUser", true);
	xhttp.setRequestHeader("searchQuery", search);
	xhttp.send();
}
function autocompleteSingle(inp, arr) {
	var currentFocus;
	inp.addEventListener("input", function(e) {
		var a, b, i, val = this.value;
		closeAllLists();
		if (!val) {
			return false;
		}
		currentFocus = -1;
		a = document.createElement("DIV");
		a.setAttribute("id", this.id + "autocomplete-list");
		a.setAttribute("class", "autocomplete-items");
		this.parentNode.appendChild(a);
		for (i = 0; i < arr.length; i++) {
			if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
				b = document.createElement("DIV");
				b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
				b.innerHTML += arr[i].substr(val.length);
				b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
				b.addEventListener("click", function(e) {
					inp.value = this.getElementsByTagName("input")[0].value;
					closeAllLists();
				});
				a.appendChild(b);
			}
		}
	});
	inp.addEventListener("keydown", function(e) {
		var x = document.getElementById(this.id + "autocomplete-list");
		if (x)
			x = x.getElementsByTagName("div");
		if (e.keyCode == 40) {
			currentFocus++;
			addActive(x);
		} else if (e.keyCode == 38) {
			currentFocus--;
			addActive(x);
		} else if (e.keyCode == 13) {
			e.preventDefault();
			if (currentFocus > -1) {
				if (x)
					x[currentFocus].click();
			}
		}
	});
	function addActive(x) {
		if (!x)
			return false;
		removeActive(x);
		if (currentFocus >= x.length)
			currentFocus = 0;
		if (currentFocus < 0)
			currentFocus = (x.length - 1);
		x[currentFocus].classList.add("autocomplete-active");
	}
	function removeActive(x) {
		for (var i = 0; i < x.length; i++) {
			x[i].classList.remove("autocomplete-active");
		}
	}
	function closeAllLists(elmnt) {
		var x = document.getElementsByClassName("autocomplete-items");
		for (var i = 0; i < x.length; i++) {
			if (elmnt != x[i] && elmnt != inp) {
				x[i].parentNode.removeChild(x[i]);
			}
		}
	}
	document.addEventListener("click", function(e) {
		closeAllLists(e.target);
	});
}

function clearGroupModal() {
	document.getElementById("groupName").value = "";
	document.getElementById("groupDescription").value = "";
	document.getElementById("groupParticipants").value = "";
}

function clearPaymentModal() {
	document.getElementById("paymentName").value = "";
	document.getElementById("paymentdescription").value = "";
	
	//TODO get all childnodes & delete them
	document.getElementById("P1").value = "";
	document.getElementById("P1P").value = "";
}

var passwordLength = 1;

function validateRegistration() {
	var email = document.getElementById("email").value;
	var password1 = document.getElementById("password1").value;
	var password2 = document.getElementById("password2").value;
	var fname = document.getElementById("fname").value;
	var lname = document.getElementById("lname").value;
	var uname = document.getElementById("uname").value;

	if (validateEmail(email) && validatePasswords(password1, password2) && validateNames(fname, lname, uname)) {
		document.getElementById('submit').disabled = false;
	} else {
		document.getElementById('submit').disabled = true;
	}
}

function validateNames(fname, lname, uname) {
	return (fname.length > 0 && lname.length > 0 && uname.length > 0) ? true : false;
}

function validatePasswords(password1, password2) {
	return (((password1.length <= passwordLength) && (password2.length <= passwordLength)) || (password1 != password2)) ? false : true;
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}