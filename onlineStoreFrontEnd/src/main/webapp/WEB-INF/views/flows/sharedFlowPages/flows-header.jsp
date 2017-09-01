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

 <!-- navigation -->
 <%@include file="flows-navbar.jsp" %>

	<div class="content">
