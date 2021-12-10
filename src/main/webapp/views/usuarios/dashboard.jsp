<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body class="light-theme">
	
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	
	<div class="flex container">
       <section class="lista mt-5 text-center">
            <h3 class="col-12 mb-3 fuente">Panel de Administrador</h3>
            <div class="d-grid gap-2 col-6 mx-auto">
                <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/usuarios.jsp">Usuarios</a>
                <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/views/promociones/promociones.jsp">Promociones</a>
                <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/views/atracciones/atracciones.jsp">Atracciones</a>
            </div>
        </section> 
    </div>
        
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>