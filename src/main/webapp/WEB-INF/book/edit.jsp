<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>
</head>
<body>
<form:form action="/books/edit" method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <div>
        <label>Isbn number:</label>
        <form:input path="isbn" type="text"/>
        <form:errors path="isbn" cssClass="error"/>
    </div>
    <div>
        <label>Title:</label>
        <form:input path="title" type="text"/>
        <form:errors path="title" cssClass="error"/>
    </div>
    <div>
        <label>Author:</label>
        <form:input path="author" type="text"/>
        <form:errors path="author" cssClass="error"/>
    </div>
    <div>
        <label>Publisher:</label>
        <form:input path="publisher" type="text"/>
        <form:errors path="publisher" cssClass="error"/>
    </div>
    <div>
        <label>Type:</label>
        <form:input path="type" type="text"/>
        <form:errors path="type" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Save">
    </div>
</form:form>
</body>
</html>
