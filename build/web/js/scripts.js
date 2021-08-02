//funcion que permite abrir la ventana para agregar un nuevo campo en la base de datos, 
//centrandola en la pantalla, la use para agregar puesto primero pero no podia actualizar el cbobox
function abrirVentana(url, title, w, h)
{
    var dualScreenLeft = window.screenLeft !== undefined ? window.screenLeft : window.screenX;
    var dualScreenTop = window.screenTop !== undefined ? window.screenTop : window.screenY;

    var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
    var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

    var left = ((width / 2) - (w / 2)) + dualScreenLeft;
    var top = ((height / 2) - (h / 2)) + dualScreenTop;
    var newWindow = window.open(url, title, 'scrollbars= off, resizable= off, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);

    // pone el foco en la ventana que se abre
    if (window.focus) {
        newWindow.focus();
    }
}

//permite ingresar un nuevo cargo en el combobox que esta en el formulario de empleado
function ingresoCargo() {
    let nuevoCargo = prompt('Ingrese el nuevo cargo: ', );


    var opcion = document.formAltaEmple.cargoEmpleado;

    //verifico que se ingrese algun valor, que no quede en null
    if (nuevoCargo.length > 0) {
        //creo y asigno el nuevo cargo a la opcion que voy a agregar al select
        var nuevaopcion = document.createElement("option");
        nuevaopcion.value = nuevoCargo;
        nuevaopcion.text = nuevoCargo;
        nuevaopcion.selected = nuevoCargo;

        opcion.appendChild(nuevaopcion); // agrego la nueva opcion al combobox
    }
}

function cargarFechas() {
    var fechaHoy = new Date(); //Fecha actual
    var mes = fechaHoy.getMonth() + 1; //mes actual
    var dia = fechaHoy.getDate(); //obteniendo dia
    var anio = fechaHoy.getFullYear(); //obteniendo año
    if (dia < 10)
        dia = '0' + dia; //agrega cero si es menor de 10
    if (mes < 10)
        mes = '0' + mes; //agrega cero si es menor de 10

document.formAltaReserva.fechaCheckIn.value = (dia + "-" + mes + "-" + anio);
document.formAltaReserva.fechaCheckOut.value = (dia + "-" + mes + "-" + anio);

}

