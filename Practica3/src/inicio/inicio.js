function cargar_apartados(ruta){
    fetch(ruta)
    .then(response => response.text())
    .then(contenido => {
        const lista = document.getElementById("lista");
        const filas = contenido.split('\n');
        filas.forEach(fila => {
            let a = document.createElement("a");
            fila = fila.replace(/[\r\n]+/gm, "" );
            a.setAttribute('href',encodeURI(`./src/instruccion.html?titulo=${fila}&paso=1`));
            a.setAttribute('class',"list-group-item list-group-item-action");
            a.textContent = fila
            lista.appendChild(a)
            console.log(fila)
        });
    });
}