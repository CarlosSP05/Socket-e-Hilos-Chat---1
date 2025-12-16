Servidor-Cliente en Java con Sockets
-

Este proyecto implementa un servidor y un cliente en Java utilizando sockets. A lo largo de las diferentes fases, el servidor se ha ido mejorando para manejar múltiples clientes, intercambiar mensajes y responder a comandos específicos.

Estructura del Proyecto
-

Fase 1: El servidor acepta una sola conexión de cliente y se bloquea mientras procesa esa conexión.

Fase 2: El servidor y el cliente intercambian mensajes hasta que el cliente envíe el comando "FIN".

Fase 3: El servidor maneja múltiples clientes simultáneamente utilizando hilos (multithreading).

Fase 4: El servidor responde a comandos específicos del cliente como "FIN" para cerrar la conexión y "TIME" para obtener la hora actual.


--------

Fase 1: Análisis del Bloqueo
-
Descripción:
En esta fase, el servidor bloquea la conexión de nuevos clientes mientras está ocupado con un cliente. Esto se simula añadiendo un retraso de 15 segundos utilizando Thread.sleep(15000).

Funcionalidad:
El servidor acepta una única conexión de cliente.
Una vez conectado, el servidor bloquea la conexión durante 15 segundos, impidiendo que un segundo cliente se conecte.

<img width="1826" height="892" alt="image" src="https://github.com/user-attachments/assets/372b54dc-bd62-4bd2-812f-1aaf8e7c5649" />  (Cliente fase 1)
-----------
<img width="1844" height="901" alt="image" src="https://github.com/user-attachments/assets/6f4c9b0a-c542-45d3-87f7-046fc452c98b" />  (Servidor fase 1)
----------

----------

Fase 2: La Conversación Fluida
-
Descripción:
En esta fase, se implementa un sistema de conversación fluida entre el cliente y el servidor, donde el servidor sigue respondiendo a los mensajes del cliente hasta que se recibe el comando "FIN".

Funcionalidad:
El cliente puede enviar mensajes continuamente al servidor.
El servidor responde a cada mensaje hasta que el cliente envíe "FIN" para terminar la conversación.

<img width="1817" height="905" alt="image" src="https://github.com/user-attachments/assets/f4011a0c-858b-47bb-80a4-eb02fc949105" />  (Cliente fase 2)
----------
<img width="1804" height="926" alt="image" src="https://github.com/user-attachments/assets/c2788230-6061-4fcd-a130-7002abb7b83d" />  (Servidor fase 2)
---------

---------

Fase 3: El Servidor Multihilo
-
Descripción:
Esta fase extiende el servidor para permitir múltiples conexiones simultáneas. El servidor maneja a cada cliente en un hilo separado, lo que permite que el servidor atienda varios clientes a la vez.

Funcionalidad:
Cada vez que un cliente se conecta, el servidor crea un nuevo hilo para gestionar la comunicación con ese cliente, permitiendo que se manejen múltiples clientes simultáneamente.

<img width="1816" height="824" alt="image" src="https://github.com/user-attachments/assets/3c46dbba-2e7c-4a62-ae3b-74197c5984dd" />  (Cliente fase 3)
---------
<img width="1851" height="908" alt="image" src="https://github.com/user-attachments/assets/39c601ec-dd7b-4852-bac8-ec69d53d52da" />  (Server fase 3)
---------

---------

Fase 4: Mejora del Servidor - Comandos y Terminación
-
Descripción:
En esta fase, el servidor ahora responde a comandos específicos enviados por los clientes. Se implementa el comando "TIME" para obtener la hora actual del servidor y "FIN" para terminar la sesión de manera controlada.

Funcionalidad:
El cliente puede enviar "TIME" para obtener la hora actual del servidor.
El cliente puede enviar "FIN" para terminar la conversación de manera controlada.

<img width="1827" height="894" alt="image" src="https://github.com/user-attachments/assets/5df35990-61f0-4c06-ab78-35a573e3b715" /> (Cliente fase 4)
---------
<img width="1843" height="902" alt="image" src="https://github.com/user-attachments/assets/011ba428-e590-4713-987c-e8e3403d7d99" /> (Servidor fase 4)
---------
---------
Realizado por:
- Carlos Sánchez Pérez
- Jesús Macías Ojuelos
