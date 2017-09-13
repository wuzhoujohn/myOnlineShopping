<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- here, in the servlet-context.xml you have specified the loaction of static resources, so here we use the mapping to -->
<!-- load the available files in that folder -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="pictures" value="/resources/pictures" />

<!-- use the set tag from jstl lib to set a variable contextRoot with value pageContext.request.contextPath -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- get the title property from the model -->
<title>Online Shopping Store - ${title}</title>
<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- bootstrap theme css file -->
<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">

<!--  bootstrap datatable css file -->
<link href="${css}/dataTables.bootstrap.min.css" rel="stylesheet">

</head>

<body>

	<!-- include the Navigation file -->
	<%@include file="./sharedPages/navibar.jsp"%>

	<!-- here comes the home page main content -->
	<!-- assure that the homeContent will be displayed only if user clicks home button -->
	<c:if test="${userClickHome == true}">
		<%@include file="homeContent.jsp"%>
	</c:if>
	
	<!-- assure that the homeContent will be displayed only if user clicks about button -->
	<c:if test="${userClickAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>
	
	<!-- assure that the homeContent will be displayed only if user clicks contact button -->
	<c:if test="${userClickContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
	
	<!-- assure that the homeContent will be displayed only if user clicks contact button -->
	<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
		<%@include file="listProducts.jsp"%>
	</c:if>
	
	<!-- <!-- assure that the homeContent will be displayed only if user clicks single product button -->
	<c:if test="${userClickShowProduct == true}">
		<%@include file="singleProduct.jsp"%>
	</c:if>
	
	<!-- <!-- assure that the cart will be displayed only if user clicks single product button -->
	<c:if test="${userClickShowCart == true}">
		<%@include file="cart.jsp"%>
	</c:if>
	
	<!-- when user click manage products -->
	<c:if test="${userClickManageProducts == true}">
		<%@include file="manageProducts.jsp"%>
	</c:if>
	
	<!-- /.container -->

	<!-- Footer comes here -->
	<%@include file="./sharedPages/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/popper.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<!-- DataTable PlugIn -->
	<script src="${js}/jquery.dataTables.min.js"></script>
	
	<!-- datatable bootstrap js file -->
	<script src="${js}/dataTables.bootstrap.min.js"></script>
	
	<script src="${js}/jquery.validate.js"></script>
	
	<script src="${js}/bootbox.min.js"></script>
	
	<script src="${js}/app.js"></script>

</body>

</html>
