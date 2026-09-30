<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.movie_booking.dto.Movie" %>

<%
Movie movie = (Movie) request.getAttribute("movie");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Details</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f4f4;
}

.container{

    width:80%;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:12px;
    box-shadow:0 5px 15px rgba(0,0,0,.2);

    display:flex;
    gap:40px;
}

.poster img{

    width:300px;
    height:430px;
    border-radius:10px;
}

.details{

    flex:1;
}

.details h1{

    margin-bottom:20px;
    color:#1f2937;
}

.details p{

    margin:12px 0;
    font-size:18px;
}

.details strong{

    color:#2563eb;
}

.book-btn{

    display:inline-block;
    margin-top:30px;
    padding:12px 25px;
    background:#16a34a;
    color:white;
    text-decoration:none;
    border-radius:8px;
    font-size:18px;
}

.book-btn:hover{

    background:#15803d;
}

.trailer{

    display:inline-block;
    margin-left:20px;
    padding:12px 25px;
    background:#dc2626;
    color:white;
    text-decoration:none;
    border-radius:8px;
}

.trailer:hover{

    background:#b91c1c;
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

<%
if(movie != null){
%>

<div class="container">

    <div class="poster">

        <img src="<%=request.getContextPath()%>/Html/Images/<%=movie.getPoster()%>">

    </div>

    <div class="details">

        <h1><%=movie.getMovieName()%></h1>

        <p><strong>Genre :</strong> <%=movie.getGenre()%></p>

        <p><strong>Language :</strong> <%=movie.getLanguage()%></p>

        <p><strong>Duration :</strong> <%=movie.getDuration()%></p>

        <p><strong>Censor :</strong> <%=movie.getCensor()%></p>

        <p><strong>Release Date :</strong> <%=movie.getReleaseDate()%></p>

        <p><strong>Rating :</strong> ⭐ <%=movie.getRating()%></p>

        <p><strong>Cast :</strong> <%=movie.getCast()%></p>

        <p><strong>Description :</strong></p>

        <p><%=movie.getDescription()%></p>

        <a class="book-btn"
           href="shows?movieId=<%=movie.getMovieId()%>">
            Proceed to Book
        </a>

        <a class="trailer"
           href="<%=movie.getTrailer()%>"
           target="_blank">
            Watch Trailer
        </a>

    </div>

</div>

<%
}else{
%>

<h2 align="center">Movie Not Found!</h2>

<%
}
%>

</body>
</html>