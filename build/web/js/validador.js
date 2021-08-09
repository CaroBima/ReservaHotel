function validarEmpleado() {
    var usuario, contrasenia, nombre, apellido, dni, direccion, fechaNac, cargo;

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
    if (calcularEdad(fechaNac) < 18) {
        alert("Revise la fecha de nacimiento. El empleado debe ser mayor de 18 a\u00f1os");
        return false;
    }
}



//validacion de los datos del alta de una nueva habitacion
function validarHabitacion() {
    var tipoHab, nombreTematico, precioHab, pisoHabitacion, nroHabit;

    //traigo los datos para validarlos
    tipoHab = document.frmAltaHabitacion.tipoHabitacion.value;
    nombreTematico = document.frmAltaHabitacion.nombreTematico.value;
    precioHab = document.frmAltaHabitacion.precioHabitacion.value;
    pisoHabitacion = document.frmAltaHabitacion.pisoHabitacion.value;
    nroHabit = document.frmAltaHabitacion.nroHabitacion.value;

    //compruebo que todos los campos esten completos
    if (tipoHab === "" || nombreTematico === "" || precioHab === "" || pisoHabitacion === "" || nroHabit === "") {
        alert("Todos los campos deben estar completos");
        return false;
    }

    //compruebo que el precio este escrito en números y separado por punto
    if (isNaN(precioHab)) {
        alert("El precio debe estar expresado en n\u00fameros. En caso de tener decimales, sep\u00e1relos con punto y no con coma");
        return false;
    }

    //verifico que se haya seleccionado el piso
    if (pisoHabitacion === "-") {
        alert("Debe seleccionar el piso de la habitaci\u00f3n");
        return false;
    }

    //verifico que se haya seleccionado el número de habitación
    if (nroHabit === "-") {
        alert("Debe seleccionar el n\u00famero de habitaci\u00f3n");
        return false;
    }


}

//verifico que la cantidad de huespedes no supere la capacidad de la habitacion
function verificarCantHuespXReserva(cantPersonas) {
    //traer los textos del select, buscar con indexOf si tienen single, double,
    // etc y comparar de acuerdo a eso con la cant de huespedes ingresada
    /* Para obtener el texto del select donde esta el precio */

    var capacidad; //para guardar la capacidad seleccionada
    var comboCap = document.formAltaReserva.habitacionReserva;
    var seleccionado = comboCap.options[comboCap.selectedIndex].text; //recupero el texto del select

    if (seleccionado.indexOf('Single')) {
        capacidad = 1;
    } else if (seleccionado.indexOf('Doble')) {
        capacidad = 2;
    } else if (seleccionado.indexOf('Triple')) {
        capacidad = 3;
    } else if (seleccionado.indexOf('Múltiple')) {
        capacidad = 8;
    }

    alert(capacidad + " " + cantPersonas);

    if (cantPersonas > capacidad) {
        alert('La cantidad de personas supera la capacidad de la habitacion');
        return false;
    }
    if (cantPersonas <= capacidad) {
        return true;
    }


}



//calcula el monto total de la reserva
function calcularMontoTotal(fCheckin, fCheckout) {

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

//permite comparar entre dos fechas, para ver si la fecha 1 es anterior a la segunda
function compararFechas(fecha, fecha2) {
    var xMonth = fecha.substring(3, 5);
    var xDay = fecha.substring(0, 2);
    var xYear = fecha.substring(6, 10);
    var yMonth = fecha2.substring(3, 5);
    var yDay = fecha2.substring(0, 2);
    var yYear = fecha2.substring(6, 10);
    if (xYear > yYear)
    {
        return(true);
    } else
    {
        if (xYear === yYear)
        {
            if (xMonth > yMonth)
            {
                return(true);
            } else
            {
                if (xMonth === yMonth)
                {
                    if (xDay > yDay)
                        return(true);
                    else
                        return(false);
                } else
                    return(false);
            }
        } else
            return(false);
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
