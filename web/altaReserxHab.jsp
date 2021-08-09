<%-- 
    Document   : altaReserxHab
    Created on : 7 ago. 2021, 11:41:47
    Author     : Caro
--%>

<%@page import="Logica.Huesped"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="assets/hotel.svg" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Nueva reserva</title>
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
        <script src="js/validador.js"></script>
        <title>Nueva reserva</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String loginusuario = (String) sesion.getAttribute("usuario");

            //verifico si el usuario admin esta creado y si no lo agrego
            if (loginusuario == null) {
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
                                <span class="section-heading-lower">Nueva Reserva</span>
                            </h2>

                            <!-- Formulario de reserva -->
                            <form name="formAltaReserva"  class="border p-3 form" action="SvGuardarReserva" method="POST" >
                                <!-- Recupero los datos de la sesion, Muestro los datos de reserva seleccionados y las habitaciones disponibles para esas fechas -->
                                <%                                    HttpSession misesion = request.getSession();
                                    List<Habitacion> listaHabitacion = (List) misesion.getAttribute("listaHabitaciones");
                                    String fChekIn = (String) misesion.getAttribute("fechaCheckIn");
                                    String fChekOut = (String) misesion.getAttribute("fechaCheckOut");
                                    String cantPers = (String) misesion.getAttribute("cantidadPersonas");
                                    List<Huesped> listaHuespedes = (List) misesion.getAttribute("listaHuespedes");
                                    Habitacion habitacion = new Habitacion();

                                %>
                                <div class="row">
                                    <div class="col">
                                        <label for = "fCheckIn" class="form-label" >CheckIn: </label>
                                        <input type="text" class="form-control" name="fCheckIn" value="<%=fChekIn%>" disabled>
                                    </div>

                                    <!-- Ingreso del apellido -->
                                    <div class="col">
                                        <label for = "fCheckOut" class="form-label" >CheckOut: </label>
                                        <input type="text" class="form-control" name="fCheckOut" value="<%=fChekOut%>" disabled>
                                    </div>


                                </div>
                                <div class="row"> 
                                    <div class="col">
                                        <label for = "cantPers" class="form-label" >Personas: </label>
                                        <input type="text" class="form-control" name="cantPers" value="<%=cantPers%>" disabled>
                                    </div>
                                    <div class="col">
                                        <!-- Seleccion de habitación que se va a reservar -->
                                        <label for = "habitacionReserva" class="form-label">Habitaciones:</label> 
                                        <select name ="habitacionReserva" class="form-control">
                                            <option value="-">-</option>
                                            <%
                                                for (int i = 0; i < listaHabitacion.size(); i++) {
                                                    habitacion = listaHabitacion.get(i);
                                                    out.println("<option value=\"" + habitacion.getIdHabitacion() + "\" " + ">" + habitacion.getNombreTematica() + " - " + habitacion.getTipoHab() + " - $" + habitacion.getPrecioHabitacion() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <!--ingreso los datos del cliente-->
                                <label for = "seleccionHuesped" class="form-label">Huesped:</label> 
                                <select name ="seleccionHuesped" class="form-control">
                                    <option value="-">-</option>
                                    <%
                                        Huesped huesped = new Huesped();
                                        for (int i = 0; i < listaHuespedes.size(); i++) {
                                            huesped = listaHuespedes.get(i);
                                            out.println("<option value=\"" + huesped.getIdPersona() + "\" " + ">" + huesped.getNombre() + " " + huesped.getApellido() + " - " + huesped.getDni() + "</option>");
                                        }
                                    %>
                                </select>

                                <br>   
                                <!-- Boton de guardado -->   
                                <div class="row"> 
                                    <div class="intro-button mx-auto">
                                        <input type="submit" name="btnGuardar" class="btn btn-primary btn-xl" value="Guardar" onclick ="return validarNuevaRes();"> 
                                    </div>    
                                </div>
                            </form>
                            <script>
                                function validarNuevaRes() {
                                    var seleccHues, habres;

                                    habres = document.formAltaReserva.habitacionReserva.value;
                                    seleccHues = document.formAltaReserva.seleccionHuesped.value;
                                    fCheckin = document.formAltaReserva.fCheckIn.value;
                                    fCheckout = document.formAltaReserva.fCheckOut.value;

                                    if (seleccHues === "-") {
                                        alert("Debe seleccionar el huesped");
                                        return false;
                                    }

                                    if (habres === "-") {
                                        alert("Debe seleccionar la habitaci\u00f3n");
                                        return false;
                                    }

                                    /* Para obtener el texto del select donde esta el precio */
                                    var combo = document.formAltaReserva.habitacionReserva;
                                    var seleccionado = combo.options[combo.selectedIndex].text; //recupero el texto del select

                                    var regex = /(\d+)/g; // para obtener solo los numeros del string 
                                    var valorHab = seleccionado.match(regex); //obtengo los numeros del string

//obtendo los tiempos en milisengundos para poder restarlos
                                    var ingreso = new Date(fCheckin).getTime();
                                    var salida = new Date(fCheckout).getTime();

                                    var diferencia = salida - ingreso; //me da el tiempo en milisegundos
                                    var dias = diferencia / (1000 * 60 * 60 * 24); //calculo la cantidad  de dias

                                    var montototal = dias * parseInt(valorHab); //calculo el monto total

                                    opcion = confirm("El monto total de la reserva es de $" + montototal + ". ¿Desea generar la reserva?.");

                                    return opcion;
                                }
                            </script>
                            </section>
                            <footer class="footer text-faded text-center py-5">
                                <div class="container"><p class="m-0 small">Copyright &copy; Hotel Integrador 2021</p></div>
                            </footer>

                            <!-- Bootstrap core JS-->
                            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
                            <!-- Core theme JS-->
                            <script src="js/scripts.js"></script>
                            <%            }
                            %>
                            </body>
                            </html>
