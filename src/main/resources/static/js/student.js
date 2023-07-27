function edit(student){
	document.getElementById("field-id").value = student.id;
	document.getElementById("field-firstname").value = student.firstName;
	document.getElementById("field-lastname").value = student.lastName;
	document.getElementById("field-address").value = student.address;
}

async function deleteById(id){
	var url = "http://localhost:8080/student/delete/" + id;
	console.log("url: " + url);
	await fetch(url);
	location.reload();
}