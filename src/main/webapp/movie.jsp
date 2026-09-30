<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.movie_booking.dto.Movie"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movies</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>
.movies {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

.movie {
	width: 220px;
	border: 1px solid #ccc;
	padding: 15px;
	text-align: center;
	border-radius: 10px;
}

.movie img {
	width: 150px;
	height: 220px;
}

.movie a {
	text-decoration: none;
	background: green;
	color: white;
	padding: 8px 15px;
	border-radius: 5px;
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

	<h2 align="center">Available Movies</h2>

	<%
	List<Movie> movies = (List<Movie>) request.getAttribute("movies");
	%>

	<div class="movies">

		<%
		if (movies != null) {
			for (Movie movie : movies) {
		%>

		<div class="movie">

			<img
				src="<%=request.getContextPath()%>/Html/Images/<%=movie.getPoster()%>">



			<h3><%=movie.getMovieName()%></h3>

			<p>
				Genre :
				<%=movie.getGenre()%></p>

			<p>
				Language :
				<%=movie.getLanguage()%></p>

			<p>
				Duration :
				<%=movie.getDuration()%></p>

			<p>
				⭐
				<%=movie.getRating()%></p>

			<a href="movieDetails?id=<%=movie.getMovieId()%>">Book Now</a>



		</div>

		<%
		}
		}
		%>

	</div>

</body>
</html>