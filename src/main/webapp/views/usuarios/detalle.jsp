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
        <section class="lista mt-5">
            <h2 class="fuente">Usuario</h2>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Foto</th>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Preferencia</th>
                        <th scope="col">Dinero disp</th>
                        <th scope="col">Tirmpo disp</th>
                        <th scope="col">Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td id="foto"><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Usuarios/1_Eowyn_profile.png" id="fotodashboard" alt="Foto"></td>
                        <td>1</td>
                        <td>Eowyn</td>
                        <td>Aventura</td>
                        <td>10</td>
                        <td>8</td>
                        <td>Editar / Eliminar</td>
                    </tr>
                    <tr>
                        
                    </tr>
                    <tr>
                       
                    </tr>        
                    </tbody>
                </table>
            </div>
            <a class="btn  btn-miPrincipal" href="#">Agregar Usuario</a>
        </section> 
    </div>
	
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>
	
</body>
	<script src="/TurismoEnLaTierraMedia2021WebApp/assets/javascript/main.js"></script>
</html>