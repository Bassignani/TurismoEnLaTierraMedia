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
                
                <form class="row g-3 needs-validation" action="/TurismoEnLaTierraMedia2021WebApp/promocion/registrarPaso2.adm" method="post" novalidate>
                    	
                    	<div class="col-md-4">
                      <label for="nombre" class="form-label">Nombre</label>
                      <input type="text" class="form-control" id="nombre" name="nombre" value="<c:out value="${nombre}"></c:out>" required readonly>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>

                    <div class="col-md-4">
                      <label for="tipo" class="form-label">Tipo de Atracciones</label>
                    <input type="text" class="form-control" id="tipo" name="tipo" value="<c:out value="${tipo.getId()}"></c:out>" required readonly>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>

                    <div class="col-md-4">
                        <label for="tipo_promo" class="form-label">Tipo de Promocion</label>
                        <input type="text" class="form-control" id="tipo_promo" name="tipo_promo" value="<c:out value="${tipo_promo}"></c:out>" required readonly>
                        <div class="invalid-feedback">
                            Este campo es requerido.
                        </div>
                    </div>
                    
                    <div class="col-md-4">
                        <label for="path_img" class="form-label">Imagen</label>
                        <input type="text" class="form-control" name="path_img" id="imagen">
                    </div>
                    
                    <c:if test="${tipo_promo.equals('Absoluta')}">
	                    <div class="col-md-4">
	                        <label for="precio" class="form-label">Precio</label>
	                        <input type="number" class="form-control" name="precio" id="precio">
	                    </div>
                    </c:if>
                    
                    <c:if test="${tipo_promo.equals('Descuento')}">
	                    <div class="col-md-4">
	                        <label for="porcentajeDescuento" class="form-label">Porcentaje de Descuento</label>
	                        <input type="number" class="form-control" name="porcentajeDescuento" id="porcentajeDescuento">
	                    </div>
                    </c:if>
                    
             		<div class="col-md-12">
                        <label for="description" class="form-label">Descripción</label>
						<textarea name="description" id="description" cols="30" rows="5" class="form-control" required></textarea>
                        <div class="invalid-feedback">
                          Este campo es requerido.
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div>
                            <label for="atracciones" class="form-label">Atracciones</label> 
                        </div>
                        <div class="atracciones">
                        	<c:forEach items="${atracciones}" var="tmp_atraccion">
	                        	<c:if test="${tmp_atraccion.getActive() }"> 
	                        		<input type="checkbox" id="atracciones" name="atracciones" value="${tmp_atraccion.getId()}">
                            		<label for="atracciones"><c:out value="${tmp_atraccion.getNombre()}"></c:out></label><br>
	                        	</c:if> 
                       	 	</c:forEach>
                        </div>
                    </div>  
                    
                    <c:if test="${tipo_promo.equals('AxB')}">
	                   	<div class="col-md-4">
	                   		<label for="gratis" class="form-label">Atraccion Gratis</label>
                      		<select name="gratis" class="form-control" id="gratis">
                     			<c:forEach items="${atracciones}" var="tmp_atraccion">
                        			<c:if test="${tmp_atraccion.getActive() }">
                        				<option value="${tmp_atraccion.getId()}"><c:out value="${tmp_atraccion.getNombre()}"></c:out></option>
                        			</c:if>
                        		</c:forEach>
                      		</select required>
                      	<div class="invalid-feedback">
                        	Este campo es requerido.
                     	</div>                    	     
                    </c:if> 
                    
                    
                    <div class="col-12">
                      <button class="btn  btn-miPrincipal" type="submit">Guardar</button>
                    </div>
                </form>
            </div>
			
		</section>
	</div>
	
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>