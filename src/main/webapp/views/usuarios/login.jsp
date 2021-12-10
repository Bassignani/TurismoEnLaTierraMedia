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
					<h1 class="display-4 fuente" >Inicio de Sesión</h1>
				</article>

			<div class="lista text-center mt-5">
				<form>
					<div class="mb-3">
					  <label for="email" class="form-label">Email</label>
					  <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
					  <div id="emailHelp" class="form-text">Nunca compartiremos tus datos con nadie.</div>
					</div>
					<div class="mb-3">
					  <label for="contraseña" class="form-label">Contraseña</label>
					  <input type="password" class="form-control" id="contraseña">
					</div>
					<button type="submit" class="btn  btn-miPrincipal">Ingresar</button>
				  </form>
			</div>
			
		</section>
	</div>
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>