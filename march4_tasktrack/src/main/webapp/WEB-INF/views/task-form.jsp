<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<title>Add Task</title>

<style>

body{
font-family:'Segoe UI';
background:linear-gradient(135deg,#667eea,#764ba2);
display:flex;
justify-content:center;
align-items:center;
height:100vh;
}

.form-card{
background:white;
padding:40px;
border-radius:15px;
width:400px;
box-shadow:0 10px 25px rgba(0,0,0,0.3);
animation:slideUp 0.7s ease;
}

h2{
text-align:center;
margin-bottom:20px;
}

input, textarea, select{
width:100%;
padding:10px;
margin:8px 0;
border-radius:8px;
border:1px solid #ccc;
}

button{
width:100%;
padding:12px;
border:none;
background:#667eea;
color:white;
border-radius:8px;
font-size:16px;
cursor:pointer;
transition:0.3s;
}

button:hover{
background:#4c5fd7;
transform:scale(1.05);
}

.back{
display:block;
text-align:center;
margin-top:15px;
text-decoration:none;
}

@keyframes slideUp{
from{transform:translateY(40px); opacity:0;}
to{transform:translateY(0); opacity:1;}
}

</style>

</head>

<body>

<div class="form-card">

<h2>✨ Add New Task</h2>

<form:form method="post"
action="/tasks/save"
modelAttribute="task"
enctype="multipart/form-data">

Title
<form:input path="title"/>

Description
<form:textarea path="description"/>

Due Date
<form:input path="dueDate" type="date"/>

Priority
<form:select path="priority">

<form:option value="">Select</form:option>
<form:option value="LOW">LOW</form:option>
<form:option value="MEDIUM">MEDIUM</form:option>
<form:option value="HIGH">HIGH</form:option>

</form:select>

Upload Image
<input type="file" name="imageFile">

<br><br>

<button type="submit">Save Task</button>

</form:form>

<a class="back" href="/tasks">← Back</a>

</div>

</body>
</html>