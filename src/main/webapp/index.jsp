<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body class="light-theme">
	
	<jsp:include page="partials/nav.jsp"></jsp:include>
	
	
	
	
	
	
	<div class="flex container mt-5">
		<main class="home">
			<article class="container mt-4 text-center">
				<h1 class="display-2 fuente titulo" >La Tierra Media</h1>
				<p class="lead">Lorem ipsum dolor sit amet consectetur
					adipisicing elit. Aliquid, rem asperiores necessitatibus optio
					harum quidem eveniet. Illo incidunt totam, animi minus eveniet
					officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
			</article>


			<section class="mt-5">
				<ul id="productos" class="lista text-center">
					
					<c:forEach items="${vendibles}" var="tmp_vendible">		
					
					<li>
						<div class="card">
							<img src="assets/img/Varios/hotSale.png" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title"><c:out value="${tmp_vendible.getNombre()}"></c:out></h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span>
										<img alt="Precio" src="assets/img/Varios/GoldCoinsIcono.png">
										<c:out value="${tmp_vendible.getCosto()}"></c:out>
									</span> 
									<span>
										<img alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										<c:out value="${tmp_vendible.getDuracion()}"></c:out>
									</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal mt-1">Comprar</a>
							</div>
						</div>
					</li>
					
					</c:forEach>
					
					
					<!-- <li>
						<div class="card">
							<img src="assets/img/Varios/hotSale.png" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Pack Degustacion</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Varios/hotSale.png" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Pack Paisajes</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Varios/hotSale.png" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Pack Locuras</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Varios/hotSale.png" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Pack Festin</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Varios/hotSale.png" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Pack HotSale</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/1_Moria4.jpg" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Moria</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/2_MinasTirith2.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Minas Tirith</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/3_LaComarca3.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">La Comarca</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>

					<li>
						<div class="card">
							<img src="assets/img/Atracciones/4_Mordor3.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Mordor</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/5_AbismoDeHelm1.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Abismo de Helm</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/6_Lothlorien4.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Lothlorien</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/7_Erebor2.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Erebor</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/8_BosqueNegro4.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Bosque Negro</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li>
					<li>
						<div class="card">
							<img src="assets/img/Atracciones/9_ElPonyPisador1.jpg"
								class="card-img-top" alt="articulo">
							<div class="card-body">
								<h5 class="card-title">Taberna Pony Pisador</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Aliquid, rem asperiores necessitatibus optio
									harum quidem eveniet. Illo incidunt totam, animi minus eveniet
									officia neque perspiciatis et. Iste possimus voluptate commodi?</p>
								<div class="iconos">
									<span><img alt="Precio"
										src="assets/img/Varios/GoldCoinsIcono.png"> 50 monedas</span> <span><img
										alt="Duracion" src="assets/img/Varios/RelojDeArenaIcono.png">
										6 horas</span>
								</div>
								<a href="ofertar.html" class="btn btn-miPrincipal">Comprar</a>
							</div>
						</div>
					</li> -->
				</ul>
			</section>
		</main>
	</div>
	
	
	
	
	<jsp:include page="partials/footer.jsp"></jsp:include>
	
</body>
	<script src="assets/javascript/main.js"></script>
</html>