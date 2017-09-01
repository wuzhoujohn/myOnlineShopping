
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../sharedFlowPages/flows-header.jsp"%>


<div class="container">
	<div class="row text-center">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Address</h4>
				</div>
				<div class="panel-body">
					<sf:form method="POST" class="form-horizontal" id="billingForm"
						modelAttribute="billing">
						<div class="form-group">
							<label class="control-label col-md-4">Address Line One</label>
							<div class="col-md-8">
								<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
								<sf:input type="text" path="addressLineOne" class="form-control"
									placeholder="Enter Address Line one" />
								<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Address Line Two</label>
							<div class="col-md-8">
								<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
								<sf:input type="text" path="addressLineTwo" class="form-control"
									placeholder="Enter Address Line Two" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">City</label>
							<div class="col-md-8">
								<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
								<sf:input type="text" path="city" class="form-control"
									placeholder="Enter City" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Province</label>
							<div class="col-md-8">
								<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
								<sf:input type="text" path="province" class="form-control"
									placeholder="Enter Province" />
								<sf:errors path="province" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Country</label>
							<div class="col-md-8">
								<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
								<sf:input type="text" path="country" class="form-control"
									placeholder="Enter Country" />
								<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Postal Code</label>
							<div class="col-md-8">
								<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
								<sf:input type="text" path="postalCode" class="form-control"
									placeholder="XXX XXX" />
								<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-8">
							<!-- submit button for moving to the personal -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_personal">
									<span clas="glyphicon glyphicon-chevron-left"></span>Previous - Billing 
								</button>
								<!-- submit button for moving to confirm -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirm">
									Next - Confirm <span clas="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>

					</sf:form>
				</div>
			</div>

		</div>

	</div>
</div>

<%@include file="../sharedFlowPages/flows-footer.jsp"%>