<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body class="light-theme">
	
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	
	<div class="flex container lista mt-5">
        <h2 class="fuente text-ceter">Promociones</h2>
           <div class="table-responsive">
               <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Id</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Tipo de promoción</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Costo</th>
                        <th scope="col">Tiempo</th>
                        <th scope="col">Atracciones</th>
                        <th scope="col">Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>1</td>
                        <td>Aventura</td>
                        <td>Descuento</td>
                        <td>Pack Aventura</td>
                        <td>30</td>
                        <td>5</td>
                        <td>
                            Bosque Negro <br>
                            Mordor
                        </td>
                        <td>
                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/promociones/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>2</td>
                        <td>Degustación</td>
                        <td>Absoluta</td>
                        <td>Pack Degustación</td>
                        <td>36</td>
                        <td>7</td>
                        <td>
                            Lothlorien <br>
                            La Comarca
                        </td>
                        <td>
                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/promociones/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>3</td>
                        <td>Paisaje</td>
                        <td>AxB</td>
                        <td>Pack Paisajes</td>
                        <td>44</td>
                        <td>9</td>
                        <td>
                            Minas Tirith <br>
                            Abismo de Helm <br>
                            Erebor
                        </td>
                        <td>
                            <a href="/TurismoEnLaTierraMedia2021WebApp/views/promociones/registrar.jsp"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/edit-regular.svg" class="edit" alt="" title="Editar"></a>   
                            <a href="#" data-bs-toggle="modal" data-bs-target="#eliminar"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/trash-alt-regular.svg" class="delete" alt="" title="Eliminar"></a>
                        </td>
                    </tr>        
                    </tbody>
                </table>
            </div>
            <a class="btn  btn-miPrincipal" href="/TurismoEnLaTierraMedia2021WebApp/views/promociones/registrar.jsp">Agregar Promocion</a>
    </div>
        
      <!-- Modal -->
    <div class="modal fade" id="eliminar" tabindex="-1" aria-labelledby="ModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-miPrincipal">
            <h5 class="modal-title" id="ModalLabel">Eliminar Promoción</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Esta seguro que desea eliminar a esta promoción. <br>
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