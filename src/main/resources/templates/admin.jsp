
<!DOCTYPE html >
<html xmlns:th="https://www.thymeleaf.org">
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link rel="stylesheet" th:href="@{authorization.css}" type="text/css" />
</head>

<body>
<div>
  <table>
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>Password</th>
    <th>Roles</th>
    </thead>
    <c:forEach items="${allStudens}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.username}</td>
        <td>${student.password}</td>
        <td>
          <c:forEach items="${student.roles}" var="role">${role.name}; </c:forEach>
        </td>
        <td>
          <form action="${pageContext.request.contextPath}/admin" method="post">
            <input type="hidden" name="studentId" value="${student.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>