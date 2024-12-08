/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E1;

import utils.InputUtils;
import static utils.InputUtils.PI;

/**
 *
 * @author xavi
 */
public class E1_AreaVolumenCilindro {
    public static void main(String[] args) {
        double radio;
        double altura;
        double area;
        double volume;
        
        radio=InputUtils.leeReal("Radio do Cilindro: ");
        altura=InputUtils.leeReal("Altura do Cilindro: ");
        area=PI*radio*radio*altura;
        volume=2*PI*radio*altura+2*PI*radio*radio;
        System.out.printf("O área dun cilindro de radio %.4f e altura %.4f é de %.4f\n",radio,altura,area);
        System.out.printf("O volume dun cilindro de radio %.4f e altura %.4f é de %.4f\n",radio,altura,volume);
    }    
}
