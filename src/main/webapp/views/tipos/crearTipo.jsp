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
	
	<div class="flex container">
		<section class="mt-5">

			<div class="lista text-center mt-5">
                <h3 class="col-12 mb-3 fuente">Registrar un Tipo de Atraccion</h3>
                
                <form class="row g-3 needs-validation" action="/TurismoEnLaTierraMedia2021WebApp/tipo/crear.adm" method="post" novalidate>
                    <div class="col-md-12">
                      <label for="tipo" class="form-label">Tipos</label>
                      <input type="text" class="form-control" id="tipo" name="tipo" placeholder="Terror" required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
          
                    <div class="col-12">
                      <button class="btn  btn-miPrincipal" type="submit">Registrarse</button>
                    </div>
                  </form>
            </div>
			
		</section>
	</div>
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>