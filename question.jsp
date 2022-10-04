
welcome ${username}
<br><br>

<link href="/css/common.css" rel="stylesheet">

<style>

#errorMessage{
        color:red;
		font-size: 30px;
	font-style: italic;
		margin-left:500px;
}
body{
background-color:grey;
}
textarea{
border:none;
background-color:black;
color:white;
font-size:30px;
padding-top:20px;
box-sizing:border-box; 
}
div{
margin-left:300;
}
span{
color:black;
font-size:20px;
font-style:italic;
}
/*
.btn{

color:yellow;
background-color:brown;
padding:15px 30px;
}
*/

.b1
	{
			background-color: grey;
			padding :10px;
			font-size:15px;	  
	}
</style>


<script>

var xmlhttp;
function sendData()
{
 xmlhttp=new XMLHttpRequest();

var qno=document.questionForm.qno.value;
var question=document.questionForm.question.value;
var submittedAnswer=document.questionForm.option.value;

var data ="qno="+qno+"&question="+question+"&submittedAnswer="+submittedAnswer;
alert(data);
xmlhttp.open("get","saveAnswer?"+data);

xmlhttp.send();
}

function showRemainingTime(){
	xmlhttp= new XMLHttpRequest();
	
	xmlhttp.onload=showtime;
	
	xmlhttp.open("get","showRemainingTime",true);
	
	xmlhttp.send();
}

function showtime(){
	
	var totalSeconds=xmlhttp.responseText;
	
	var min=Math.floor(totalSeconds/60).toString().padStart(2,'0');
	var sec=(totalSeconds-min*60).toString().padStart(2,'0');
	
	document.getElementById("show").value=min+":"+sec;
	
	if(xmlhttp.responseText=='0'){
		alert("Time up !!")
		location.href="endexam";
	}

}

function changeColor(){
	
	var allAnswers=document.getElementsByTagName("span");
	var allRadioButtons=document.getElementsByName("option");
	var previousAnswer=document.questionForm.previousAnswer.value;
	
	for(var i=0;i<allAnswers.length;i++){
		if(allAnswers[i].innerText==previousAnswer){
			allAnswers[i].style.color='red';
			allRadioButtons[i].checked=true;
			
		}
	}
}

setInterval(showRemainingTime,1000);
</script>

<body onload="changeColor()">
<div>
<form name="questionForm">


remainingtime : <input style="border:none" type="text" id="show" value=" " class="b1"><br><br>

    <input  style="border:none" type="text" name="qno" value="${questions.qno}" class="b1"><br><br>

 <textarea  rows=3 cols=50 name="question" readonly> ${questions.question} </textarea><br><br>
		
	<input  type="radio" name="option" value="${questions.option1}" onclick="sendData()"> <span> ${questions.option1} </span><br><br>
	
	<input  type="radio" name="option" value="${questions.option2}" onclick="sendData()">  <span> ${questions.option2} </span> <br><br>
		
	<input  type="radio" name="option" value="${questions.option3}" onclick="sendData()"> <span> ${questions.option3} </span> <br><br>
	
	<input  type="radio" name="option" value="${questions.option4}" onclick="sendData()"> <span> ${questions.option4} </span> <br><br>
		
	<input  type="submit" value="previous" formaction="previous" class="btn">
	<input  type="submit" value="next" formaction="next" class="btn">
	<input  type="submit" value="end exam" formaction="endexam" class="btn">
	
	<br><br>
	<input style="border:none;display:none" type="text" name="previousAnswer" value="${previousAnswer}">
	
</form>
</div>
</body>
<p1 id="errorMessage" >${message}</p1>