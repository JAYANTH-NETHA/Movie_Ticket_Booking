<%@page import="java.util.List"%>
<%@page import="com.movie_booking.dto.Booking"%>

<%
List<Booking> list = (List<Booking>) request.getAttribute("bookings");
%>

<!DOCTYPE html>

<html>

<head>

<title>My Bookings</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>
table {
	width: 90%;
	margin: auto;
	border-collapse: collapse;
}

th, td {
	border: 1px solid gray;
	padding: 10px;
	text-align: center;
}

a {
	background: red;
	color: white;
	padding: 6px 15px;
	text-decoration: none;
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

	<h2 align="center">My Bookings</h2>

	<table>

		<tr>

			<th>ID</th>

			<th>Show</th>

			<th>Seats</th>

			<th>Tickets</th>

			<th>Amount</th>

			<th>Status</th>

			<th>Action</th>

		</tr>

		<%
		for (Booking booking : list) {
		%>

		<tr>

			<td><%=booking.getBookingId()%></td>

			<td><%=booking.getShowId()%></td>

			<td><%=booking.getSeats()%></td>

			<td><%=booking.getNumberOfTickets()%></td>

		
			<td>&#8377;<%=booking.getTotalAmount()%></td>

			<td><%=booking.getBookingStatus()%></td>

			<td>
				<%
				if ("Booked".equals(booking.getBookingStatus())) {
				%> <a href="cancelBooking?bookingId=<%=booking.getBookingId()%>">

					Cancel </a> <%
 }
 %>

			</td>

		</tr>

		<%
		}
		%>

	</table>

</body>

</html>