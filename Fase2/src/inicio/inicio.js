function cargar_apartados(ruta, intentado=0){
    fetch(ruta)
    .then(response => response.text())
    .then(contenido => {
        const lista = document.getElementById("lista");
        const filas = contenido.split('\n');
        filas.forEach(fila => {
            let a = document.createElement("a");
            fila = fila.replace(/[\r\n]+/gm, "" ); //Contine tanto el titulo como el HTML si lo hubiera
            linea_separada = fila.split('['); //Separamos el titulo con el HTML
            if (linea_separada.length==1) {
                a.setAttribute('href',encodeURI(`./src/instruccion.html?titulo=${linea_separada}&paso=1`));
            } else {
                nombre_html=linea_separada[1].substr(0,linea_separada[1].indexOf(']'))
                if(nombre_html==""||nombre_html.substr(-5)!=".html"){
                    console.error("Sintaxis del contenido erroneo en la linea: "+fila)
                } else {
                    parametros=linea_separada[1].split('<=')[1];
                    if (parametros!=undefined) {
                        //Hay parametros
                        a.setAttribute('href',encodeURI(`./src/${nombre_html}?${parametros}`));
                    } else {
                        a.setAttribute('href',encodeURI(`./src/${nombre_html}?titulo=${linea_separada[0]}`));
                    }
                    console.log(parametros)
                }
            }
            a.setAttribute('class',"list-group-item list-group-item-action");
            a.textContent = linea_separada[0]
            lista.appendChild(a)
            // console.log(linea_separada[0])
        });
    })
    .catch(e => {
        console.error("Error "+e);
        if( intentado == 0){
            console.warn("Probando con ruta completa al archivo de contenido: https://j0nan.github.io/PAT/Practica3/res/contenido.txt");
            cargar_apartados('https://j0nan.github.io/PAT/Fase2/res/contenido.txt',1)
        }
    });
}