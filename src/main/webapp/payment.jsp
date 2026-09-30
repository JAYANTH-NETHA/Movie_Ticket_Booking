<%@ page language="java"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Payment</title>
<div class="top-nav">

    <a href="profile">My Profile</a>

    <a href="myBookings">My Bookings</a>

    <a href="logout" class="logout">Logout</a>

</div>
<style>
body {
	font-family: Arial;
	background: #f4f4f4;
}

form {
	width: 400px;
	margin: 60px auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 10px gray;
}

input, select {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
}

button {
	width: 100%;
	padding: 12px;
	background: green;
	color: white;
	border: none;
	font-size: 18px;
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

	<form action="payment" method="post">

		<input type="hidden" name="bookingId"
			value="<%=request.getAttribute("bookingId")%>"> <input
			type="hidden" name="amount"
			value="<%=request.getAttribute("amount")%>">

		<h2 align="center">Payment</h2>

		<label>Payment Method</label> <select name="paymentMethod">

			<option>UPI</option>

			<option>Credit Card</option>

			<option>Debit Card</option>

			<option>Net Banking</option>

			<option>Cash</option>

		</select> <label>Coupon</label> <input type="text" name="couponCode"> <label>Amount</label>

		<input type="text" value="<%=request.getAttribute("amount")%>"
			readonly>

		<button>Pay Now</button>

	</form>

</body>

</html>