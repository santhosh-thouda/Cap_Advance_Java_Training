<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<title>TaskTrack</title>

<style>

body{
font-family: 'Segoe UI';
background: linear-gradient(135deg,#667eea,#764ba2);
margin:0;
color:white;
}

.container{
width:90%;
margin:auto;
padding-top:40px;
animation: fadeIn 1s ease-in;
}

h1{
text-align:center;
margin-bottom:30px;
}

.add-btn{
background:#00ffcc;
padding:10px 20px;
border-radius:25px;
text-decoration:none;
color:black;
font-weight:bold;
transition:0.3s;
}

.add-btn:hover{
transform:scale(1.1);
background:#00ddb3;
}

table{
width:100%;
border-collapse:collapse;
background:white;
color:black;
border-radius:10px;
overflow:hidden;
box-shadow:0 10px 25px rgba(0,0,0,0.2);
}

th{
background:#667eea;
color:white;
padding:12px;
}

td{
padding:12px;
text-align:center;
}

tr{
transition:0.3s;
}

tr:hover{
background:#f1f1f1;
transform:scale(1.01);
}

img{
border-radius:8px;
}

.action-btn{
padding:6px 12px;
border-radius:15px;
text-decoration:none;
color:white;
margin:2px;
}

.complete{
background:#28a745;
}

.delete{
background:#dc3545;
}

.complete:hover{
background:#1e7e34;
}

.delete:hover{
background:#bd2130;
}

@keyframes fadeIn{
from{opacity:0; transform:translateY(20px);}
to{opacity:1; transform:translateY(0);}
}

</style>

</head>

<body>

<div class="container">

<h1>🚀 TaskTrack Manager</h1>

<a class="add-btn" href="/tasks/new">+ Add New Task</a>

<br><br>

<table>

<tr>
<th>Image</th>
<th>Title</th>
<th>Description</th>
<th>Due Date</th>
<th>Priority</th>
<th>Status</th>
<th>Actions</th>
</tr>

<c:forEach var="task" items="${taskList}">

<tr>

<td>
<img src="/tasks/image/${task.id}" width="60">
</td>

<td>${task.title}</td>
<td>${task.description}</td>
<td>${task.dueDate}</td>
<td>${task.priority}</td>
<td>${task.status}</td>

<td>

<a class="action-btn complete" href="/tasks/toggle/${task.id}">
✔
</a>

<a class="action-btn delete" href="/tasks/delete/${task.id}">
🗑
</a>

</td>

</tr>

</c:forEach>

</table>

</div>

</body>
</html>