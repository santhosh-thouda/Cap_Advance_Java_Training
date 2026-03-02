<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
<h1>Employee Registration Page</h1>
<form action="/create" method="post">
Name: <input type="text" name="name"> <br/>
Salary: <input type="text" name="salary"> <br/>
Role: <input type="text" name="role"> <br/>
Email: <input type="text" name="email"> <br/>
Password: <input type="text" name="password"> <br/>

<input type="submit" name="Register"> <br/>
</form>

</body>

</html>