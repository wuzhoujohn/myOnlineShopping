
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../sharedFlowPages/flows-header.jsp" %>

	<div class="row">
		<!-- column to display the personal detail -->
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
				<div class="panel-body">
					<!-- to display the personal details -->
					<div class="text-center">
						<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
						<h5>Email: ${registerModel.user.email}</h5>
						<h5>Contact Number: ${registerModel.user.contactNumber}</h5>
						<h5>Role: ${registerModel.user.role}</h5>
					</div>
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of personal details -->
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Personal</a>
				</div>
			</div>
		</div>

	<div class="col-sm-6">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Billing Address</h4>
			</div>
			<div class="panel-body">
				<!-- to display the communication address -->
				<div class="text-center">
						<h4>${registerModel.billing.addressLineOne}</h4>
						<h4>${registerModel.billing.addressLineTwo}</h4>
						<h4>${registerModel.billing.city} - ${registerModel.billing.province}- ${registerModel.billing.country}  </h4>
						<h4>${registerModel.billing.postalCode}</h4>
					</div>
			</div>
			<div class="panel-footer">
				<!-- anchor to move to the edit of the address -->
				<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Billing</a>
			</div>
		</div>
	</div>

</div>

<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
		<div class="text-center">
			<!-- anchor to move to the success page -->
			<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>
		</div>
	</div>

</div>
		

<%@include file="../sharedFlowPages/flows-footer.jsp" %>