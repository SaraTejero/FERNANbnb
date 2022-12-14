# FERNANbnb

![image](https://user-images.githubusercontent.com/119956424/206865621-13d0f86c-f019-4531-9fb5-e7a22dbddc65.png)

## Comenzando 馃殌

FERNANbnb se trata de un software de consola, que nos permite implementar una plataforma de reservas de alojamientos.

### Pre-requisitos 馃搵
- Sistema Operativo Windows
- JAVA versi贸n 19.0.1

Puedes ver la versi贸n abriendo el 'S铆mbolo del sistema' o consola y escribiendo el siguiente c贸digo:

```
java -version
```

### Instalaci贸n 馃敡

La instalaci贸n es sencilla, tan s贸lo debes descargar el siguiente .rar a trav茅s del enlace que te dejamos aqu铆:

https://drive.google.com/file/d/18K7p4MO4EqKs2x3VyqXxmw2KpF0HBCEF/view?usp=sharing

Una vez descargado, descomprimimos el contenido, llevamos los ficheros al escritorio y ejecutamos el archivo FERNANbnb.bat

![image](https://user-images.githubusercontent.com/119956424/206854909-03f6b4fc-10f3-476c-b0d7-aad71fcdf194.png)

## Ejecutando el programa 鈿欙笍
Una vez ejecutado el archivo FERNANbnb.bat se abrir谩 la consola con el programa.

![image](https://user-images.githubusercontent.com/119956424/206855016-72ca7dcf-1168-4527-ac97-38782103d26a.png)

Nos muestra un men煤 con las siguientes opciones:

1. Iniciar sesi贸n
2. Registrar nuevo usuario o propietario
3. Salir

En un principio no se encuentran registrados ning煤n usuario ni ning煤n propietario, salvo el administrador. Lo ideal, es que primero se registren al menos un usuario y un propietario.

### Iniciar sesi贸n 鈱笍

Al iniciar el programa s贸lo podr谩 iniciar sesi贸n el administrador. Para poder iniciar sesi贸n como usuario o propietario es necesario registrarse.

* ADMINISTRADOR

Las credenciales de administrador son:

email: admin@gmail.com

contrase帽a: admin

![image](https://user-images.githubusercontent.com/119956424/206857663-89a36d5f-3d48-4a19-a5bb-e0f9f9d50faa.png)

`1. Ver todas las viviendas en alquiler`

Se mostrar谩n todas las viviendas registradas.

![image](https://user-images.githubusercontent.com/119956424/206858435-6c183d07-b0d4-4766-9ec2-49ca897b02a3.png)

`2. Ver todos los usuarios del sistema`

Muestra todos los usuarios y propietarios registrados.

![image](https://user-images.githubusercontent.com/119956424/206858488-5b689476-6a51-41a7-b8e0-c5f87c64dba4.png)

`3. Ver todas las reservas de viviendas`

Muestra todas las reservas creadas.

![image](https://user-images.githubusercontent.com/119956424/206857889-c87b859c-0ba5-47b0-acb9-85e404022f7e.png)

`4. Ver mi perfil`

Te muestra los datos del administrador.

![image](https://user-images.githubusercontent.com/119956424/206857849-ba25d517-0b8a-4012-9fbb-41383333a9ec.png)

`5. Modificar mi perfil`

Podemos modificar el nombre y la contrase帽a. En el caso de querer cambiar la contrase帽a, se nos pedir谩 en primer lugar la contrase帽a actual para poderla cambiar.

![image](https://user-images.githubusercontent.com/119956424/206857817-b2935e4b-b7cd-4ea4-a434-b29c224d2d71.png)

### Registrar nuevo usuario o propietario 鈱笍

Al seleccionar la opci贸n 2 del men煤 principal, se muestra el men煤 de registro.

![image](https://user-images.githubusercontent.com/119956424/206855283-b613f301-0149-43b2-ba54-2fa2c7d2c4b7.png)

Dependiendo de la opci贸n elegida, el programa solicitar谩 una serie de datos.

* REGISTRAR USUARIO

Si deseamos registrar un usuario nos pide: email, contrase帽a, nombre, apellidos y tel茅fono. Una vez rellenado los datos nos muestra el men煤 de usuario, d贸nde podemos ver las reservas que tenemos creadas.

![image](https://user-images.githubusercontent.com/119956424/206857147-014e54cd-cd88-490a-9ed8-ebeae44ba560.png)

`1. B煤squeda de alojamientos`

Mostrar谩 las viviendas que se ajusten a la b煤squeda realizada y est茅n disponibles para su reserva.

![image](https://user-images.githubusercontent.com/119956424/206857296-a9cc70c4-e67a-4c20-8919-470c68bad8d1.png)

`2. Ver mis reservas`

Como hemos realizado previamente una reserva, en este apartado nos muestra todas las reservas realizadas, en nuestro caso 1.
El usuario s贸lo podr谩 realizar como m谩ximo 2 reservas.

![image](https://user-images.githubusercontent.com/119956424/206857340-8105e4ce-e587-4af5-928a-4ec3b16fc463.png)

`3. Borrar mis reservas`

Para borrar la reserva hay que introducir el id, en caso de introducir 0 (cero), volveremos al men煤 de propietario sin borrarla, en caso contrario nos pedir谩 confirmarla.

![image](https://user-images.githubusercontent.com/119956424/206857479-ff7bedae-2cf1-4568-948d-baff02e64a40.png)

`4. Ver mi perfil`

Te muestra tus datos como usuario.

![image](https://user-images.githubusercontent.com/119956424/206857491-8967b384-18c2-4a43-aeb8-5345e0c362fd.png)

`5. Modificar mi perfil`

Podemos modificar el nombre, apellidos, contrase帽a y tel茅fono. En el caso de querer cambiar la contrase帽a y el tel茅fono, se nos pedir谩 en primer lugar la contrase帽a actual para poder realizar esas modificaciones. 

![image](https://user-images.githubusercontent.com/119956424/206857536-991f7584-2085-4b3a-8065-e3f95e7c7d10.png)

* REGISTRAR PROPIETARIO

Al igual que el registro de usuario, se nos pedir谩 una serie de datos. Al tratarse de un propietario podemos registrar una vivienda (s贸lo podr谩 registrarse como m谩ximo 1 vivienda). Una vez rellenado los datos nos muestra el men煤 de propietario, d贸nde podemos ver las viviendas que tenemos registradas.

![image](https://user-images.githubusercontent.com/119956424/206857057-47adecf2-6b5c-4180-a69e-e06f898ad34c.png)

`1. Ver mis viviendas en alquiler`

En este apartado aparecer谩n las viviendas que tenemos registradas.

![image](https://user-images.githubusercontent.com/119956424/206856150-1ead8cbc-d88f-480e-8813-bcad2d2e0c51.png)

`2. Editar mis viviendas`

En esta opci贸n podemos editar el n煤mero de hu茅spedes, el precio por noche, podemos borrar la vivienda creada y a帽adir una vivienda en caso de no haberla creado en un principio, si usted ya tiene una vivienda registrada, no le permite crear una nueva.

![image](https://user-images.githubusercontent.com/119956424/206857078-620c605d-e390-417a-ae50-f9bdb0336068.png)

`3. Ver reservas de mis viviendas`

Se mostrar谩 los datos de la reserva con el nombre del usuario que la ha reservado junto a los datos de la vivienda que tienes en alquiler.

`4. Cambiar per铆odo de disponibilidad para una vivienda`

En este apartado hay que introducir la fecha de inicio y de fin en la que la vivienda no va a estar disponible para sus reserva.

![image](https://user-images.githubusercontent.com/119956424/206856500-99f50c51-9ca1-41b2-85ce-46b26ef3b781.png)

`5. Ver mi perfil`

Aqu铆 se monstrar谩 tanto los datos del propietario como los datos de su vivienda.

![image](https://user-images.githubusercontent.com/119956424/206856555-e9e61e58-d5cb-4bed-a5cc-cd15e05bc4bc.png)

`6. Modificar mi perfil`

Podemos modificar el nombre, apellidos, contrase帽a y tel茅fono. En el caso de querer cambiar la contrase帽a y el tel茅fono, se nos pedir谩 en primer lugar la contrase帽a actual para poder realizar esas modificaciones. 

![image](https://user-images.githubusercontent.com/119956424/206856606-d3bbbf21-8927-4591-8e99-137543dbbf72.png)

### Salir 鈱笍
En esta opci贸n, como su nombre indica se sale del programa y se cierra.


## Conclusi贸n

Algunas de las caracter铆sticas de FERNANbnb son:

- Instalaci贸n f谩cil.
- Claro e intuitivo.
- Muy completo.

Puede utilizarlo cualquier persona, sin necesidad de tener altos conocimientos en inform谩tica.

Para finalizar, un resumen de las funcionalidades del programa:

- Disponemos de tres perfiles: administrador, usuario y propietario.
  - Administrador: Puede ver todas las reservas, todas las viviendas y todos los usuarios.
  - Usuario: Puede buscar alojamientos disponibles en el lugar y fechas que introduce y realizar una reserva si as铆 lo desea, ver las reservas realizadas y eliminarlas.
  - Propietario: Puede poner una vivienda en alquiler y ver las reservas que han realizado.
- S贸lo podr谩 haber dos usuarios y dos propietarios.
- Cada usuario s贸lo podr谩 tener dos reservas.
- Cada propietario s贸lo podr谩 tener una vivienda en alquiler.


## Estado 馃搶
![Badge Final](https://img.shields.io/badge/ESTADO-FINAL-green)


## Autores 鉁掞笍

* **Sara Tejero Escribano** - [SaraTejero](https://github.com/SaraTejero)
* **Jose Miguel Aranda Fern谩ndez** - [JoseMiAranda](https://github.com/JoseMiAranda)
