<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%--<jsp:include page="header.jsp" />--%>
<%--<jsp:include page="${partial}" />--%>
<%--<jsp:include page="footer.jsp" />--%>
<%@include file="header.jsp"%>
<jsp:include page="${partial}" />
<%@include file="footer.jsp"%>
</body>
</html>