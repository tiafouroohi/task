<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="/priority" method="post" modelAttribute="priority">
<p>
<form:label path="priority">Priority:</form:label>
<form:errors path="priority"></form:errors>
<form:input path="priority"></form:input>
</p>

<input type="submit" value="Submit"/>

</form:form>

</body>
</html>