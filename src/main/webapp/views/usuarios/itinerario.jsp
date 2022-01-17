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
				<article class="container mt-4 text-center">
					<h1 class="display-4 fuente" >Itinerario de <c:out value="${usuario.getNombre()}"></c:out></h1>
				</article>
			

			<c:if test="${success != null}">
				<div class="alert alert-success text-center"> 
					<p>
						<c:out value="${success}"/>
					</p>
				</div>
			</c:if>

			<section class="mt-5">
				<ul id="productos" class="lista text-center">
					
					<c:forEach items="${vendiblesComprados}" var="tmp_vendibleComp">		
					
					<li>
						<div class="card">
							<img src="<c:out value="${tmp_vendibleComp.getPathImg()}"></c:out>" class="card-img-top"
								alt="articulo">
							<div class="card-body">
								<h5 class="card-title"><c:out value="${tmp_vendibleComp.getNombre()}"></c:out></h5>
								<p class="card-text" style="text-align: justify"><c:out value="${tmp_vendibleComp.getDescription()}"></c:out></p>
								<div class="iconos">
									<span>
										<img alt="Precio" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/GoldCoinsIcono.png">
										<c:out value="${tmp_vendibleComp.getCosto()}"></c:out>
									</span> 
									<span>
										<img alt="Duracion" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/RelojDeArenaIcono.png">
										<c:out value="${tmp_vendibleComp.getDuracion()}"></c:out>
									</span>
								</div>
							</div>
						</div>
					</li>
					
					</c:forEach>
					
				</ul>
			</section>
		</main>
	</div>
	
	
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</body>
</html>