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
                <h3 class="col-12 mb-3 fuente">Crear una Promoción</h3>
                
                <form class="row g-3 needs-validation" action="/TurismoEnLaTierraMedia2021WebApp/promocion/registrarPaso1.adm" method="post" novalidate>
                    
                    <div class="col-md-4">
                      <label for="nombre" class="form-label">Nombre</label>
                      <input type="text" class="form-control" id="nombre" placeholder="" name="nombre" required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>

                    <div class="col-md-4">
                      <label for="tipo" class="form-label">Tipo de Atracciones</label>
                      <select name="tipo" class="form-control" id="tipo">
                     	<c:forEach items="${tipos}" var="tmp_tipo">
                        	<c:if test="${tmp_tipo.getActive() }"> 
                        		<option value="${tmp_tipo.getId()}"><c:out value="${tmp_tipo.getNombre()}"></c:out></option>
                        	</c:if> 
                        </c:forEach>
                      </select required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>

                    <div class="col-md-4">
                        <label for="tipo_promo" class="form-label">Tipo de Promocion</label>
                        <select name="tipo_promo" class="form-control" id="tipo_promo">
                            <option value="AxB">AxB</option>
                            <option value="Absoluta" selected>Absoluta</option>
                            <option value="Descuento">Descuento</option>
                        </select required>
                        <div class="invalid-feedback">
                            Este campo es requerido.
                        </div>
                    </div>

                    <div class="col-12">
                      <button class="btn  btn-miPrincipal" type="submit">Siguiente</button>
                    </div>
                </form>
            </div>
			
		</section>
	</div>
	
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>