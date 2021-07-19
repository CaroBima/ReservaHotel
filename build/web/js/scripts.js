//funcion que permite abrir la ventana para agregar un nuevo campo en la base de datos, centrandola en la pantalla
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
