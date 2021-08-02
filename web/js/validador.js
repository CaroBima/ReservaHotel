function validarEmpleado() {
    var usuario, contrasenia, nombre, apellido, dni, direccion, fechaNac, cargo, expresion;
    
    
    usuario = document.formAltaEmple.usuarioEmpleado.value;
    contrasenia = document.formAltaEmple.contraseniaEmpleado.value;
    nombre = document.formAltaEmple.nombreEmpleado.value;
    apellido = document.formAltaEmple.apellidoEmpleado.value;
    dni = document.formAltaEmple.dniEmpleado.value;
    direccion = document.formAltaEmple.direccionEmpleado.value;
    fechaNac = document.formAltaEmple.fechaNacEmpleado.value;
    cargo = document.formAltaEmple.cargoEmpleado.value;
    
    if(usuario === "" || contrasenia === "" || nombre ==="" || apellido ==="" || dni ==="" || direccion ==="" || fechaNac ==="" || cargo ==="") {
        alert("Todos los campos deben estar completos");
        return false;
    }
}


