



<style>
body {
	background-color: grey;
}

div {
	background-color: white;
	border: 5px solid yellow;
	padding: 50px;
	width: 30%;
	margin-left: 400px;
	margin-top: 100px;
}
input
{
	border:2px solid black;
	border-radius:10px;
	padding:20px;
}

#b1
{
			padding:15px 30px;
			background-color: yellow;
			color:black;
}

a:link
{
	border:2px solid black;
	border-radius:10px;
   background-color: yellow;
  color: black;
  padding: 14px 25px;
  
  text-decoration: none;
  
 
}
a:hover {
  background-color: red;
  
}
#errorMessage{

color:yellow;
}

</style>


 ${message}
<body>
<form>
	<div>

		<input type="text" name="username" placeholder="enter username"><br><br>
		
		<input type="password" name="password" placeholder="enter password" ><br><br>
		 
		<input type="submit" value="login" formmethod="post" formaction="login"id="b1" > 
		
	
		
	<a href="showRegisterPage">Sign up</a>

	</div>

</form>
<span id="errorMessage">${errorMessage}</span>
</body>
