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


Los pasos de `pasos.txt` deberán ser codificados de cualquiera de las tres maneras siguientes:

### Manera 1:
En esta manera, se muestra un texto y dos botones, todo cargado del txt

```
X.- String 1;String 2;String 3=>Y;Z
```
- `X` Número de paso, como por ejemplo:
    - 1
    - 2.8
    - Tercero
- `String 1` Cadena de texto con el texto principal a mostrar, como por ejemplo:
    - Apague y encienda la cámara.
    - Si esta usando Collaborate, siga los pasos del vídeo
- `String 2` Cadena de texto a mostrar en el botón **verde**, como por ejemplo:
    - SI, la cámara giro
- `String 3` Cadena de texto a mostrar en el botón **rojo**, como por ejemplo:
    - NO, la cámara NO giro
- `Y` Número de paso si se presiona el botón **verde**, como por ejemplo:
    - 1.1
    - 3
    - Tercero
    - FIN
- `Z` Número de paso si se presiona el botón **rojo**, como por ejemplo:
    - 3
    - 2.2
    - Segundo
    - FIN

### Manera 2:
En esta manera su muestra un texto cargado del txt y un boton con el texto `Siguiente paso`
```
X.- String 1=>Y
```
- `X` Número de paso, como por ejemplo:
    - 1
    - 2.8
    - Tercero
- `String 1` Cadena de texto con el texto principal a mostrar, como por ejemplo:
    - Apague y encienda la cámara.
    - Si esta usando Collaborate, siga los pasos del vídeo
- `Y` Número de paso si se presiona el botón, como por ejemplo:
    - 1.1
    - 3
    - Tercero
    - FIN

### Manera 3:
En esta manera se muestra un texto cargado del txt y un botón el cual muestra texto leido en el mismo txt
```
X.- String 1;String 2;=>Y
```
- `X` Número de paso, como por ejemplo:
    - 1
    - 2.8
    - Tercero
- `String 1` Cadena de texto con el texto principal a mostrar, como por ejemplo:
    - Apague y encienda la cámara.
    - Si esta usando Collaborate, siga los pasos del vídeo
- `String 2` Cadena de texto a mostrar en el botón, como por ejemplo:
    - He esperado
- `Y` Número de paso si se presiona el botón, como por ejemplo:
    - 1.1
    - 3
    - Tercero
    - FIN

Cabe destacar que el último paso del txt, es decir la última linea, debe seguir la siguente estructura:
```
FIN.- String
```
Donde `FIN` no se modifica, ya que indica el último paso y `String` indica el nombre del html al que redigirá el botón pertinente. Dicho html se derá encontrar en la carpeta `src` .

### Aclaraciones:
1. Cada paso soporta o un `.png` o un `.mp4` dichos archivos se cargarán automaticamente si se encuentran dentro de la carpeta `rsc` y a su vez dentro de la carpeta de la opcion donde se desea mostar. El nombre de dicha multimedia, deberá ser tal cual el número de paso en el que se desea mostar, alguos ejemplos son: `2.mp4` , `1.5.png` , `paso1.png`.
2. Si se desea cambiar la ejecución por defecto de alguna de las opciones, habrá que cambiar `incio.js` , que se encuentra en `src/inicio` , para que cuando carga la opción, le asigne de forma correcta la redirección al html deseado.