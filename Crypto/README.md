## ENUNCIADO
Dispoñemos dun ficheiro ``“mywallet.txt”`` que almacena información sobre as criptomonedas adquiridas nun ficheiro
de texto formado por liñas coa seguinte estrutura:

codigo,cantidade

Donde a cantidade representa un número con decimais de doble precisión (double).

Se pide **completar o programa** adxunto cubrindo os seguintes puntos:
1. Clase ``network/URLGet``: Esta clase permite descargar textos de servizos web en internet.

    Debes programar o método ``extract`` de xeito que retorne o String leído da URL recibida como parámetro. 
    
    Unha vez feito, podes probar o seu funcionamento co ``“main”`` incluído.

2. Clase ``CoinMarket``: Almacena as criptomoedas soportadas cos seus precios no atributo ``“market”``.

    **Debes facer**:

    a) método ``getCoins``: Debe retornar unha colección das Coins almacenadas no atributo “market” ordeadas descendentemente por precio.

    b) método ``refresh``: Debe recargar do servizo web os precios das cryptos e actualizalos nas crytpos gardadas no atributo ``“market”``.

3. Clase ``TextWallet``: Xestiona as **cryptos** que posee o usuario almacenando no atributo ``wallet`` as Crypto que posee. A Clase ``Crypto`` almacena o código da criptomoeda e a cantidade que se posee da mesma. A información se carga e se garda no ficheiro de texto recibido no construtor segundo o formato indicado ao principio do enunciado.

    **Debes facer**:

    a) Metodo ``loadWallet``: Debe cargar do ficheiro de texto indicado polo atributo ``“name”`` a información e gardala no atributo ``“wallet”``.

    b) Método savecoins: Debe gardar o contido do atributo ``“wallet”`` no ficheiro de texto indicado polo atributo ``“name”``.

4. Clase ``MyCryptos`` (Programa Principal).

    **Debes facer**:

    a) Método ``ranking``: Visualiza as criptos do wallet ordeadas polo valor total das moedas de xeito descendente.

    b) Método ``exportCrytpos``: Exporta o contido do ficheiro de texto coa información das cryptos a unha base de datos MySQL chamada ``“mycryptos”`` a táboa ``“Wallet”`` que ten como campos **“code”**, **“name”** e **“amount”**. 

5. Se pide unha **implementación de Wallet** que faga uso da BBDD Mysql indicada no exercicio 4.