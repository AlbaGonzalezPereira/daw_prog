## Exercicio a Enviar 8: Tiro Oblicuo
Escribir un programa que permita elexir entre dúas opcións: Calcular alcance e Calcular ángulo.

Si o usuario elixe calcular alcance, se solicitará a velocidade e ángulo de disparo e se calculará e visualizará o alcance do proxectil mediante as fórmulas

**alcance=velocidade+tempo * cos(angulo)**

donde o tempo se calculará coa fórmula:  **tempo=2 * velocidade  * sen(angulo) / g** donde g é a constante de aceleración da gravedad que é de  **9.80665 m/s2**.

Primeiro debedes calcular o tempo que tarda en caer, e logo o alcance. Visualizando "Impacto a XXX metros en XXXX segundos".

Si o usuario elixe calcular ángulo  se solicitará o alcance requerido e a velocidade inicial e se calculará o ángulo necesario para acadar o obxectivo. 

Para facer isto,  debedes ter en conta que :

O ángulo necesario para alcanzar o alcance solicitado (si a distancia é menor ao alcance máximo que permite a velocidade) se calculará mediante a fórmula   **alcance=2*velocidade^2*sen(angulo)*cos(angulo) / g**

Como sen(angulo)*cos(angulo) = sen(2*angulo)/2, --> **alcance=velocidade^2*sen(2*angulo)/g**

O alcance máximo a velocidade indicada será o determinado por un ángulo de 45º. Para calcular o ángulo para alcanzar o obxectivo basta despexar , e se calcula como

o ángulo é o **arco con seno =(alcance_desexado*g / velocidade^2) / 2**

**PD: As funcións necesarias son métodos estáticos da clase Math (Math.sin, Math.cos, Math.asin ...)**