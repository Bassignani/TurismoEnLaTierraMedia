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

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Usuarios</h1>
		</div>


		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Monedas</th>
					<th>Tiempo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="tmp_user">
					<tr>
						<td><strong><c:out value="${tmp_user.nombre}"></c:out></strong></td>
						<td><c:out value="${tmp_user.monedas}"></c:out></td>
						<td><c:out value="${tmp_user.tiempo_disponible}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
            
            
            
            
                <!-- <table class="table">
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
                    <tr>
                        <th scope="row">1</th>
                        <td id="foto"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Usuarios/1_Eowyn_profile.png" id="fotodashboard" alt="Foto"></td>
                        <td>1</td>
                        <td><a href="usuario_detalle.html">Eowyn</a></td>
                        <td>Aventura</td>
                        <td>10</td>
                        <td>8</td>
                        <td>
                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
                            </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td id="foto"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Usuarios/2_Gandalf_profile.png" id="fotodashboard" alt="Foto"></td>
                        <td>2</td>
                        <td>Gandalf</td>
                        <td>Paisaje</td>
                        <td>100</td>
                        <td>5</td>
                        <td>
                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td id="foto"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Usuarios/3_Sam_profile.png" id="fotodashboard" alt="Foto"></td>
                        <td>3</td>
                        <td>Sam</td>
                        <td>Degustación</td>
                        <td>36</td>
                        <td>8</td>
                        <td>
                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
                        </td>
                    </tr>        
                    </tbody>
                </table>
            </div>
            <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/registrar.jsp">Agregar Usuario</a> -->
    </div>
        
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
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>