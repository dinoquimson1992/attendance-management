function edit(student){
	document.getElementById("field-id").value = student.id;
	document.getElementById("field-firstname").value = student.firstName;
	document.getElementById("field-lastname").value = student.lastName;
	document.getElementById("field-address").value = student.address;
}

async function deleteById(id){
	var proceed = confirm("Are you sure you want to delete this student?");
	if(proceed){
		var url = "http://localhost:8080/students/delete/" + id;
		await fetch(url);
		location.reload();
	}
}