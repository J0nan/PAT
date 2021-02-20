function cargar_apartados(ruta){
    fetch(ruta)
        .then(response => response.text())
        .then(contenido => {
            const lista = document.getElementById("lista");
            const filas = contenido.split('\n');
            filas.forEach(fila => {
                let a = document.createElement("a");
                a.setAttribute('href',encodeURI(`./src/instruccion.html?titulo=Hola`)); //${fila}
                a.setAttribute('class',"list-group-item list-group-item-action");
                a.textContent = fila
                lista.appendChild(a)
                console.log(fila)
            });
        });
}