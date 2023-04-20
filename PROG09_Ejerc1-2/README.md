## Detalles de la tarea09
### **Enunciado**
Estamos en disposición de dar persistencia a los datos que utilizan nuestras aplicaciones. Hasta el momento los datos manejados solo se mantienen en memoria principal: cuando nuestras aplicaciones finalizan la ejecución todos los datos se pierden.

---

**Ejercicio 1**

Se trata de modificar la aplicación desarrollado en la Unidad de Trabajo 8, para dar persistencia a los datos de cuentas bancarias. 

Para ello:

* Cuando la aplicación finalice, es decir, el usuario seleccione la opción *Salir*, la aplicación volcará el contenido de la estructura de datos con las cuentas bancarias a un fichero binario denominado *datoscuentasbancarias.dat*.
* Cuando la aplicación inicie la ejecución, antes de mostrar el menú, deberá cargar en la estructura de datos el contenido del fichero *datoscuentasbancarias.dat*.
Como ya sabes, para poder realizar estas tareas es necesarios que nuestros objetos que representan cuentas bancarias sean serializables. Habrá que realizar las convenientes modificaciones a la clase ``CuentaBancaria``.
---
**Ejercicio 2**

Añade una nueva opción al menú de la aplicación denominado "Listado clientes" de modo que al seleccionarla, se genere un fichero de texto denominado *ListadoClientesCCC.txt* que contenga una línea de texto por cada cuenta bancaria almacenada, donde se visualice nombre del propietario y CCC por cada una de ellas.

La última línea del fichero contendrá el número total de cuentas existente.