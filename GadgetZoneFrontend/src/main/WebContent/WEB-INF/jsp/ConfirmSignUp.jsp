<%@include file="CommonHeader.jsp"%>
<br/><br/><br/><br/><br/>
<table align="center" class="table">
	<tr bgcolor="pink">
		<td colspan="2">
			Confirm Your Details
		</td>
	</tr>
	<tr>	
		<td>Username</td>
		<td>${customer.username}</td>
	</tr>
	<tr>
		<td>Customer Name</td>
		<td>${customer.customerName}</td>
	</tr>
	<tr>
		<td>Gender</td>
		<td>${customer.gender}</td>
	</tr>
	<tr>
		<td>Contact Number</td>
		<td>${customer.contactNumber}</td>
	</tr>
	<tr>
		<td>Email Id</td>
		<td>${customer.emailId}</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>${customer.address}</td>
	</tr>
	<tr>
		<td>Password</td>
		<td>********</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="Login">Confirm and SignIn</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="Register">Edit Details</a>
		</td>
	</tr>
		
</table>

</body>
</html>