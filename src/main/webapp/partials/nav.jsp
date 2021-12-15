<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<nav class="navbar navbar-expand-lg navbar-dark bg-miPrincipal fixed-top">
		<div class="container-fluid">
			<a href="/TurismoEnLaTierraMedia2021WebApp/index"><img class="logo1" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/Unico_Anello.png" alt="Logo"></a> 
			<a class="navbar-brand fuente" href="/TurismoEnLaTierraMedia2021WebApp/index">Turismo en la Tierra Media</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end align-items-center" id="navbarNavDropdown">
				<ul class="navbar-nav">					
					<li>
						<audio  controls loop id="myaudio">  <!-- autoplay -->
							<source src="/TurismoEnLaTierraMedia2021WebApp/assets/sounds/The Hobbit Main Theme.mp3" type="audio/mp3">  
						</audio>                                
					</li>
					<div class=cambiaTema>
						<li>
							<div class="themeChanger">
								<img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/1GandalfIcon.png" alt="Modo claro"
										class="logo">
							</div>
						</li>
						<li>
							<div>
								<input type="checkbox" class="checkbox" id="chk" /> <label
									class="label" for="chk">
									<div class="ball"></div>
								</label>
							</div>
						</li>
						<li>
							<div class="themeChanger">	
									<img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/1AngmarIcon.png" alt="Modo oscuro"
										class="logo">
							</div>
						</li>
					</div>
					<c:if test="${usuario == null}">
						<li class="nav-item"><a class="nav-link" aria-current="page" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/login.jsp">Iniciar Sesión</a></li>
					</c:if>
					
					<c:if test="${usuario != null}">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false"> 
								<c:out value="${usuario.nombre}"></c:out>
							</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="left: -95%">
	                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/vendibles/ofertar.do?id=${usuario.getId()}">Comprar</a></li>   <!--Desp se puede sacar-->
	                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/itinerario.jsp">Itinerario</a></li>
	                            <li><a class="dropdown-item" ><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/RelojDeArena.png" style="width: 20px; margin-right: 6px; margin-left: 5px" alt=""><c:out value="${usuario.getTiempoDisponible()}"></c:out></a></li>
	                            <li><a class="dropdown-item" ><img src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/GoldCoins.png" style="width: 30px; margin-right: 0px" alt=""><c:out value="${usuario.getPresupuesto()}"></c:out></a></li>
	                            <c:if test="${usuario.getAdmin()}">
	                            	<li><a class="dropdown-item" href="dashboard.adm">Panel de admin</a></li>   <!-- Se ven unicamente si sos admin  /TurismoEnLaTierraMedia2021WebApp/views/usuarios/dashboard.jsp-->
	                            </c:if>
	                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/usuario/logout">Cerrar sesion</a></li>
							</ul>
						</li>				
					</c:if>
					
					
				</ul>
			</div>
		</div>
	</nav>