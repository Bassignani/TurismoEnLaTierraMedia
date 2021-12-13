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
                <h3 class="col-12 mb-3 fuente">Editar un Usuario</h3>
                
                <form class="row g-3 needs-validation" action="/TurismoEnLaTierraMedia2021WebApp/usuario/editar.adm" method="post" novalidate>
                    <div class="col-md-4">
                      <label for="nombre" class="form-label">Nombre</label>
                      <input type="text" class="form-control" id="nombre" name="nombre" value="<c:out value="${usuario.nombre}"></c:out>" required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
                    <div class="col-md-4">
                      <label for="presupuesto" class="form-label">Dinero</label>
                      <input type="number" class="form-control" name="presupuesto" id="presupuesto" value="<c:out value="${usuario.presupuesto}"></c:out>"  required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>                    
                    <div class="col-md-4">
                      <label for="tiempoDisponible" class="form-label">Tiempo</label>                                         
                       <input type="number" class="form-control" id="tiempoDisponible" name="tiempoDisponible" value="<c:out value="${usuario.tiempoDisponible}"></c:out>" aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Este campo es requerido.
                          </div>
                      </div>
                    
                    <div class="col-md-4">
                      <label for="admin" class="form-label">Admin</label>
                      <input type="text" class="form-control" id="admin" name="admin" value="<c:out value="${usuario.getAdmin()}"></c:out>" required>
                      <div class="invalid-feedback">
                        Este campo es requerido
                      </div>
                    </div>
                    <div class="col-md-4">
                      <label for="tipoDeAtraccion" class="form-label">Tipo de Atracciones</label>
                      <select name="tipoDeAtraccion" class="form-control" id="tipoDeAtraccion">
                        <option value="AVENTURA">Aventura</option>
                        <option value="DEGUSTACION" selected>Degustación</option>
                        <option value="PAISAJE">Paisaje</option>
                      </select required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
					<div class="col-md-4">
                        <label for="path_img" class="form-label">Imagen</label>
                        <input type="text" class="form-control" name="path_img" value="<c:out value="${usuario.getPathImg()}"></c:out>" id="path_img">
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