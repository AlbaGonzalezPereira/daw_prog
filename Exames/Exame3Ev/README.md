## EXAME 3EVAL
Dispoñemos dun ficheiro de texto en formato CSV ``"Plantillas.csv"`` coa seguinte estrutura:

**dni,apelidos,nome,cif,nome empresa,razon social**<br>
12345678J,Traballador Un, WorkerName, H67300350, Empresa 1, Dirección Empresa 1<br>
97213313H,Dous Traballador, NomeTraballador,S0975193D, Empresa 2, Dirección Empresa 2<br>
85596891E, Traballador Tres, NomeTraballadorEnParo,,,<br>

Poden existir liñas **“eliminadas”**. Nese caso, o DNI comeza por *.

1. Escribir un programa que dispoña dun método **void importPlantillas(String filename) throws Exception** que a
partir do CSV xere os seguintes ficheiros:
    * ``traballadores.dat``
        * Cada rexistro está composto do DNI, apelidos, nome e CIF da empresa onde traballa. Se recomenda o uso de UTF. Si o traballador está en paro se gardará un “*” como CIF de empresa.
    * ``empresas.dat``
        * Cada rexistro está composto de CIF, nome empresa e razon social. Se recomenda o uso de UTF.

2. Escribir un programa que dispoña do método **void importPlantillas(String filename) throws Exception** que a partir do CSV importe os datos na BBDD mysql **Plantillas** coa seguinte estrutura:

| **Traballadores**        |    **Empresas**            |
|--------------------------|----------------------------|
| dni: PK varchar(9)       |   cif: PK varchar(9)       |
| nome: varchar(16)        |   nome: varchar(40)        |
| apelidos: varchar(30)    |   razonsocial: varchar(60) |
| cif: FK (cif da empresa) |

3. Queremos poder **xestionar a información** anterior sen que importe demasiado o xeito en que está almacenada. En
particular queremos:
    *  Poder obter os traballadores ordeados por DNI
    *  Poder obter as empresas ordeadas por CIF
    *  Poder obter todos os traballadores de unha empresa
    *  Poder obter un traballador por DNI
    *  Poder obter unha empresa por CIF
    *  Poder obter os traballadores en paro (non teñen empresa)

**Se Pide** (OLLO: Non se pide un programa que faga todo isto):

**a) Crear a clase Empresa**. Unha Empresa ten como atributos unicamente accesibles dende a propia clase o
seu cif que é un String que unha vez establecido non se pode cambiar, o nome que é un String, e a razón social que é un String. Consideramos iguais dúas empresas si os seus cif coinciden. Consideramos que unha empresa e maior, igual ou menor que outra unicamente en función dos seus nomes de empresa.

**b) Crear a clase Traballador**. Un Traballador ten como atributos unicamente accesibles dende a propia clase
o seu dni que é un String que unha vez establecido non se pode cambiar, o nome que é un String, os apelidos que é un
String e o cif da Empresa na que traballa, que pode ser ***null*** no caso de que non traballe en ningunha empresa.
Consideramos iguais dous traballadores si os seus nif coinciden. Consideramos que un traballador e maior, igual ou
menor que outro unicamente en función dos seus apelidos e nome, por ese orden.

**c) Escribir a clase StoreFicheiro** que xere dous índices para os ficheiros ***traballadores.dat*** e ***empresas.dat*** utilizando estruturas de almacenamento dinámico en memoria que permitan localizar os traballadores por DNI e as
empresas por CIF de xeito óptimo, e listalos por orden de DNI e CIF respectivamente e facilitando e implantando
ademais todas as consultas descritas ao inicio deste punto
Esta clase se poderá utilizar nun ``try-with-resources``, de xeito que no construtor se cargarán os índices dos ficheiros ***traballadores.idx*** e ***empresas.idx*** nas estruturas dinámicas en memoria axeitadas. Si non existen estes ficheiros, se cargarán a partir da información en ***traballadores.dat*** e ***empresas.dat***. A operación de peche eliminará o contido de ***traballadores.idx*** e ***empresas.idx*** gardando neles o contido das estruturas dinámicas cargadas en memoria de modo que
na seguinte execución xa se teñan os índices.

**d) Escribir a clase StoreBBDD** que permita realizar todas as consultas descritas ao inicio deste punto.