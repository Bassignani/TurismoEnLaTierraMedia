<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<nav class="navbar navbar-expand-lg navbar-dark bg-miPrincipal fixed-top">
		<div class="container-fluid">
			<a href="/TurismoEnLaTierraMedia2021WebApp/index.jsp"><img class="logo1" src="/TurismoEnLaTierraMedia2021WebApp/assets/img/Varios/Unico_Anello.png" alt="Logo"></a> 
			<a class="navbar-brand fuente" href="/TurismoEnLaTierraMedia2021WebApp/index.jsp">Turismo en la Tierra Media</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end align-items-center" id="navbarNavDropdown">
				<ul class="navbar-nav">					
					<li>
						<audio autoplay controls loop id="myaudio"> 
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
					<li class="nav-item"><a class="nav-link" aria-current="page" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/login.jsp">Iniciar Sesión</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false"> 
							Nombre de Usuario 
						</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/ofertar.jsp">Comprar</a></li>   <!--Desp se puede sacar-->
                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/itinerario.jsp">Itinerario</a></li>
                            <li><a class="dropdown-item" >Tiempo disponible<img src="Imagenes/Varios/RelojDeArena.png" style="width: 20px;" alt=""></a></li>
                            <li><a class="dropdown-item" >Monedas disponible<img src="Imagenes/Varios/GoldCoins.png" style="width: 20px;" alt=""></a></li>
                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/views/usuarios/dashboard.jsp">Panel de admin</a></li>   <!-- Se ven unicamente si sos admin -->
                            <li><a class="dropdown-item" href="/TurismoEnLaTierraMedia2021WebApp/index.jsp">Cerrar sesion</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>