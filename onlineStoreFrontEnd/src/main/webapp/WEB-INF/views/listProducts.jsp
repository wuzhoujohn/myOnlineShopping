<div class="container">

	<div class="row">

		<!-- would be display sidebar -->
		<div class="col-md-3">
			<%@include file="./sharedPages/sidebar.jsp"%>
		</div>

		<!-- would be display actual products -->
		<div class="col-md-9">
			<!--  this is the breadcrumb component -->
			<div class="row">
				<!-- to use all the available column -->
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true }">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts == true }">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<div class="container-fluid">
						<div class="table-responsive">
							<table id="productListTable"
								class="table table-striped table-borderd">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Quantity</th>
										<th></th>
									</tr>
								</thead>
								<!-- tbody will be filled by the json data -->
								<tfoot>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Quantity</th>
										<th></th>
									</tr>
								</tfoot>

							</table>
						</div>
					</div>

				</div>

			</div>
		</div>

	</div>
</div>