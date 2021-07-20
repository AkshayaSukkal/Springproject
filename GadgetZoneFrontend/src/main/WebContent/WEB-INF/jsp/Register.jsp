<%@include file="CommonHeader.jsp"%>
<br/><br/><br/><br/><br/>

<form:form action="registerUser" modelAttribute="customer" method="post" align="center">
	
	<table align="center">
	<style>
	body, html{
     height: 100%;
     background-repeat: no-repeat;
 	background-color: #DEB887;
 	font-family: 'Oxygen', sans-serif;
    font-size: 12px;
}
.main{
 	margin-top: 70px;
}
h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}
hr{
	width: 10%;
	color: #000000;
}
.form-group{
	margin-bottom: 15px;
}
label{
	margin-bottom: 14px;
}
input,
input::-webkit-input-placeholder {
    font-size: 9px;
    padding-top: 3px;
}
.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;
}
.login-button{
	margin-top: 3px;
}
.login-register{
	font-size: 8px;
	text-align: center;
}	
	</style>
	
	<table align="center">
	
		<tr>
			<td>Username</td>
			<td><form:input path="username"/></td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td><form:input path="customerName"/></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><form:input path="gender"/></td>
		</tr>
		<tr>
			<td>Contact Number</td>
			<td><form:input path="contactNumber"/></td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td><form:input path="emailId"/></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:textarea path="address"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td>Repeat Password</td>
			<td><form:password path="rPassword"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="reset" value="RESET"/>
			<input type="submit" value="SIGN UP" class="btn btn-success"/>
			</td>
		</tr>
	</table>
	
</form:form>


</body>
</html>