<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />

<meta http-equiv="X-UA-Compatible" content="chrome" />
<title>Male-Fashion | Template</title>

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
	<%@include file="header.jsp"%>
	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb__text">
						<h4>Check Out</h4>
						<div class="breadcrumb__links">
							<a href="index.jsp">Home</a> <a href="./shop.html">Shop</a> <span>My
								Cart</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">
			<div class="checkout__form">
				<form action="#">
					<div class="row">
						<div class="col-lg-8 col-md-6">

							<h6 class="checkout__title">Order Details</h6>

							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Name<span>*</span>
										</p>
										<input type="text" name="order_name" />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Name(ENG)<span>*</span>
										</p>
										<input type="text" name="order_nameEng"
											placegolder="해외배송시 꼭 영문으로 필수 입력" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Country<span>*</span>
										</p>
										<input type="text" name="country" />
									</div>
								</div>

							</div>
							<div class="checkout__input">
								<p>
									Address<span>*</span>
								</p>
								<input type="text" placeholder="Street Address"
									class="checkout__input__add" /> <input type="text"
									name="address3" />
							</div>
							<div class="checkout__input">
								<p>
									Town/City<span>*</span>
								</p>
								<input type="text" name="address2" />
							</div>
							<div class="checkout__input">
								<p>
									Country/State<span>*</span>
								</p>
								<input type="text" name="address1" />
							</div>
							<div class="checkout__input">
								<p>
									Postcode / ZIP<span>*</span>
								</p>
								<input type="text" />
							</div>
							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Phone<span>*</span>
										</p>
										<input type="text" />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Email<span>*</span>
										</p>
										<input type="text" />
									</div>
								</div>
							</div>


							<div class="checkout__input__checkbox">
								<label for="diff-acc"> 해외배송의 경우 체크 해주세요 <input
									type="checkbox" id="diff-acc" /> <span class="checkmark"></span>
								</label>
							</div>
							<div class="checkout__input">
								<p>
									Order notes<span>*</span>
								</p>
								<input type="text"
									placeholder="Notes about your order, e.g. special notes for delivery." />
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="checkout__order">
								<h4 class="order__title">My Cart</h4>
								<div class="checkout__order__products">
									Product <span>Total</span>
								</div>
								<ul class="checkout__total__products">
									<li>01. Vanilla salted caramel <span>$ 300.0</span></li>
									<li>02. German chocolate <span>$ 170.0</span></li>
									<li>03. Sweet autumn <span>$ 170.0</span></li>
									<li>04. Cluten free mini dozen <span>$ 110.0</span></li>
								</ul>
								<ul class="checkout__total__all">
									<li>Subtotal <span>$750.99</span></li>
									<li>Total <span>$750.99</span></li>
								</ul>

								<p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do
									eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

								<div class="checkout__input__checkbox">
									<label for="confirm_order"> 주문내용을 확인하였으며 위 내용으로 주문을
										진행합니다 <input type="checkbox" id="confirm_order" /> <span
										class="checkmark"></span>
									</label>
								</div>
								<button type="submit" class="site-btn">주문하기</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- Checkout Section End -->
	<%@include file="footer.jsp"%>
	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.nicescroll.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.countdown.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>