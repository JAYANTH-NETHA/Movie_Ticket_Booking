<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Seats</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>
body {
	font-family: Arial;
	text-align: center;
	background: #f4f4f4;
}

.container {
	width: 650px;
	margin: auto;
}

.screen {
	background: #555;
	color: white;
	padding: 10px;
	margin: 20px auto;
	width: 80%;
	border-radius: 5px;
}

.seat {
	display: inline-block;
	width: 45px;
	height: 45px;
	margin: 5px;
}

.seat input {
	display: none;
}

.seat span {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 45px;
	height: 45px;
	border: 1px solid black;
	border-radius: 5px;
	cursor: pointer;
	background: white;
}

.seat input:checked+span {
	background: #16a34a;
	color: white;
}

button {
	margin-top: 30px;
	padding: 12px 25px;
	font-size: 18px;
	border: none;
	border-radius: 5px;
	background: #2563eb;
	color: white;
	cursor: pointer;
}

button:hover {
	background: #1d4ed8;
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

	<h2>Select Your Seats</h2>

	<div class="screen">SCREEN</div>

	<form action="booking" method="post">

		<input type="hidden" name="showId"
			value="<%=request.getAttribute("showId")%>">

		<div class="container">

			<%
			for (char row = 'A'; row <= 'E'; row++) {

				for (int col = 1; col <= 9; col++) {
			%>

			<label class="seat"> <input type="checkbox" name="seats"
				value="<%=row%><%=col%>"> <span><%=row%><%=col%></span>

			</label>

			<%
			}
			%>

			<br>
			<br>

			<%
			}
			%>

		</div>

		<button type="submit">Proceed to Payment</button>

	</form>

</body>
</html>