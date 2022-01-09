<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Books</title>
</head>
<body>
<ul>
    <c:forEach items="${books}" var="book">
        <li>
                ${book.id},${book.title},${book.author}
            <a href="/books/show/${book.id}">Show more informations</a>
            <a href="/books/edit/${book.id}">Edit</a>
            <a href="/books/remove/${book.id}">Remove</a>

        </li>
    </c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/">Return</a>
</body>
</html>