## EXAME TIPO 3EVAL
1.- Desenvolve un programa en Java que permita ler o arquivo ``"datos.txt"`` e extraer a información dos campos "**dni**", "**nome**" e "**idade**" de cada liña. A continuación, escribe no arquivo ``"resultados.txt"`` o dni, nome e idade da persoa. O programa debe permitir a **lectura** e **escritura** aleatoria de datos no arquivo ``"resultados.txt"`` utilizando **RandomAccessFile**. En particular, o programa debe permitir a **busca de rexistros** no arquivo por posición ou polo valor do campo "DNI", o **borrado**, **inserción** e a **actualización** dos datos dun rexistro específico.


Para **acceder ao RandomAccessFile por DNI**, pódese utilizar unha estrutura de índice que asocie cada DNI coa posición do rexistro correspondente no arquivo. Este índice almacenarase no arquivo ``"resultados.idx"``.


Para **"borrar" unha liña**, escribirase un **"*"** como primeiro carácter do DNI. Como a modificación dos datos pode resultar nun tamaño superior aos datos previos, para modificar daranse de baixa os datos antigos engadindo os novos ao final.

2.- Desenvolve tamén un programa Java que **se conecte á base de datos MySQL** ``"mi_bd"`` e permita a inserción, actualización e eliminación de datos na táboa ``"usuarios"``. A táboa ``"usuarios"`` debe ter as columnas **"dni"** (cadea de caracteres), **"nome"** (cadea de caracteres) e **"idade"** (entero). O programa debe inserir na táboa ``"usuarios"`` os datos extraídos do arquivo ``"datos.txt"``. Tamén debe permitir a inserción, borrado / actualización dun usuario específico e a eliminación dun usuario polo seu dni.


Valorarase a **correcta utilización das clases** ``InputStream``, ``OutputStream``, ``RandomAccessFile`` e a libraría de acceso a bases de datos MySQL. Asimismo, terase en conta a **correcta implementación das funcionalidades** requeridas, a **claridade e lexibilidade do código**, así como a **eficiencia e robustez do programa**.

As clases que permiten traballar con ``"resultados.txt"`` e coa BBDD Mysql deben pertencer a clase ``Storage``. Un ``Storage`` contén os seguintes métodos:

``Usuario get(String dni) throws Exception;``

``void insert(Usuario user) throws Exception;``

``void update(Usuario user) throws Exception;``

``void delete(String dni) throws Exception;``

---

## SOLUCIÓN:
Esta solución ten os seguintes **ficheiros**:

***package tipo3*** - clases de utilidade

``GenericImporter:`` Utiliza un "Importer" para importar ``"datos.txt"``. Dependendo do tipo de "Importer", se importará a unha BBDD Relacional ou a ``"resultados.txt"`` && ``"resultados.idx"``.

``Importer``: Interface funcional definindo o método ``importData``.

``Storage``: Interface definindo os métodos indicados no enunciado.

``Usuario``: Clase definindo o Usuario. É Comparable por DNI para que o TreeMap manteña a orde por DNI.

``UsuariosStorageFile``: Implantación da interface Storage mediante RandomAccessFile cun índice.

``UsuariosStorageDDBB``: Implantacioń da interface Storage cunha BBDD relacional JDBC.
<br><br>

***package main*** – Aplicacións pedidas no enunciado

Estas dúas clases son para amosar xeitos de importación que non dependen das clases creadas no package tipo3 salvo Usuario e a interface Importer para poder utilizalas
de xeito xeral.

``Exercicio1_RAS_Importer``: Importa "datos.txt" creando "resultados.txt" e "resultados.idx".

``Exercicio2_DDBB_Importer``: Importa "datos.txt" a unha BBDD Relacional.

``Example``: Aplicación exemplo realizando as funcións indicadas no enunciado. Para non ter que facer dúas, o seu construtor recibe o Storage co que desexamos traballar.

``ExampleBBDD``: Aplicación exemplo mediante unha BBDD JDBC. Simplemente crea un UsuariosStorageDDBB e instancia un Example.

``ExampleFiles``: Aplicación exemplo mediante RandomAccessFile e un indice. Simplemente crea un
UsuariosStorageFile e instancia un Example.
