<!DOCTYPE html>
<html>
<head>
<title>Booking Success</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>
body {
	font-family: Arial;
	text-align: center;
	margin-top: 120px;
}

a {
	background: green;
	padding: 12px 25px;
	color: white;
	text-decoration: none;
	border-radius: 6px;
}
</style>

</head>

<body>

	<h1>Booking Successful </h1>

	<br>

	<h3>

		Booking ID :

		<%=request.getAttribute("bookingId")%>

	</h3>

	<br>

	<a href="myBookings"> My Bookings </a>

</body>

</html>