<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body class="light-theme">
	
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	
	<div class="flex container mt-5">
		<main class="home">
			<section class="mt-5">
				<article class="container mt-4 text-center">
					<h1 class="display-4 fuente" >Comprar</h1>
				</article>

				<section id="slider" class="pt-5 lista">
					<div class="container">
						<!-- <h1 class="text-center"><b>Responsive Owl Carousel</b></h1> -->
						<div class="slider">
							<div class="owl-carousel">
								<div class="slider-card text-center">
									<div class="d-flex justify-content-center align-items-center mb-4">
										<img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/hotSale.png" alt="">
									</div>
									<h5 class="mb-0 text-center"><b>Pack hotSale</b></h5>
									<p class="text-center p-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam
										temporibus quidem magni qui doloribus quasi natus inventore nisi velit minima.</p>
									<a href="#" class="btn btn-miPrincipal m-2">Comprar</a>	
								</div>
				
								<div class="slider-card text-center">
									<div class="d-flex justify-content-center align-items-center mb-4">
										<img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Atracciones/1_Moria1.jpg" alt="">
									</div>
									<h5 class="mb-0 text-center"><b>Moria</b></h5>
									<p class="text-center p-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam
										temporibus quidem magni qui doloribus quasi natus inventore nisi velit minima.</p>
									<a href="#" class="btn btn-miPrincipal m-2">Comprar</a>
								</div>
				
								<div class="slider-card text-center">
									<div class="d-flex justify-content-center align-items-center mb-4">
										<img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Atracciones/2_MinasTirith1.jpg" alt="">
									</div>
									<h5 class="mb-0 text-center"><b>Minas Tirith</b></h5>
									<p class="text-center p-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam
										temporibus quidem magni qui doloribus quasi natus inventore nisi velit minima.</p>
									<a href="#" class="btn btn-miPrincipal m-2">Comprar</a>
								</div>
				
								<div class="slider-card text-center">
									<div class="d-flex justify-content-center align-items-center mb-4">
										<img src=/TurismoEnLaTierraMedia2021WebApp/assets/img/Atracciones/3_LaComarca2.jpg" alt="">
									</div>
									<h5 class="mb-0 text-center"><b>La Comarca</b></h5>
									<p class="text-center p-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam
										temporibus quidem magni qui doloribus quasi natus inventore nisi velit minima.</p>
									<a href="#" class="btn btn-miPrincipal m-2">Comprar</a>
								</div>
				
								<div class="slider-card text-center">
									<div class="d-flex justify-content-center align-items-center mb-4">
										<img  src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Atracciones/4_Mordor3.jpg" alt="">
									</div>
									<h5 class="mb-0 text-center"><b>Modor</b></h5>
									<p class="text-center p-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsam
										temporibus quidem magni qui doloribus quasi natus inventore nisi velit minima.</p>
									<div class="iconos">
										<span><img alt="Precio" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/GoldCoinsIcono.png"> 50
												monedas</span> <span><img alt="Duracion"
													src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/RelojDeArenaIcono.png">
												6 horas</span>
									</div>	
									<a href="#" class="btn btn-miPrincipal m-2">Comprar</a>
								</div>
							</div>
						</div>
					</div>
				</section>
			</section>
		</main>
	</div>
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script> 
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" ></script> 
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/carrusel/owl.carousel.min.js"></script> 
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/carrusel/scipt.js"></script> 
	
</body>
	
</html>