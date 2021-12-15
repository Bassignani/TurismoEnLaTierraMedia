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
                      <input type="text" class="form-control" id="nombre" name="nombre" value="<c:out value="${tmp_user.nombre}"></c:out>" required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
                    <div class="col-md-4">
                      <label for="presupuesto" class="form-label">Dinero</label>
                      <input type="number" class="form-control" name="presupuesto" id="presupuesto" value="<c:out value="${tmp_user.presupuesto}"></c:out>"  required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>                    
                    <div class="col-md-4">
                      <label for="tiempoDisponible" class="form-label">Tiempo</label>                                         
                       <input type="number" class="form-control" id="tiempoDisponible" name="tiempoDisponible" value="<c:out value="${tmp_user.tiempoDisponible}"></c:out>" aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Este campo es requerido.
                          </div>
                    </div>
                    <div class="col-md-4">
                      <label for="admin" class="form-label">Permisos</label>                     
                      <select class="form-control" id="admin" name="admin"> 
                      <c:choose>
	                      <c:when test="${tmp_user.getAdmin()}">             
	                        <option value="true" selected>Administrador</option>
	                        <option value="false" >Usuario</option>
	                      </c:when>   
	                      <c:otherwise>
	                      	<option value="true">Administrador</option>
	                        <option value="false" selected>Usuario</option>
	                      </c:otherwise>
                      </c:choose>                     
                      </select required>
                      <div class="invalid-feedback">
                        Este campo es requerido
                      </div>
                    </div> 
                   <div class="col-md-4">
                      <label for="tipoDeAtraccion" class="form-label">Tipo de Atracciones</label>
                      <select name="tipoDeAtraccion" class="form-control" id="tipoDeAtraccion">
                     	<c:forEach items="${tipos}" var="tmp_tipo">
                        <option value="${tmp_tipo.getId()}"><c:out value="${tmp_tipo.getNombre()}"></c:out></option>
                        </c:forEach>
                      </select required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
					<div class="col-md-4">
                        <label for="path_img" class="form-label">Imagen</label>
                        <input type="text" class="form-control" name="path_img" value="<c:out value="${tmp_user.getPathImg()}"></c:out>" id="path_img">
                    </div>
                    <div class="col-12">
                      <button class="btn  btn-miPrincipal" type="submit">Editar</button>
                    </div>
                  </form>
            </div>
			
		</section>
	</div>
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>