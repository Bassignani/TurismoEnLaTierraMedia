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
							<img src="<c:out value="${tmp_vendible.getPathImg()}"></c:out>" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title"><c:out value="${tmp_vendible.getNombre()}"></c:out></h5>
								<p class="card-text" style="text-align: justify"><c:out value="${tmp_vendible.getDescription()}"></c:out></p>
								<div class="iconos">
									<span>
										<img alt="Precio" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/GoldCoinsIcono.png">
										<c:out value="${tmp_vendible.getCosto()}"></c:out>
									</span> 
									<span>
										<img alt="Duracion" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/RelojDeArenaIcono.png">
										<c:out value="${tmp_vendible.getDuracion()}"></c:out>
									</span>
								</div>
									<c:choose>
					                      <c:when test="${usuario != null}">             
					                        <a href="/TurismoEnLaTierraMedia2021WebApp/vendibles/ofertar.do?id=${usuario.getId()}" class="btn btn-miPrincipal mt-1">Comprar</a>
					                      </c:when>   
					                      <c:otherwise>
					                      	<a href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/login.jsp" class="btn btn-miPrincipal mt-1">Comprar</a>
					                      </c:otherwise>
                      				</c:choose>  
							</div>
						</div>
					</li>
					
					</c:forEach>
					
				</ul>
			</section>
		</main>
	</div>
	
	
	
	
	<jsp:include page="partials/footer.jsp"></jsp:include>
	<script src="assets/javascript/main.js"></script>
</body>
</html>