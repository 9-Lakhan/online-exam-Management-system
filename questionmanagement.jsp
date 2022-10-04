
<style>
div {

	border: 5px solid yellow;
	padding: 50px;
	width: 40%;
	margin-left: 100px;
	margin-top: 80px;
	text-align: center;
	background-color:orange;
}
input{

padding:5px;
}
input[type="submit"]
{

color:yellow;
background-color:red;

}


</style>

<form>
<div>
<input type="text" name=qno placeholder="enter qno" value="${questions.qno}"><br><br>
<textarea  rows=2 cols=30 name="question" placeholder="enter question" value="${questions.question}" ></textarea><br><br>

<input type="text" name=option1 placeholder="enter option1" value="${questions.option1}"><br><br>

<input type="text" name=option2 placeholder="enter option2" value="${questions.option2}"><br><br>

<input type="text" name=option3 placeholder="enter option3" value="${questions.option3}"><br><br>

<input type="text" name=option4 placeholder="enter option4" value="${questions.option4}"><br><br>

<input type="text" name=answer placeholder="enter answer" value="${questions.answer}"><br><br>

<input type="text" name=subject placeholder="enter subject" value="${questions.subject}"><br><br>

<input type="submit" value="addQuestion" formaction="addQuestion">
<input type="submit" value="viewQuestion" formaction="viewQuestion">
<input type="submit" value="updateQuestion" formaction="updateQuestion">
<input type="submit" value="deleteQuestion" formaction="deleteQuestion">
</div>
</form>
${msg} 
${msgg}
