## Detalles de la tarea09
### **Enunciado**
Estamos en disposición de dar persistencia a los datos que utilizan nuestras aplicaciones. Hasta el momento los datos manejados solo se mantienen en memoria principal: cuando nuestras aplicaciones finalizan la ejecución todos los datos se pierden.

---

**Ejercicio 1**

Se trata de modificar la aplicación desarrollado en la Unidad de Trabajo 8, para dar persistencia a los datos de cuentas bancarias. 

Para ello:

* Cuando la **aplicación finalice**, es decir, el usuario seleccione la opción *Salir*, la aplicación volcará el contenido de la estructura de datos con las cuentas bancarias a un fichero binario denominado *datoscuentasbancarias.dat*.
* Cuando la **aplicación inicie** la ejecución, antes de mostrar el menú, deberá cargar en la estructura de datos el contenido del fichero *datoscuentasbancarias.dat*.
Como ya sabes, para poder realizar estas tareas es necesarios que nuestros objetos que representan cuentas bancarias sean serializables. Habrá que realizar las convenientes modificaciones a la clase ``CuentaBancaria``.


---
**Ejercicio 2**

Añade una **nueva opción** al menú de la aplicación denominado "Listado clientes" de modo que al seleccionarla, se genere un fichero de texto denominado *ListadoClientesCCC.txt* que contenga una línea de texto por cada cuenta bancaria almacenada, donde se visualice nombre del propietario y CCC por cada una de ellas.

La última línea del fichero contendrá el número total de cuentas existente.

---

### CÓDIGOS DEL PROGRAMA:

Añadimos una nueva clase llamada ``Database`` que tiene el siguiente código:

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * clase cos métodos relevantes para o almacenamento e recuperación dos datos
 * @author alba_
 */
class Database {
    
    /**
     * método que permite ler un obxecto da clase Banco almacenado nun arquivo chamado "datoscuentasbancarias.dat".
     * @return 
     */
    public Banco leer() {
        //try (ObjectInputStream obj=new ObjectInputStream(new FileInputStream("datoscuentasbancarias.dat")))
        File file = new File("datoscuentasbancarias.dat"); //creamos o arquivo
        if(!file.exists()){
            try {
                file.createNewFile();//se non existe crea o ficheiro
                return null;
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try(FileInputStream input = new FileInputStream(file);ObjectInputStream obj = new ObjectInputStream(input);) {//comprobamos se existe
            
            //Primeiro, crea un obxecto FileInputStream para ler os bytesOutputGuardar do arquivo 
//            FileInputStream input = new FileInputStream(file);
            //agora o utiliza para crear un obxecto ObjectInputStream
//            ObjectInputStream obj = new ObjectInputStream(input);
            /*O obxecto ObjectInputStream utilízase para ler os obxectos do arquivo na 
            orde en que se escribiron.*/
            Banco banco=(Banco)obj.readObject();//o obxecto Banco lese utilizando o método readObject()
            /*Unha vez que se leeu o obxecto Banco, péchase o obxecto ObjectInputStream 
            e o obxecto FileInputStream*/
//            obj.close();
//            input.close();
            return banco;
        //Se se produce algunha excepción ao ler o arquivo, registrarase unha mensaxe de erro.
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * método que vai gardar unha piscina nun arquivo chamado "datoscuentasbancarias.dat", utilizando 
     * un obxecto ObjectOutputStream.
     * @param banco
     * @return 
     */
    public boolean guardar(Banco banco) {
        File file = new File("datoscuentasbancarias.dat");//creamos un obxecto File que representa o arquivo "datoscuentasbancarias.dat"
        //creamos un obxecto FileOutputStream para escribir no arquivo
        //creamos un obxecto ObjectOutputStream
        if(!file.exists()){
                return false;
        }
        try (FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream obj = new ObjectOutputStream(output);){ //try with resources
            file.createNewFile();//creamos o arquivo se non existe
            obj.writeObject(banco);//escribimos o obxecto Banco no archivo utilizando o método writeObject().
            //comentamos estas liñas porque implícitamente agora co try with resources vanse pechar
//            obj.close();//pechamos
//            output.close();//pechamos
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
}
```

En la clase ``Principal`` añadimos el siguiente método:

```java
/**
     * método que vai listar clientes de modo que xere un ficheiro de texto
     * denominado ListadoClientesCCC.txt que vai conter unha liña de texto por
     * cada conta bancaria almacenada, onde se visualice nome do propietario e
     * CCC por cada unha delas. A última liña do ficheiro conterá o número total
     * de contas existentes.
     */
    private static void listarClientes() {
        //para que cree o arquivo o que o abra se existe dunha tacada
        //é autocloseable e ten que meterse nun try with resources
        try (FileWriter file = new FileWriter("ListadoClientesCCC.txt")) {//FileWriter is meant for writing streams of characters
            ArrayList<CuentaBancaria> cuentas = banco.getCuentas();//recuperamos as contas bancarias nun ArrayList
            int contador = 0;
            if (!cuentas.isEmpty()) {
                for (CuentaBancaria cuenta : cuentas) {
                    contador++;
                    file.write(cuenta.getTitular().getNombre() + " " + cuenta.getTitular().getApellidos() + " "+ cuenta.getIban() + "\n");
                }
                file.write("número total de contas existentes: " + contador);
            }

        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
```
En la clase ``Banco`` añadimos el siguiente método:
```java
    /**
     * método que devolve as contas bancarias
     * @return 
     */
    public ArrayList<CuentaBancaria> getCuentas(){
        return cuentas;
    }
```

Las clases ``Banco``, ``Persona`` y ``CuentaBancaria``, las hacemos Serializable, implentando dicha interfaz.