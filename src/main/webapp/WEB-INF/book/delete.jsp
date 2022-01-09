<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<p>
    Are you sure you want to remove book with id ${bookId} ?
</p>
<div>
    <a href="${pageContext.request.contextPath}/books/delete/${bookId}"> Yes </a>
    <a href="${pageContext.request.contextPath}/books/all"> No </a>
</div>
</body>
</html>
