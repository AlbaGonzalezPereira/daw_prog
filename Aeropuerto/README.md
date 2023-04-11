## TAREA AEROPUERTO

Crea un paquete con el nombre de **air.utils** donde almacenar métodos estáticos de validación y de utilidad.

Método1. **leeString**: Método que recibe por ***parámetro*** un título y mostrará: “Introduce (titulo) :”, donde (titulo) es lo que recibe por parámetro. Devolverá ***null*** si el valor introducido es * o un ***String*** con el valor introducido.

Método1.1. **Float leeFloat** e **Integer leeInt**: Método que recibe por **parámetro** un título y leerá un Float y lo devolverá, utilizar el método anterior.

Método1.2. **Integer leeInt**: Método que recibe por parámetro un título y leerá un entero y lo devolverá, utilizar el método leeString.

Método2. **descomponerNombre**: Método que recibe por parámetro un ***String*** con nombres y apellidos y devolverá un ***array*** con el nombre, el apellido y el segundo apellido.

Método3. **validarCódigo**: Método que recibe un ***String*** código y devuelve si es ***correcto*** o ***no***, el código tiene que tener 4 números.

Método4. **queMes**: Método que recibe por ***parámetro*** fecha y devuelve un entero con el més de esa fecha.

Método5. **notaExamen** Método que devuelve un número entre 1 y 10 de manera aleatoria.

<br>

Crea otro paquete llamado **air.prog** donde se almacenarán otras clases.

En un aeropuerto como máximo habrá 100 aviones.

Los aviones pueden ser de *combate* o de *pasajeros*.

Para los *aviones de pasajeros* necesitamos el numero de plazas, el precio del billete y un código.

Para los *aviones de combate* necesitamos la velocidad, el tipo de misiles y un código.

Los *tipos de misiles* pueden ser solo aire-tierra, aire-aire o bengala. **ENUM**

El código debe de tener 4 números.

Realiza un **programa principal** donde se seleccionará un menú con las siguientes características:
1. Introducir avión
2. Visualizar aviones (visualiza los datos)
3. Ver el número de plazas totales
4. Modificar el precio del billete (dado un código, crear método en la clase
correspondiente)
5. Salir

En caso de introducir un *, debe volver al menú principal.