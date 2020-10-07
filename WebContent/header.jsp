<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="chrome" />
<title>ORENO * MARKET</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
	rel="stylesheet" />

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css" />
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />
<link rel="stylesheet" href="css/nice-select.css" type="text/css" />
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css" />
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>

<body>
	<!-- Offcanvas Menu Begin -->
	<%
		request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	%>

	<div class="offcanvas-menu-overlay">

		<div class="offcanvas-menu-wrapper">
			<div class="offcanvas__option">
				<div class="offcanvas__links">
					<a href="#">Sign in</a> <a href="#">FAQs</a>
				</div>
				<div class="offcanvas__top__hover">
					<span>Lang<i class="fas fa-angle-down"></i></span>
					<ul>
						<li>KOR</li>
						<li>JPN</li>

					</ul>
				</div>
			</div>
			<div class="offcanvas__nav__option">
				<a href="#" class="search-switch"><img src="img/icon/search.png"
					alt="검색버튼" /></a> <a href="#"><img src="img/icon/heart.png"
					alt="찜하기" /></a> <a href="#"><img src="img/icon/cart.png"
					alt="장바구니" /> <span>0</span></a>
				<div class="price">$0.00</div>
			</div>
			<div id="mobile-menu-wrap"></div>
			<div class="offcanvas__text">
				<p>123123</p>
			</div>
		</div>
	</div>
	<!-- Offcanvas Menu End -->

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-7">
						<div class="header__top__left">
							<p>123456</p>
						</div>
					</div>
					<div class="col-lg-6 col-md-5">
						<div class="header__top__right">
							<div class="header__top__links">
								<a href="login.jsp">Login</a> 
								<a href="#">FAQs</a>
							</div>
							<div class="header__top__hover">
								<span>Lang <i class="fa fa-arrow_carrot-down"></i></span>
								<ul>
									<a href="#"><li>Language</li></a>
									<a href="index.jsp"><li>KOR</li></a>
									<a href="#"><li>JPN</li></a>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3">
					<div class="header__logo">
						<a href="index.jsp"><img src="img/logo.png" alt="상단 헤더 로고" /></a>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<nav class="header__menu mobile-menu">
						<ul>
							<li class="active"><a href="index.jsp">Home</a></li>
							<li><a href="#">CD/DVD</a>
								<ul class="dropdown">
									<li><a href="#">K-POP</a></li>
									<li><a href="#">J-POP</a></li>
									<li><a href="#">POP</a></li>
									<li><a href="#">ETC.</a></li>
								</ul></li>
							<li><a href="#">GOODS</a>
								<ul class="dropdown">
									<li><a href="./about.html">K-POP</a></li>
									<li><a href="./shop-details.html">J-POP</a></li>
									<li><a href="./checkout.html">ANIMATION/GAME</a></li>
									<li><a href="./shopping-cart.html">ETC.</a></li>
								</ul></li>
							<li><a href="#">SHOPS</a>
								<ul class="dropdown">
									<li><a href="./about.html">ABOUT US</a></li>
									<li><a href="./shopping-cart.html">NOTICE</a></li>
									<li><a href="./contact.html">CONTACT</a></li>
									<li><a href="./checkout.html">OFFLINE EVENT</a></li>
								</ul></li>
							<li><a href="#">MY PAGE</a>
								<ul class="dropdown">
									<li><a href="./about.html">1:1</a></li>
									<li><a href="./shopping-cart.html">CART</a></li>
									<li><a href="#">TRACKING</a></li>
									<li><a href="#">RETURN</a>
									<li><a href="#">MY PAGE</a>
								</ul></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3 col-md-3">
					<div class="header__nav__option">
						<a href="#" class="search-switch"><img
							src="img/icon/search.png" alt="" /></a> <a href="#"><img
							src="img/icon/heart.png" alt="" /></a> <a href="#"><img
							src="img/icon/cart.png" alt="" /> <span>0</span></a>
						<div class="price">$0.00</div>
					</div>
				</div>
			</div>
			<div class="canvas__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->
</body>

</html>