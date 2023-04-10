## EXAME 1EVAL
Desexamos facer un programa de Debuxo para o que creamos as seguintes clases:

1. No package c**om.iesrodeira.Draw** creamos as clases que resultarían útiles para calquera programa que quixera
debuxar:
    * Un “***Point***” e un obxecto que representa unha fila (y) cun valor enteiro e unha columna (c) cun valor enteiro. Estes atributos **so poden ser accedidos directamente dentro do mesmo package**. *A representación dun Point como String debe ter a forma **(y,x)***. A **clase Point é accesible dende calquera parte**.
    * Un “***Drawable***” e un obxecto que permite debuxar nel (ver clase *Drawable*).
    * Un “***Paper***” é un obxecto *Drawable* que *debuxa nun array de char de **y** filas por **x** columnas* e dispón de versións propias dos métodos ***drawLineHorizontal***, ***drawLineVertical***, ***point***, ***drawText***, ***show*** e ***clear***. A **clase Paper é accesible dende calquera parte** e dispón dun ***constructor que permite crear un array de char de y filas por x columnas (recibindo y e x como parámetros)*** onde se realizarán os debuxos representando os puntos cun ‘*’ sexan da cor que sexan (a cor se ignora).
    * O construtor debe instanciar o array de char de y filas por x columnas e inicializalo a “ “ chamando ao método “***clear***”
    * A clase “*Paper*” debe ser final.
<br><br>
    **SE PIDE:**
    * Crear a clase Point 
    * Crear a clase Paper 
<br><br>

2. No paquete **com.iesrodeira.Designer** creamos as clases necesarias para a nosa aplicación, accesibles dende calquera parte:
    * Unha “ ***Figura*** ” é un obxecto que pode ser representado nunha posición dun “Drawable” (***Ver clase Figura***)
    * Un “ ***Text*** ” é unha ***Figura*** que ten como atributos un String, unha posición de presentación e a dirección de debuxo do texto. Estes atributos **únicamente son accesibles dende dentro da propia clase** (ver drawString de Drawable). Esta clase debe ter dous construtores, un que recibe como argumento o String a pintar, a posición de comenzo e a dirección na que se escribirá o texto e outro que recibe unicamente o String e a posición de comenzo tomando como dirección LEFTRIGHT
    * Un “ ***Polygon*** ” é unha ***Figura*** que ten como atributo ***únicamente accesible dende a propia clase ou clases descendentes*** un array de vértices segundo a orde de debuxo das súas liñas (cada vértice é un obxecto da clase Point). O construtor recibirá o array de vértices do polígono.
    * Un “ ***Rectangle*** ” é un ***Polygon*** de 4 vértices . O seu construtor recibirá un punto (a coordenada do vértice superior esquerdo) e a lonxitude de cada un dos dous lados, en horizontal e en vertical (de tipo int).
    * Un “ ***Square*** ” é un “***Rectangle***” que ten os dous lados iguais, polo tanto o seu construtor únicamente recibe un punto (a coordenada da esquina superior esquerda) e o tamaño do lado (un int).
    * Un “ ***Design*** ” é un obxecto que almacena “Figuras” nun array de Figuras que é un atributo **únicamente accesible dende a propia clase**. O seu construtor recibe como argumento o número máximo de figuras que pode almacenar. Un “Design” dispón da capacidade de engadir obxectos Figura, eliminar todas as figuras do Design e de visualizar o “***Design” facendo uso dun “Drawable”*** que recibe como parámetro.
<br><br>

**SE PIDE:**
   * Crear a clase Text. (ver Drawable) 
   * Crear a clase Polygon
   * Crear a clase Rectangle
   * Crear a clase Square 
   * Crear a clase Design

<br>

3. No paquete **com.iesrodeira.DrawApp** se creará a aplicación DrawApp que *creará un obxecto Design cunha capacidade de 10 Figuras* e amosará un menú coas seguintes opcións:
<pre>
1.- Pintar Texto
2.- Pintar Rectángulo
3.- Pintar Cadrado
4.- Amosar Debuxo
5.- Limpar Debuxo
6.- Saír.
</pre>

A **Opción 1** solicitará unha coordenada e preguntará a dirección de debuxo desexada, creando e gardando no ***Design*** o obxecto ***Text*** correspondente.

A **Opción 2** solicitará unha coordenada e a lonxitude de cada lado, creando e gardando no ***Design*** un obxecto “***Rectangle***” creado con esa información.

A **Opción 3** solicitará unha coordenada e a lonxitude do lado, creando e gardando no Design o obxecto “***Square***” correspondente.

A **Opción 4** visualizará na pantalla o Design utilizando un Paper de 25 filas e 80 columnas.

A **Opción 5** eliminará todas as figuras do Design.
<br><br>

**SE PIDE:**
* Implementar a clase DrawApp.
<br><br>

**NOTA:** Si non caben máis figuras a aplicación debe amosar “***non caben máis figuras***”.