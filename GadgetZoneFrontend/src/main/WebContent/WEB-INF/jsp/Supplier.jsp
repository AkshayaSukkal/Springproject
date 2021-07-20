<%@include file="CommonHeader.jsp"%>
<br/><br/><br/><br/><br/>
<body>
<form action="<c:url value='/insertSupplier'/>" method="post">
<table align="center" class="table table-condensed">
	<tr>
		<td colspan="2"><center>Supplier</center></td>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td><input type="text" name="suplId"></td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="suplName"></td>
	</tr>
	<tr>
		<td>Supplier Address</td>
		<td><textarea rows="5" cols="30" name="suplAddr"></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
			<input type="submit" value="Insert Supplier" class="btn btn-success">
		</center>
		</td>
	</tr>
</table>
</form>

<table align="center" cellspacing="3" cellpadding="3" class="table table-condensed">
	<tr bgcolor="LightGray">
		<td>Supplier Id</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
		<tr bgcolor="Cornsilk">
			<td>${supplier.supplierId}</td>
			<td>${supplier.supplierName}</td>
			<td>${supplier.supplierAddress}</td>
			<td>
				<a href="<c:url value='/deleteSupplier/${supplier.supplierId}'></c:url>">Delete</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/editSupplier/${supplier.supplierId}'></c:url>">Edit</a>
	</c:forEach>
</table>

</body>
</html>