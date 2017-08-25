<div class="container">

	<div class="row">
	
		<!-- would be display sidebar -->
		<div class="col-md-3">
			<%@include file="./sharedPages/sidebar.jsp" %>
		</div>
		
		<!-- would be display actual products -->
		<div class="col-md-9">
			<!--  this is the breadcrumb component -->
			<div class="row">
				<!-- to use all the available column -->
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true }">
					
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts == true }">				
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active"> ${category.name} </li>
						</ol>
					</c:if>
				</div>
			</div>
		</div>
	
	</div>
</div>