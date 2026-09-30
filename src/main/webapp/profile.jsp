<%@page import="com.movie_booking.dto.User"%>

<%
User user=(User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>

<title>Profile</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>

body{
font-family:Arial;
background:#f4f4f4;
}

.card{

width:500px;
margin:50px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0 0 10px gray;

}

h2{
text-align:center;
}

p{
font-size:18px;
margin:15px;
}

a{

display:inline-block;
margin-top:20px;
background:green;
color:white;
padding:10px 20px;
text-decoration:none;

}
.top-nav{
    width:100%;
    background:#1f2937;
    padding:15px 30px;
    display:flex;
    justify-content:flex-end;
    align-items:center;
    gap:20px;
    box-sizing:border-box;
}

.top-nav a{
    color:white;
    text-decoration:none;
    font-size:17px;
    font-weight:bold;
    padding:8px 16px;
    border-radius:6px;
    transition:.3s;
}

.top-nav a:hover{
    background:#2563eb;
}

.top-nav .logout{
    background:#dc2626;
}

.top-nav .logout:hover{
    background:#b91c1c;
}
</style>

</head>

<body>

<div class="card">

<h2>My Profile</h2>

<p><b>Name :</b> <%=user.getUserName()%></p>

<p><b>Email :</b> <%=user.getEmail()%></p>

<p><b>Mobile :</b> <%=user.getMobile()%></p>

<p><b>Gender :</b> <%=user.getGender()%></p>

<p><b>DOB :</b> <%=user.getDob()%></p>

<p><b>Address :</b> <%=user.getAddress()%></p>

<a href="movies">Back</a>

</div>

</body>
</html>