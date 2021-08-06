function validarEmpleado() {
    var usuario, contrasenia, nombre, apellido, dni, direccion, fechaNac, cargo, expresion;

    //traigo los datos del formulario
    usuario = document.formAltaEmple.usuarioEmpleado.value;
    contrasenia = document.formAltaEmple.contraseniaEmpleado.value;
    nombre = document.formAltaEmple.nombreEmpleado.value;
    apellido = document.formAltaEmple.apellidoEmpleado.value;
    dni = document.formAltaEmple.dniEmpleado.value;
    direccion = document.formAltaEmple.direccionEmpleado.value;
    fechaNac = document.formAltaEmple.fechaNacEmpleado.value;
    cargo = document.formAltaEmple.cargoEmpleado.value;

    //verifico que todos los campos contengan datos
    if (usuario === "" || contrasenia === "" || nombre === "" || apellido === "" || dni === "" || direccion === "" || fechaNac === "" || cargo === "") {
        alert("Todos los campos deben estar completos");
        return false;
    } 
    
    //verifico si es mayor de 18 años
    if(calcularEdad(fechaNac)<18){ 
        alert("Revise la fecha de nacimiento. El empleado debe ser mayor de 18 a\u00f1os");
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

//validacion de los datos del formulario de alta de una reserva
function validarReserva(){
    var nombre, apellido, dni, fNacim, direccion, profesion, cantPersonas, habitacion, fCheckin, fCheckout;
    
    //recupero los datos del jsp de alta de reserva
    nombre = document.formAltaReserva.nombreHuesped.value;
    apellido = document.formAltaReserva.apellidoHuesped.value;
    dni = document.formAltaReserva.dniHuesped.value;
    fNacim = document.formAltaReserva.fechaNacHuesped.value;
    direccion = document.formAltaReserva.direccionHuesped.value;
    profesion = document.formAltaReserva.profesionHuesped.value;
    cantPersonas = document.formAltaReserva.cantidadPersonas.value;
    habitacion =  document.formAltaReserva.habitacionReserva.value;
    fCheckin = document.formAltaReserva.fechaCheckIn.value;
    fCheckout = document.formAltaReserva.fechaCheckOut.value;
    
    //compruebo que no queden campos vacíos
    if( nombre === "" || apellido === "" || dni === "" || fNacim === "" || direccion === "" || profesion === "" || cantPersonas === "" || habitacion === "" || fCheckin === "" || fCheckout === "") {
        alert("Todos los campos deben estar completos");
        return false;
    }
    
    //compruebo que se haya seleccionado una habitación
    if(habitacion === "-"){
        alert("Debe seleccionar una habitaci\u00f3n");
        return false;
    }
    
    //compruebo que se encuentre selecionada la cantidad de personas que se van a hospedar
     if(cantPersonas === "-"){
        alert("Debe seleccionar la cantidad de personas que se van a hospedar");
        return false;
    }
      
        
   //verifico si es mayor de 18 años para poder ser titular de la reserva
    if(calcularEdad(fNacim)<18){ 
        alert("Debe tener al menos 18 a\u00f1os para poder ser titular de la reserva");
        console.log(fNacim);
        return false;
    }
}

//validacion de los datos del alta de una nueva habitacion
function validarHabitacion(){
    var tipoHab, nombreTematico, precioHab, pisoHabitacion, nroHabit; 
    
    //traigo los datos para validarlos
    tipoHab = document.frmAltaHabitacion.tipoHabitacion.value;
    nombreTematico = document.frmAltaHabitacion.nombreTematico.value;
    precioHab = document.frmAltaHabitacion.precioHabitacion.value;
    pisoHabitacion = document.frmAltaHabitacion.pisoHabitacion.value;
    nroHabit = document.frmAltaHabitacion.nroHabitacion.value;
    
    //compruebo que todos los campos esten completos
    if(tipoHab==="" || nombreTematico ==="" || precioHab ==="" || pisoHabitacion ==="" || nroHabit ===""){
        alert("Todos los campos deben estar completos");
        return false;
    }
    
    //compruebo que el precio este escrito en números y separado por punto
    if(isNaN(precioHab)){
        alert("El precio debe estar expresado en n\u00fameros. En caso de tener decimales, separarlos con punto y no con coma");
        return false;
    }
    
    //verifico que se haya seleccionado el piso
    if(pisoHabitacion === "-"){
        alert("Debe seleccionar el piso de la habitaci\u00f3n");
        return false;
    }
    
    //verifico que se haya seleccionado el número de habitación
    if(nroHabit === "-"){
        alert("Debe seleccionar el n\u00famero de habitaci\u00f3n");
        return false;
    }

}
