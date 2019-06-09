function deleteEntries() {
		document.getElementById("groupName").value = "";
		document.getElementById("groupDescription").value = "";
		document.getElementById("groupParticipants").value = "";
		document.getElementById("paymentName").value = "";
		document.getElementById("groupParticipants").value = "";
		document.getElementById("groupParticipants").value = "";
	}


function searchUser() {

}

function check_password() {
	if (document.getElementById('password1').value == document
			.getElementById('password2').value) {
		document.getElementById('submit').disabled = false;
	} else {
		document.getElementById('submit').disabled = true;
	}
}