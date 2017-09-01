
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../sharedFlowPages/flows-header.jsp" %>

<div class="wrapper">

		<div class="container">
			<div class="row text-center">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4>Sign Up - Personal</h4>
						</div>
						<div class="panel-body">
							<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
								<div class="form-group">
									<label class="control-label col-md-4">First Name</label>
									<div class="col-md-8">
									<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
										<sf:input type="text" path="firstName" class="form-control" placeholder="First Name" />
										<sf:errors path="firstName" cssClass="help-block" element="em" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4">Last Name</label>
									<div class="col-md-8">
									<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
										<sf:input type="text" path="lastName" class="form-control" placeholder="Last Name" />
										<sf:errors path="lastName" cssClass="help-block" element="em" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4">Email</label>
									<div class="col-md-8">
									<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
										<sf:input type="text" path="email" class="form-control" placeholder="Email Address" />
										<sf:errors path="email" cssClass="help-block" element="em" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4">Contact Number</label>
									<div class="col-md-8">
									<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
										<sf:input type="text" path="contactNumber" class="form-control" placeholder="Contact Number" />
										<sf:errors path="contactNumber" cssClass="help-block" element="em" />
									</div>
								</div>
							 	<div class="form-group">
									<label class="control-label col-md-4">Password</label>
									<div class="col-md-8">
									<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
										<sf:input type="password" path="password" class="form-control" placeholder="Password" />
										<sf:errors path="password" cssClass="help-block" element="em" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4">Confirm Password</label>
									<div class="col-md-8">
									<!--  the path is associated with the filed inside the user java class. we would also need to create
									a variable inside signup-flow.xml file -->
										<sf:input type="password" path="confirmPassword" class="form-control" placeholder="Re-enter Password" />
										<sf:errors path="password" cssClass="help-block" element="em" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4">Select Role</label>
									<div class="col-md-8">
										<label class="radio-inline">
											<sf:radiobutton path="role" value="USER" checked="checked" /> User
										</label>
										<label class="radio-inline">
											<sf:radiobutton path="role" value="SUPPLIER"/> Supplier
										</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<button type="submit" class="btn btn-primary" name="_eventId_billing">
											Next - Billing <span clas="glyphicon glyphicon-chevron-right"></span>
										</button>
									</div>
								</div>
							 
							 </sf:form>
						</div>
					</div>
				
				</div>
			
			</div>
		</div>
	</div>

<%@include file="../sharedFlowPages/flows-footer.jsp" %>