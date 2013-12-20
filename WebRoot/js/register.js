function addRow(myTable){
	var myTable = document.getElementById(myTable);
	myTable.insertRow(myTable.rows.length-1);
	myTable.rows[myTable.rows.length-2].innerHTML="<td><input type='text'></td>";
	}
	
	function deleteRow(myTable){
	var myTable = document.getElementById(myTable);
	myTable.deleteRow(myTable.rows.length-2);
	}
	
	function checkBlank(){
	var username = document.getElementById("search").rows[0].cells[1].childNodes[0].value;
	var password = document.getElementById("search").rows[1].cells[1].childNodes[0].value;
	var email = document.getElementById("search").rows[5].cells[1].childNodes[0].value;
	if((username!="")&&(password!="")&&(email!=""))
		collectData();
	else
		alert("username, password, email cannot be empty!");
	}
	
	function linkData(myTable){
	var data = myTable.rows[0].cells[0].childNodes[0].value;
	for(var i = 1; i < myTable.rows.length-1; i ++){
		data += "@";
		data += myTable.rows[i].cells[0].childNodes[0].value
	}
	return data;
	}
	
	function collectData(){
	var myTable = document.getElementById("frequentaddr");
	var frequentAddr = (linkData(myTable));
	myTable = document.getElementById("leisureaddr");
	var leisureAddr = (linkData(myTable));
	myTable = document.getElementById("workingaddr");
	var workingAddr = (linkData(myTable));
	myTable = document.getElementById("meetingaddr");
	var meetingAddr = (linkData(myTable));
	var form = document.getElementById("infoForm");
	form.action="RegisterServlet?frequentAddr="+frequentAddr+"&workingAddr="+workingAddr
		+"&meetingAddr="+meetingAddr+"&leisureAddr="+leisureAddr;
	form.submit();
	}