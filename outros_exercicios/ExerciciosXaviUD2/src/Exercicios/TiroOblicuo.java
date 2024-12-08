/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicios;

import utils.InputUtils;

/**
 *
 * @author xavi
 */
public class TiroOblicuo {

    static final double FACTOR_RADIANES = 0.0174533;
    static final double G = 9.780327;

    public static void alcance() {
        Double velocidade;
        Double angulo;
        Double alcance;
        Double tempo;

        velocidade = InputUtils.leeReal("Velocidade de saida en m/sg? : ");
        if (velocidade != null) {
            if (velocidade <= 0) {
                System.out.println("A esa velocidade o alcance é 0");
            } else {
                angulo = InputUtils.leeReal("Angulo de disparo en º? : ");
                if (angulo != null) {
                    if (angulo % 90 == 0) {
                        System.out.println("Con ese ángulo o alcance será 0");
                    } else {
                        angulo = angulo * FACTOR_RADIANES;
                        tempo = 2 * velocidade * Math.sin(angulo) / G;
                        System.out.printf("O alcance será de %.6f m\n", velocidade + tempo * Math.cos(angulo));
                    }
                }
            }
        }
    }

    public static void angulo() {
        Double velocidade;
        Double angulo;
        Double alcance;
        Double alcancemaximo;

        velocidade = InputUtils.leeReal("Velocidade inicial? : ");
        if (velocidade != null) {
            if (velocidade <= 0) {
                System.out.println("A esa velocidade o alcance é 0");
            } else {
                alcance = InputUtils.leeReal("Alcance requerido? : ");
                if (alcance != null) {
                    angulo = 45 * FACTOR_RADIANES;
                    alcancemaximo = 2 * velocidade * velocidade * Math.sin(angulo) * Math.cos(angulo) / G;
                    if (alcancemaximo < alcance) {
                        System.out.printf("Imposible acadar esa distancia (maximo %.6f m)\n", alcancemaximo);
                    } else {
                        angulo = Math.acos((alcance * G / (velocidade * velocidade)) / 2);
                        System.out.printf("Debes disparar cun ángulo de %.6fº\n", angulo / FACTOR_RADIANES);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int opc = InputUtils.leeOpcion("Calcular (A)lcance, A(n)gulo ou (S)saír? ", "ANS");
        switch (opc) {
            case 0:
                alcance();
                break;
            case 1:
                angulo();
                break;
        }
    }
}
