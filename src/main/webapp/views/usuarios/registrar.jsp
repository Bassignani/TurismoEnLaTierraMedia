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
		<section class="mt-5">

			<div class="lista text-center mt-5">
                <h3 class="col-12 mb-3 fuente">Registrar un Usuario</h3>
                <form class="row g-3 needs-validation" novalidate>
                    <div class="col-md-4">
                      <label for="nombre" class="form-label">Nombre</label>
                      <input type="text" class="form-control" id="nombre" placeholder="Frodo" required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
                    <div class="col-md-4">
                      <label for="apellido" class="form-label">Apellido</label>
                      <input type="text" class="form-control" id="apellido" value="" placeholder="Bolson" required>
                      <div class="invalid-feedback">
                        Este campo es requerido.
                      </div>
                    </div>
                    <div class="col-md-4">
                      <label for="username" class="form-label">Username</label>
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                        <input type="text" class="form-control" id="username" aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Este campo es requerido.
                          </div>
                      </div>
                    </div>
                    <div class="col-md-4">
                      <label for="validationCustom03" class="form-label">City</label>
                      <input type="text" class="form-control" id="validationCustom03" required>
                      <div class="invalid-feedback">
                        Ingrese una ciudad valida.
                      </div>
                    </div>
                    <div class="col-md-8">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="frodo@lacomarca.com" required pattern="^[^@]+@[^@]+.[a-zA-Z]{2,}$">
                        <div class="invalid-feedback">
                          Email no valido.
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="contraseña" class="form-label">Contraseña</label>
                        <input type="email" class="form-control" id="contraseña" required minlength="8" maxlength="20">
                        <div class="invalid-feedback">
                          Contraseña invalidad, debe tener entre 8 y 20 caracteres.
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="repContraseña" class="form-label">Repetir Contraseña</label>
                        <input type="email" class="form-control" id="repContraseña" required minlength="8" maxlength="20">
                        <div class="invalid-feedback">
                          La contraseña no coincide,
                        </div>
                    </div>
					<div class="col-md-4">
                        <label for="imagen" class="form-label">Imagen</label>
                        <input type="file" class="form-control" name="imagen" id="imagen">
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