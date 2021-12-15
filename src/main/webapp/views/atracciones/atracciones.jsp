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
        <h2 class="fuente text-ceter">Atracciones</h2>
           <div class="table-responsive">
               <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Costo</th>
                        <th scope="col">Duración</th>
                        <th scope="col">Cupo</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${atracciones}" var="tmp_atraccion">
	                    <tr>
	                        <th scope="row">1</th>
	                        <td><c:out value="${tmp_atraccion.id}"></c:out></td>
	                        <td><c:out value="${tmp_atraccion.nombre}"></c:out></td>
	                        <td><c:out value="${tmp_atraccion.costo}"></c:out></td>
	                        <td><c:out value="${tmp_atraccion.duracion}"></c:out></td>
	                        <td><c:out value="${tmp_atraccion.cupo}"></c:out></td>
	                        <td><c:out value="${tmp_atraccion.getTipo().getNombre()}"></c:out></td>
	                        <td>
	                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/atracciones/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
	                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
             </div>
            <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/atraccion/crear.adm">Agregar Atracción</a>
    </div>
        
      <!-- Modal -->
    <div class="modal fade" id="eliminar" tabindex="-1" aria-labelledby="ModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-miPrincipal">
            <h5 class="modal-title" id="ModalLabel">Eliminar Atracción</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Esta seguro que desea eliminar a esta atracción. <br>
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