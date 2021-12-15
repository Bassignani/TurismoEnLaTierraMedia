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

	
	<div class="flex container lista mt-5">
        <h2 class="fuente text-ceter">Usuarios</h2> 
            <div class="table-responsive">
            
            
            
            <c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
					<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

				<table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Foto</th>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Preferencia</th>
                        <th scope="col">Dinero disp</th>
                        <th scope="col">Tiempo disp</th>
                        <th scope="col">Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${usuarios}" var="tmp_user">
	                    <c:if test="${tmp_user.getActive()}">
		                    <tr>
		                    	
		                        <th scope="row">1</th>
		                        <td id="foto"><img src="<c:out value="${tmp_user.getPathImg()}"></c:out>"  id="fotodashboard" alt="Foto"></td>
		                        <td><c:out value="${tmp_user.id}"></c:out></td>
		                        <td><a href="usuario_detalle.html"><c:out value="${tmp_user.nombre}"></c:out></a></td>
		                        <td><c:out value="${tmp_user.tipoDeAtraccion}"></c:out></td>
		                        <td><c:out value="${tmp_user.presupuesto}"></c:out></td>
		                        <td><c:out value="${tmp_user.tiempoDisponible}"></c:out></td>
		                        <td>
		                            <a href="/TurismoEnLaTierraMedia2021WebApp/usuario/editar.adm?id=${tmp_user.id}"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
		                            <a href="/TurismoEnLaTierraMedia2021WebApp/usuario/borrar.adm?id=${tmp_user.id}" ><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
		                        	<!-- data-bs-toggle="modal" data-bs-target="#eliminar" -->
		                        </td>
		                    </tr>
	                    </c:if>
	                    
	                    <!-- Modal -->
    <div class="modal fade" id="eliminar" tabindex="-1" aria-labelledby="ModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-miPrincipal">
            <h5 class="modal-title" id="ModalLabel">Eliminar Usuario</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Esta seguro que desea eliminar a este usuario. <br>
                Una vez eliminado los cambio no podran deshacerse.
            </div>
            <div class="modal-footer">
            <button type="button" class="btn  btn-miPrincipal" data-bs-dismiss="modal">Cerrar</button>
            <button type="button" class="btn btn-danger">Eliminar</button>   
            </div>
        </div>
        </div>
    </div>
	                    
	                    
                    </c:forEach>
				</tbody>
                </table>
            </div>
            <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/usuario/crear.adm">Agregar Usuario</a>             
    </div>
        
      
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>