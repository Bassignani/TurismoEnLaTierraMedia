<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

				<section id="slider" class="pt-5 lista" style="height: auto;">
					<div class="container">
						<!-- <h1 class="text-center"><b>Responsive Owl Carousel</b></h1> -->
						<div class="slider" >
							<div class="owl-carousel">
								
								<c:forEach items="${vendibles}" var="tmp_vendible">	
										<div class="slider-card text-center" style="height: auto; margin-top:5rem"  >
											<div class="d-flex justify-content-center align-items-center mb-4">
												<img src="<c:out value="${tmp_vendible.getPathImg()}"></c:out>" alt="">
											</div>
											<h5 class="mb-0 text-center"><b><c:out value="${tmp_vendible.getNombre()}"></c:out></b></h5>
											<p class=" p-4" style="text-align: justify"><c:out value="${tmp_vendible.getDescription()}"></c:out></p>
											<div class="iconos">
												<span>
													<img alt="Precio" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/GoldCoinsIcono.png"> 
													<c:out value="${tmp_vendible.getCosto()}"></c:out>
												</span> 
												<span>
													<img alt="Duracion"src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/RelojDeArenaIcono.png">
													<c:out value="${tmp_vendible.getDuracion()}"></c:out>
												</span>
											</div>
											<a href="/TurismoEnLaTierraMedia2021WebApp/usuario/comprar.do?id=${tmp_vendible.getId()}&promo=${tmp_vendible.esPromo()}" class="btn btn-miPrincipal m-2">Comprar</a>								
										</div>
								</c:forEach>
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