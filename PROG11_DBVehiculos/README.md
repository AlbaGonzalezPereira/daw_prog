## TAREFA11, ENTREGA II - PROG  

Se pide elaborar o programa indicado na **tarefa a entregar III** no tema de **Ficheiros** e **Streams**  empregando unha base de datos mariadb/mysql:

1.- **Alta de Vehiculos**: Se solicitará unha matrícula. Si o vehículo existe se visualizarán os seus datos indicando que o vehículo xa existe. Si non existe se pedirá a marca e o modelo e se almacenará no final de Vehiculos.csv. O propietario será inexistente, polo que se deixa en blanco

2.- **Baixa de Vehiculos**: Se solicitará unha matrícula. Si o vehículo existe se visualizarán os seus datos solicitando confirmación. Si se acepta, se modificará a matrícula poñendo un ‘*’

3.- **Modificación de Vehiculo**: Se solicitará unha matrícula. Si o vehículo existe se visualizarán os seus datos e se solicitará de novo a marca e o modelo (a matrícula e propietario se manteñen) e se solicitará confirmación. Si se acepta, se eliminará o Vehículo orixinal e se engadirá un novo cos datos modificados.

4.- **Alta de Propietario**: Se solicitará o DNI. Si o DNI existe se visualizarán os seus datos indicando que xa existe. Si non existe se pedirá o nome e apelidos e se engadirán ao ficheiro

5.- **Baixa de Propietario**: Se solicitará o DNI. Si o DNI existe, se visualizarán os seus datos e se pedirá confirmación. Si se acepta, se modificará o propietario de todos os vehículos correspondentes poñendo blanco no propietario (para iso se debe dar de baixa o Vehiculo, e dar unha nova alta co propietario a blanco) e se cambiará o DNI por *.

6.- **Modificación de Propietario**: Se solicitará o DNI. Si o DNI existe, se visualizarán os seus datos e se pedirá o nome e apelidos, eliminando o propietario vello, engadindo os novos datos ao final e modificando os Vehiculos relacionados do xeito apropiado.

7.- **Venta de Vehiculo**: Se solicitará a matrícula do vehículo. Si o Vehiculo non existe se indicará que non existe, si existe se visualizarán os datos e se pedirá o DNI do propietario. Si o propietario existe, se pedirá confirmación e se modificará o Vehículo para indicar o propietario. Si o propietario non existe, se pedirá o nome e apelidos dando de alta o propietario. Se visualizarán os datos do propietario e se pedirá confirmación, si se acepta, se modificará o Vehículo para indicar o propietario.

8.- **Mantemento**: Se xenerarán novos Vehiculo.csv e Propietarios.csv omitindo os elementos borrados.