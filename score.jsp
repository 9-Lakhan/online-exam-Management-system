
welcome ${username}

<style>
td
{
	color:blue;
	
}

th
{
	color:red;
}
body{

background-color:pink;
}

th,td{
padding:3px;
text-align:center;
}
table
{
	margin-left : 300px;
}
table,th,td{
border:2px solid black;

}
h1
{
	color:green;
}


div{

text-align:center;
}
img{
border-radius:70%;
}
</style>

<script>

var images=["Image1","Image2","Image3","Image4"];

var currentIndex=-1;

function changeImage(){
	
	var img=document.getElementById("i1");
	
	currentIndex++;
	
	if(currentIndex==images.length){
		currentIndex=0;
	}
	
	img.src="images/"+images[currentIndex]+".jpg";
	
}
	setInterval(changeImage,3000);

</script>


<from>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
${allData}
<br><br>
	
<h1>your score is ${finalScore} </h1>


<table>
<tr>
<th>qno</th>
<th>question</th>
<th>submittedAnswer</th>
<th>correctAnswer</th>
</tr>

<c:forEach var="answer" items="${allData}">

<tr>
<td>${answer.qno}</td>
<td>${answer.question}</td>
<td>${answer.submittedAnswer}</td>
<td>${answer.correctAnswer}</td>
</tr>

</c:forEach>


</table>
<br><br>
<h1>Want to attempt exam again?</h1><br>
<a href="loginPage" style="text-decoration:none;font-size:30px;">Go To Login </a>

<br>
<div>
	<img src="images/Image4.jpg" width=300 height=300 id="i1">
</div>
</body>
</from>