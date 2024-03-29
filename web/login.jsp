<%-- 
    Document   : login
    Created on : 28 jul. 2021, 09:33:08
    Author     : Caro
--%>



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
        <header>
            <h1 class="site-heading text-center text-faded d-none d-lg-block">
                <span class="site-heading-upper text-primary mb-3">Hotel</span>
                <span class="site-heading-lower">Integrador</span>
            </h1>
        </header>

        <section class="page-section cta">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto">
                        <div class="cta-inner bg-faded text-center rounded">
                            <h2 class="section-heading mb-4">
                                <!--<span class="section-heading-upper">Nueva Reserva</span>-->
                                <span class="section-heading-lower">Iniciar Sesi�n:</span>
                            </h2>

                            <form name="formlogin" class="border p-3 form" action="SvLogin" method="POST">
                                <br>
                                <p>
                                    <label for = "nombreUsuario" class="form-label wrap-input100 validate-input" data-validate = "Ingres� un e-mail v�lido: ejemplo@abc.xyz">Usuario:</label> 
                                    <input type="text"  class="form-control" name="nombreUsuario" required>
                                </p>
                                <p>
                                    <label for = "contraUsuario" class="form-label wrap-input100 validate-input"  data-validate = "Debe ingresar su contrase�a">Contrase�a:</label> 
                                    <input type="password"  class="form-control" name="contraUsuario" required>
                                </p>
                                <br>  
                                <div class="intro-button mx-auto">
                                    <input type="submit" name="btnIngresar" class="btn btn-primary btn-xl" value="Ingresar"> 
                                </div> 
                            </form>
                        </div>
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

    </body>
</html>



