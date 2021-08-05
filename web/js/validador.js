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


    if (usuario === "" || contrasenia === "" || nombre === "" || apellido === "" || dni === "" || direccion === "" || fechaNac === "" || cargo === "") {
        //verifico que todos los campos contengan datos
        alert("Todos los campos deben estar completos");
        return false;
    } else if(calcularEdad(fechaNac)<18){ //verifico si es mayor de 18 años
        alert("Revise la fecha de nacimiento. El empleado debe ser mayor de 18 años");
        return false;
      }
   
}

//permite calcular la edad para verificar si la persona es mayor de 18 años
function calcularEdad(fechaNac) {
  let hoy = new Date();
  let fechaNacimiento = new Date(fechaNac);
  let edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
  let diferenciaMeses = hoy.getMonth() - fechaNacimiento.getMonth();
  if (diferenciaMeses < 0 || (diferenciaMeses === 0 && hoy.getDate() < fechaNacimiento.getDate())) {
    edad--;
    }
  return edad;
}

