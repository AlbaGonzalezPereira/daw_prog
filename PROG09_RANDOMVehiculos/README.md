## TAREFA09, ENTREGA III - PROG  

Temos información almacenada nos seguintes arquivos de texto en formato CSV que almacenan Vehiculos e Propietarios coa seguinte estrutura:

``Vehiculos.csv``

matricula,marca,modelo,propietario

``Propietarios.csv``

dni,nome,apelidos

No campo propietario de Vehículos se almacena o número de liña onde está almacenado o propietario sendo 1 o primeiro propietario ou unha cadea baleira si o vehículo non ten propietario.

Se pide un programa Java que realice as seguintes operacións utilizando os ficheiros CSV:

1.- **Alta de Vehiculos**: Se solicitará unha matrícula. Si o vehículo existe se visualizarán os seus datos indicando que o vehículo xa existe. Si non existe se pedirá a marca e o modelo e se almacenará no final de Vehiculos.csv. O propietario será inexistente, polo que se deixa en blanco

2.- **Baixa de Vehiculos**: Se solicitará unha matrícula. Si o vehículo existe se visualizarán os seus datos solicitando confirmación. Si se acepta, se modificará a matrícula poñendo un ‘*’

3.- **Modificación de Vehiculo**: Se solicitará unha matrícula. Si o vehículo existe se visualizarán os seus datos e se solicitará de novo a marca e o modelo (a matrícula e propietario se manteñen) e se solicitará confirmación. Si se acepta, se eliminará o Vehículo orixinal e se engadirá un novo cos datos modificados.

4.- **Alta de Propietario**: Se solicitará o DNI. Si o DNI existe se visualizarán os seus datos indicando que xa existe. Si non existe se pedirá o nome e apelidos e se engadirán ao ficheiro

5.- **Baixa de Propietario**: Se solicitará o DNI. Si o DNI existe, se visualizarán os seus datos e se pedirá confirmación. Si se acepta, se modificará o propietario de todos os vehículos correspondentes poñendo blanco no propietario (para iso se debe dar de baixa o Vehiculo, e dar unha nova alta co propietario a blanco) e se cambiará o DNI por *.

6.- **Modificación de Propietario**: Se solicitará o DNI. Si o DNI existe, se visualizarán os seus datos e se pedirá o nome e apelidos, eliminando o propietario vello, engadindo os novos datos ao final e modificando os Vehiculos relacionados do xeito apropiado.

7.- **Venta de Vehiculo**: Se solicitará a matrícula do vehículo. Si o Vehiculo non existe se indicará que non existe, si existe se visualizarán os datos e se pedirá o DNI do propietario. Si o propietario existe, se pedirá confirmación e se modificará o Vehículo para indicar o propietario. Si o propietario non existe, se pedirá o nome e apelidos dando de alta o propietario. Se visualizarán os datos do propietario e se pedirá confirmación, si se acepta, se modificará o Vehículo para indicar o propietario.

8.- **Mantemento**: Se xenerarán novos Vehiculo.csv e Propietarios.csv omitindo os elementos borrados.

**NOTA:** Os cambios se deben facer **inmediatamente nos ficheiros de datos**, non é válido cargar todos os datos en memoria no inicio do programa volcando os resultados o final.

Se aconsella **separar o acceso a os datos da lóxica do programa** facendo unha clase ``Database`` ou similar. O ideal e deseñar unha Interface definindo o API da ``Database`` e logo facer as clases ``VehiculoDatabase`` e ``PropietarioDatabase``. Dese xeito teremos unha API común de acceso a datos e será moito máis sinxelo o mantemento e modificación da aplicación.

Un xeito de facer as **cousas máis fáciles** e cargar no inicio do programa a información relativa as posicións no ficheiro de cada liña, por exemplo cun HashMap.
```java
public class Index<K> {

    private HashMap<K,Long> index=new HashMap<>();

    public void addIndex(K key,long position) {
        index.put(key,position);
    }

    public double getPosition(K key) {
        return index.get(key);
    }

}
```
No inicio do programa podemos crear os **Index** para ``Vehiculos`` e para ``Propietarios`` e facer as modificacións necesarias sobre o disco, actualizando os Index de xeito apropiado.

Para a **opción 8**, o máis sinxelo e cargar todos os rexistros en memoria omitindo os borrados e xerar os ficheiros de novo.