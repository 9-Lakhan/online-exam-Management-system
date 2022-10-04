<span id="b1">${message}</span><br><br>



<style>
#b1{
color:black;
}
body{
background-color:grey;
background-image: url('images/1.jpg');
}
input
{
	border:2px solid black;
	border-radius:10px;
	padding:20px;
	background-color:yellow;
}
select{
border:2px solid black;
	border-radius:10px;
	padding:20px;
	background-color:yellow;
}
input:hover {
  background-color: orange;
}


</style>

<script>

var xmlhttp;
function getAllSubjects()
{
	
	xmlhttp=new XMLHttpRequest();
	
	xmlhttp.onload=showAllSubjects;
	
	xmlhttp.open("get","getAllSubjects",true);
	xmlhttp.send();
	
}

function showAllSubjects(){
	
	var allSubject=JSON.parse(xmlhttp.responseText);
	
	alert(allSubject)
	
	var combobox=document.getElementById("selectedSubject")
	
	for(var i=0;i<allSubject.length;i++){
		
		var option=document.createElement("option");
		option.text=allSubject[i]
		option.value=allSubject[i]
		combobox.add(option);
	}	
}

</script>


<body onload="getAllSubjects()">
<form>
<div>
		<select name="selectedSubject" id="selectedSubject">
		
		</select>
		&nbsp;&nbsp;&nbsp;
		<input type=submit value="startExam" formaction="startExam">
		</div>
	</form>
	</body>
	