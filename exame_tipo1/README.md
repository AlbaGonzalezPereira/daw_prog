## EXAMEN TIPO 1EVAL
**A**) Se pide crear unha clase ***InputUtils*** dentro do package **com.iesrodeira.utils** que teña os seguintes métodos estáticos accesibles dende calquera parte: 

**String leeString(String title)**: Visualiza title (* para cancelar): e espera a entrada dun String na mesma liña. Devolve o String introducido ou null si o que se introduce é '*' para indicar que se quere cancelar a entrada.

**Double leeReal(String title)**: Visualiza  title (* para cancelar): e espera a entrada dun String na mesma liña, ese String se transformará nun double que se retornará.  Si o usuario introduce *  se retornará un null (observade que o que se devolve non é un tipo primitivo double, se non un obxecto da clase Double). 

**Double leeReal(String title,double min, double max)**: Visualiza  title (* para cancelar): e espera a entrada dun String na mesma liña, ese String se transformará nun double que ten que estar comprendido entre min e max, ambos incluídos. Si non é así, se insiste na entrada, en caso contrario se retorna o número. Si o usuario introduce *  se retornará un null (observade que o que se devolve non é un tipo primitivo double, se non un obxecto da clase Double). 

**Date leeData(String title)**: Visualiza  title (* para cancelar): e espera a entrada dun String na mesma liña, ese String se transformará nun obxecto Date se retornará.  Si o usuario introduce *  se retornará un null. Para transformar o String nunha data debedes utilizar https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html  e o seu método "parse". 

O formato de entrada será  dd-MM-yyyy  (Si o texto que se introduce non corresponde a este patrón e o programa rompe, non pasa nada. Aínda non vimos como tratar as Excepcións).

**int opcionElixeOpcion(String[] opcions,char[] choosers)**: visualiza as opcións en unha liña separadas por comas. Logo se visualizará "elixe opción: " e se esperará a entrada do usuario. Si a letra introducida polo usuario coincide cunha das almacenadas en choosers se retornará o índice de choosers onde se atopa a letra, noutro caso se visualizarán as opcións de novo. 

**int opcionElixeOpcion(String title,String[] opcions,char[] choosers)**: Visualizará o título suliñado con unha liña de guións,  (se aconsella facer un método printLine(int nchars) que visualiza nunha liña tantos guions como se lle indique en nchars...) e logo unha opción por liña. Logo se visualizará "elixe opción: " e se esperará a entrada do usuario. Si a letra introducida polo usuario coincide cunha das almacenadas en choosers se retornará o índice de choosers onde se atopa a letra, noutro caso se visualizarán as opcións de novo. 

**B**) O almacén *RodeiraStore SL* garda os artígos que despacha as tendas da zona. Cada artigo ten un **código** alfanumérico de 12 letras, unha **denominación**, unha **descrición** e un **precio**. 

Existen 4 tipos de artigos:   
- Artigos de Limpeza   
- Artigos de Alimentación   
- Artigos de Farmacia   
- Artigos de Perfumería 

Os **artigos de limpeza** poden ser *tóxicos* ou non. Esta característica que se indicará cun atributo. 

Os **artigos de alimentación** poden ser *refrixerados* ou non refrixerados (esta caracterísitica se indicará cun atributo), e teñen unha *data de envasado* e unha *data de consumo preferente*.

Os **artigos de Farmacia** teñen unha *data de envasado* e unha *data de caducidade*. 

O Almacén pode gardar un máximo de 4096 Artigos de calquera dos tipos anteriores, para o que empregará un Array de 4096 elementos. Nun instante determinado teremos *numArtigos* artigos no almacén. 

### Se pide:   
Dentro do package ***com.iesrodeira.almacen***: 
1. **Deseñar a clase Artigo** que representa un artigo que pode ser gardado no almacén. Os atributos do Artigo deben poder ser accedidos únicamente dende a propia clase, as clases fillas (que heredan de artigo) e as clases do mesmo package. O construtor dun Artigo debe recibir o código, a denominación, a descrición e o Precio.  
2. **Deseñar as clases ArtigoLimpeza, ArtigoAlimentacion, ArtigoFarmacia e ArtigoPerfumería**. Os seus atributos únicamente serán accesibles dende dentro da propia clase. Os constructores recibirán os seguintes datos:
    - ***ArtigoLimpeza***: código, denominación, descrición, precio, si é tóxico ou non.      
    - ***ArtigoAlimentación***: código, denominación, descrición, precio, data de envasado, data de consumo preferente, si é refrixerado ou non.
    - ***ArtigoFarmacia***: código,denominación, descrición, precio, data de envasado, data de caducidade.
    - ***ArtigoPerfumería***: código, denominación, descrición, precio.
    
Dentro do package ***com.iesrodeira.AppAlmacen***: 

3. **Deseñar a clase principal** da aplicación, **AppAlmacen**, que visualizará un menú coas seguintes opcións:      
    1. *Engadir Artigo ao Almacén*      
    2. *Listado de Artigos*      
    3. *Existencias*      
    4. *Saír* 
    <br><br>

    A **opción 1** debe solicitar a información do artigo (codigo, denominación, descrición), preguntar qué tipo de artigo é (Limpeza, Alimentación, Farmacia ou Perfumería) e logo a información pertinente segundo o caso, crar o obxecto e almacenalo no Almacén si ten sitio. Si non caben xa máis artigos debe visualizarse unha mensaxe indicando esa circunstancia. 
    
    A **opción 2** debe visualizar un menú que permita elexir si queremos visualizar todos os artigos, os artigos de limpeza, os artigos de alimentación, os artigos de farmacia ou os artigos de perfumería e visualizar o listado.       
    - Os artigos de perfumería deben visualizar codigo, denominación e precio. 
    - Os artigos de limpeza deben visualizar codigo, denominación, precio e entre paréntese (Tóxico) cando o artigo é tóxico.       
    - Os artigos de alimentación deben visualizar código, denominación, precio e data de consumo preferente. No caso de que sexa refrixerado debe indicar ademáis "(Refrixerado)".
    - Os artigos de farmacia deben visualizar código, denominación, precio e data de caducidade. 
    
    A **opción 3** debe visualizar o nýmero e valor total de todos os artigos presentes no almacén, e o desglose do número e valor dos artigos de Limpeza, Alimentación, Farmacia e Perfumería. Para facer isto, se aproveitará o Polimorfismo para ir acumulando aos atributos totalFarmacia, importeTotalFarmacia, totalLimpeza, importeTotalLimpeza, totalAlimentación, importeTotalAlimentacion, totalFarmacia, importeTotalFarmacia e totalPerfumería, importeTotalPerfumería.  
    
NON SE CONSIDERA VÁLIDO IR ACUMULANDO OS VALORES SEGUNDO SE VAN ENGADINDO ARTIGOS AO ALMACÉN. CANDO SE ELIXE A OPCIÓN SE DEBEN CONTABILIZAR.