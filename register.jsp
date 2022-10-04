<style>
div {

	border: 5px solid yellow;
	background-color:grey;
	padding: 50px;
	width: 30%;
	margin-left: 400px;
	margin-top: 100px;
}

input{

padding:12px;
}
input[type="submit"]
{
padding:15px 20px;
color:red;
Background-color:yellow;
border-radius:10%;

}

</style>

<script>

function change(input){
	
	input.style.color="white";
	input.style.background="black";

}
</script>

<form>
<div>
<input type="text" name="username" placeholder="Enter username"  onfocus="change(this)" required><br><br>
	
	<input type="password" name="password"  placeholder="Enter password" onfocus="change(this)"><br><br>
	
	<input type="text" name="mobilenumber" placeholder="Enter mobilenumber" onfocus="change(this)"><br><br>
	
	<input type=email name="emailid" placeholder="Enter emailId" onfocus="change(this)"><br><br>
	
	<input type=date name="dateofbirth" placeholder="Enter DateOfBirth" onfocus="change(this)"><br><br>
	
	<input type="submit" value="register" formaction="register" formmethod="post" id="b1">
	
	</div>
</form>

