<%@include file="CommonHeader.jsp"%>
<br/><br/><br/><br/><br/>

<div class="table-responsive">
<form action="<c:url value='/updateSupplier'/>" method="post">
<table align="center" class="table table-condensed">
	<tr>
		<td colspan="2"><center>Update Supplier</center></td>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td><input type="text" name="suplId" value="${supplier.supplierId }"></td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="suplName" value="${supplier.supplierName }"></td>
	</tr>
	<tr>
		<td>Supplier Address</td>
		<td><textarea rows="5" cols="30" name="suplAddr" >${supplier.supplierAddress}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="reset" value="RESET">
			<input type="submit" value="Update Supplier">
		</td>
	</tr>
</table>
</form>
</div>

</body>
</html>