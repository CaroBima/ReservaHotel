<%@page import="Logica.Huesped"%>
<%@page import="Logica.Controladora"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="assets/hotel.svg" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Hotel Integrador</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet" />

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <!--<link rel="stylesheet" href="css/style.css">-->
        <script src="js/scripts.js"></script>
        <title>Gestion de reservas</title>
    </head>
    <body>
        <%
            HttpSession misesion = request.getSession();
            String usuario = (String) misesion.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("login.jsp");
            } else {

        %>
        <header>
            <h1 class="site-heading text-center text-faded d-none d-lg-block">
                <span class="site-heading-upper text-primary mb-3">Hotel</span>
                <span class="site-heading-lower">Integrador</span>
            </h1>
        </header>

        <!-- Menú de navegacion-->
        <nav class="navbar navbar-expand-lg navbar-dark py-lg-3" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Principal</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                    <ul class="navbar-nav">

                        <!-- Menú de Reservas-->
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Reservas
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                
                                <li><a class="dropdown-item" href="nuevaReserva.jsp">Nueva Reserva</a></li>
                                
                                <li><a class="dropdown-item" href="consultaReserva.jsp">Listado de reservas</a></li>
                                <form action="SvConsultaReservaxDia" method="GET">
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsultaReservaxDia">Buscar reserva por fecha</a></li>
                                </form>
                                <form action="SvConsResxEmp" method="GET">
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsResxEmp">Buscar reserva por empleado</a></li>
                                </form>
                                <form action="SvConsResxHuesped" method="GET">
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsResxHuesped">Buscar reserva por huésped</a></li>
                                </form>
                             
                                
                                
                            </ul>
                        </li>

                        <!-- Menú de Clientes-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Huéspedes
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="consultaClientes.jsp">Listado de huéspedes</a></li>
                               <!-- <li><a class="dropdown-item" href="modificarCliente.jsp">Editar Clientes</a></li> -->
                                
                            </ul>
                        </li>
                        
                        <!-- Menú de Habitaciones-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Habitaciones
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaHabitacion.jsp">Nueva Habitación</a></li>
                               <li><a class="dropdown-item" href="consultaHabitaciones.jsp">Listado de habitaciones</a></li>
                                <form action="SvEdicionHabitacion" method="GET">
                                    <li><a class="SUBMIT dropdown-item" href="SvEdicionHabitacion">Editar habitaciones</a></li>
                                </form>
                               
                            </ul>
                        </li>
                        
                           <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Empleados
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaEmpleado.jsp">Alta de Empleado</a></li>
                                <li><a class="dropdown-item" href="consultaEmpleados.jsp">Lista de Empleados</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <section class="page-section cta">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto">
                        <div class="cta-inner bg-faded text-center rounded">
                            <h2 class="section-heading mb-4">
                                <!--<span class="section-heading-upper">Nueva Reserva</span>-->
                                <span class="section-heading-lower">Consultar reservas</span>
                            </h2>



                            <!-- Formulario de busqueda de reserva x fecha -->
                            <form name="frmConsResxHuesped"  class="border p-3 form" action="SvConsResxHuesped" method="POST">

                                <div class="row">
                                    <div class="col">
                                        <label for = "CboHuesped" class="form-label">Seleccione el huésped:</label> 
                                        <select name ="CboHuesped" class="form-control">
                                            <option value="-">-</option>
                                            <%                                                //Cargo los huespedes en el combobox
                                                HttpSession sesion = request.getSession();

                                                List<Huesped> listaHuespedes = (List) sesion.getAttribute("listaHuespedes");
                                                Huesped huesped = new Huesped();

                                                if (listaHuespedes != null) {
                                                    for (int i = 0; i < listaHuespedes.size(); i++) {
                                                        huesped = listaHuespedes.get(i);
                                                        out.println("<option value=\"" + huesped.getIdPersona() + "\" " + ">" + huesped.getNombre() + " " + huesped.getApellido() + "</option>");

                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                   
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label for = "fechaDesde" class="form-label">Buscar desde:</label> 
                                        <input type="date"  class="form-control" id="fechaReserva" name="fechaDesde" >
                                        
                                    </div>
                                     <div class="col">
                                        <label for = "fechaHasta" class="form-label">Hasta:</label> 
                                        <input type="date"  class="form-control" id="fechaReserva" name="fechaHasta" >
                                        
                                    </div>
                                     
                                </div>  
                                   <div class="row">
                                         <div class="col">
                                        
                                        </div>
                                        <div class="col">
                                        <br>
                                        <input type="submit" id="btnBuscarxFecha" name="btnBuscarxFecha" class="btn btn-primary btn-xs" value="Buscar" onclick="return validarResxHuesped();"> 
                                        </div>
                                      
                                    </div>




                                <!-- comienzo de la tabla que muestra el listado de reservas -->
                                <div class="table-responsive">

                                    <table class="table table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <td>Nombre del cliente</td>
                                                <td>Dni</td>
                                                <td>Fecha de nacimiento</td>
                                                <td>Dirección</td>
                                                <td>Profesion</td>
                                                <td>Cat. Personas</td>
                                                <td>Habitacion</td>
                                                <td>CheckIn</td>
                                                <td>CheckOut</td>
                                                <td>Monto Total</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                //recorro la lista para cargar los valores en la tabla
                                                List<Reserva> listaReservas;
                                                listaReservas = (List) sesion.getAttribute("listaReservas");
                                                Controladora control = new Controladora();
                                                String fechaCheckIn;
                                                String fechaCheckOut;
                                                String fechaNacimiento;

                                                if (listaReservas != null) {
                                                    for (Reserva reser : listaReservas) {
                                                        //formateo las fechas para poder mostrarlas
                                                        fechaCheckIn = control.formatearFecha(reser.getFechaCheckIn());
                                                        fechaCheckOut = control.formatearFecha(reser.getFechaCheckOut());
                                                        fechaNacimiento = control.formatearFecha(reser.getHuesped().getFechaNac());
                                            %>
                                            <tr>    
                                                <td><%= reser.getHuesped().getNombre() + " " + reser.getHuesped().getApellido()%></td>
                                                <td><%= reser.getHuesped().getDni()%></td>
                                                <td><%= fechaNacimiento%></td>
                                                <td><%= reser.getHuesped().getDireccion()%></td>
                                                <td><%= reser.getHuesped().getProfesion()%></td>
                                                <td><%= reser.getCantPersonas()%></td>
                                                <td><%= reser.getIdHabitación().getNombreTematica()%></td>
                                                <td><%= fechaCheckIn%></td>
                                                <td><%= fechaCheckOut%></td>
                                                <td><%= reser.getMontoTotalReserva()%></td>
                                            </tr>
                                            <%

                                                    } //cierre del for
                                                }//cierre del if 
                                            %>

                                        </tbody>
                                    </table>
                                </div>
                                <!-- fin de la tabla de reservas -->
                            </form>

                        </div>
                    </div>
                </div>
        </section>
                                            
        <footer class="footer text-faded text-center py-5">
            <div class="container"><p class="m-0 small">Copyright &copy; Hotel Integrador 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script>
            function validarResxHuesped(){
                 huesped = document.frmConsResxHuesped.CboHuesped.value;
                 
                 
                 if(huesped ==="-"){
                     alert("Debe seleccionar un huesped");
                     return false;
                 }
                 
                 
                   //obtengo la fecha del día para validar la que se esta ingresando de checkin
                                var fechaHoy = new Date();
                                dia = '0' + fechaHoy.getDate();
                                mes = '0' + (fechaHoy.getMonth() + 1);
                                anio = fechaHoy.getFullYear();
                                fHoy = anio + '-' + mes + '-' + dia;
                                
                                  //comparo si la fecha de check in es anterior a la de check out
                                if (compararFechas(fCheckin, fCheckout)) {
                                    alert("La fecha de CheckOut no puede ser anterior al CheckIn");
                                    return false;
                                }

                                //compruebo si las fechas son iguales
                                var ingreso = new Date(fCheckin).getTime();
                                var salida = new Date(fCheckout).getTime();
                                if (ingreso === salida) {
                                    alert("La fecha de CheckIn no puede ser igual a la de CheckOut");
                                    return false;
                                }

            }
        </script>
        <%
            }
        %>
    </body>
</html>

