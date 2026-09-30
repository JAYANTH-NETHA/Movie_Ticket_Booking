<%@page import="java.util.List"%>
<%@page import="com.movie_booking.dto.Show"%>

<%
List<Show> shows = (List<Show>) request.getAttribute("shows");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Select Show</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial;
}

body {
	background: #f4f4f4;
}

h1 {
	text-align: center;
	margin: 30px;
}

.container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 20px;
}

.card {
	width: 300px;
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 3px 10px gray;
}

.card h2 {
	color: #2563eb;
	margin-bottom: 10px;
}

.card p {
	margin: 8px 0;
}

.card a {
	display: block;
	margin-top: 20px;
	text-align: center;
	padding: 10px;
	background: #16a34a;
	color: white;
	text-decoration: none;
	border-radius: 6px;
}

.card a:hover {
	background: #15803d;
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
}.top-nav{
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

	<h1>Available Shows</h1>

	<div class="container">

		<%
		if (shows != null) {

			for (Show show : shows) {
		%>

		<div class="card">

			<h2><%=show.getTheatreName()%></h2>

			<p>
				<b>Location :</b>
				<%=show.getLocation()%></p>

			<p>
				<b>Screen :</b>
				<%=show.getScreenType()%></p>

			<p>
				<b>Date :</b>
				<%=show.getShowDate()%></p>

			<p>
				<b>Time :</b>
				<%=show.getShowTime()%></p>

			<p>
				<p>
				<b>Price :</b> &#8377;
				<%=show.getTicketPrice()%></p>

&#9733;
			<a href="seatSelection?showId=<%=show.getShowId()%>"> Select
					Seats </a>
			</div>

		<%
		}

		}
		%>

	</div>

</body>

</html>