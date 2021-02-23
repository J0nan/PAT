# [Programación de aplicaciones telemáticas - 3º GITT](https://github.com/J0nan/PAT)


***

## Práctica 2:

[Link](https://j0nan.github.io/PAT/Practica2)

Web utilizando frameworks de estilo y css. 
La funcionalidad de la web no esta completa, es más una version _dummy_ de una idea que me dio mi jefe en la beca de colaboracion

***
## Práctica 3:

[Link](https://j0nan.github.io/PAT/Practica3)

La web ahora saca el contenido de archivos txt y de la página de Collaborate.

El menú principal lo lee de un txt que se encuentra dentro de la carpeta `res`, este se llama `contenido.txt` en el cada linea pertenecerá a una opción del menu. En dicha pantalla los botones redirigirán a `instruccion.html`  el cual se encuentra en la carpeta `src`. 

El archivo `instruccion.html` recibe por parametro, el nombre del botón que fue pulsado y el número de paso, al inicio es siempre 1. A continuación en la carpeta `res` buscará una carpeta con el nombre tal cual el recibido por parametro. En dicha carpeta buscará un archivo `pasos.txt` el cual poseerá el comportamiento a cargar por el html.

Los pasos de `pasos.txt` deberán ser codificados de la siguiente manera:

