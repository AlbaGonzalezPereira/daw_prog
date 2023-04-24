package com.iesrodeira.AppAlmacen;

import com.iesrodeira.almacen.Almacen;
import com.iesrodeira.almacen.*;
import static com.iesrodeira.utils.InputUtils.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author alba_
 */
public class AppAlmacen {

    public static void main(String[] args) {
        Almacen almacen1 = new Almacen();
        char[] charArray = {'1', '2', '3', '4'};
        String[] opcionesArray = {"Engadir artigo ao almacén", "Listado de Artigos", "Existencias", "Sair"};
        int opcion;
        do{
        opcion = opcionElixeOpcion("Elixe opción",opcionesArray, charArray);
        double prezo;
        char caracter;
        switch (opcion) {
            case 1:
                String codigo,
                 denominacion,
                 descricion;
                do {
                    codigo = leeString("Introduza o código (12 caracteres): ");
                } while (!contarCaracteres(codigo));

                denominacion = leeString("Introduza denominación");
                descricion = leeString("Introduza descrición");
                prezo = leeReal("Introduce o prezo.");
                String[] opcionesTipo = {"Limpeza", "Alimentación", "Farmacia", "Perfumería"};
                char[] charTipo = {'1', '2', '3', '4'};
                int opcion2 = opcionElixeOpcion("Que tipo de artigo é:", opcionesTipo, charTipo);
                switch (opcion2) {
                    case 1:
//                        Scanner sc=new Scanner(System.in);
//                        System.out.println("É tóxico o produto de limpeza? Marque S/N");
//                        char caracter = sc.nextLine().charAt(0);

                        boolean toxic = false;
                        caracter = leeString("É tóxico o produto de limpeza? Marque S/N").toUpperCase().charAt(0);
                        if (!(caracter == '*')) {
                            if (caracter == 'S') {
                                toxic = true;
                            }
                        }
                        if (almacen1.haiSitio()) {
                            Artigo artigo = new ArtigoLimpeza(toxic, codigo, denominacion, descricion, prezo);
                            almacen1.engadirArtigoAlmacen(artigo);
                        }

                        break;
                    case 2:

//                         private boolean refrixerado;
//    private Date dataEnvasado;
//    private Date consumoPref;
                        boolean refrixerado = false;
                        caracter = leeString("É refrixerado o produto de alimentación? Marque S/N").toUpperCase().charAt(0);
                        if (!(caracter == '*')) {
                            if (caracter == 'S') {
                                refrixerado = true;
                            }
                        }
                        Date dataEnvasado = leeData("Introduce a data de envasado");
                        Date consumoPref = leeData("Introduce a data de consumo preferente");
                        if (almacen1.haiSitio()) {
                            Artigo artigo2 = new ArtigoAlimentacion(refrixerado, dataEnvasado, consumoPref, codigo, denominacion, descricion, prezo);
                            almacen1.engadirArtigoAlmacen(artigo2);
                        }

                        break;
                    case 3:
//farmacia
                        //private Date dataEnvasado;
//   private Date dataCaducidade;
                        Date dataEnvasado1 = leeData("Introduce a data de envasado");
                        Date dataCaducidade = leeData("Introduce a data de caducidade");
                        if (almacen1.haiSitio()) {
                            Artigo artigo3 = new ArtigoFarmacia(dataEnvasado1, dataCaducidade, codigo, denominacion, descricion, prezo);
                            almacen1.engadirArtigoAlmacen(artigo3);
                        }

                        break;
                    case 4:
//perfumeria
                        if (almacen1.haiSitio()) {
                            Artigo artigo4 = new ArtigoPerfumeria(codigo, denominacion, descricion, prezo);
                            almacen1.engadirArtigoAlmacen(artigo4);
                        }
                        break;

                }
                break;
            case 2:
                String[] opcionesTipo3 = {"Visualzar Todos os Artigos", "Limpeza", "Alimentación", "Farmacia", "Perfumería"};
                char[] charTipo3 = {'1', '2', '3', '4', '5'};
                int opcion4 = opcionElixeOpcion("Elixe a opción que desexes visualizar:", opcionesTipo3, charTipo3);
                switch (opcion4) {
                    case 1:
                        if (Almacen.getNumArtigos() > 0) {
                            for (int i = 0; i < Almacen.getNumArtigos(); i++) {
                                System.out.println(almacen1.getArtigos()[i]);
                            }
                        } else {
                            System.out.println("Non hai artigos");
                        }
                        break;
                    case 2:

                        if (Almacen.getNumArtigos() > 0) {
                            for (int i = 0; i < Almacen.getNumArtigos(); i++) {
                                if (almacen1.getArtigos()[i].getClass().equals(ArtigoLimpeza.class)) {
                                    System.out.println(almacen1.getArtigos()[i]);
                                }
                            }
                        } else {
                            System.out.println("Non hai artigos");
                        }
                        break;
                    case 3:
                        if (Almacen.getNumArtigos() > 0) {
                            for (int i = 0; i < Almacen.getNumArtigos(); i++) {
                                if (almacen1.getArtigos()[i].getClass().equals(ArtigoAlimentacion.class)) {
                                    System.out.println(almacen1.getArtigos()[i]);
                                }
                            }
                        } else {
                            System.out.println("Non hai artigos");
                        }
                        break;
                    case 4:
                        if (Almacen.getNumArtigos() > 0) {
                            for (int i = 0; i < Almacen.getNumArtigos(); i++) {
                                if (almacen1.getArtigos()[i].getClass().equals(ArtigoFarmacia.class)) {
                                    System.out.println(almacen1.getArtigos()[i]);
                                }
                            }
                        } else {
                            System.out.println("Non hai artigos");
                        }
                        break;
                    case 5:
                        if (Almacen.getNumArtigos() > 0) {
                            for (int i = 0; i < Almacen.getNumArtigos(); i++) {
                                if (almacen1.getArtigos()[i].getClass().equals(ArtigoPerfumeria.class)) {
                                    System.out.println(almacen1.getArtigos()[i]);
                                }
                            }
                        } else {
                            System.out.println("Non hai artigos");
                        }
                        break;

                }

                break;
            case 3:
                Artigo artigo;
                double importeTotalAlimentacion = 0;
                double importeTotal = 0;
                double importeTotalFarmacia = 0;
                double importeTotalPerfumeria = 0;
                double importeTotalLimpieza = 0;

                int totalFarmacia = 0;
                int totalLimpieza = 0;
                int totalAlimentacion = 0;
                int totalPerfumeria = 0;

                for (int i = 0; i < Almacen.getNumArtigos(); i++) {
                    artigo = almacen1.getArtigos()[i];
                    importeTotal += artigo.getPrezo();
                    if (artigo.getClass() == ArtigoAlimentacion.class) {
                        importeTotalAlimentacion += artigo.getPrezo();
                        totalAlimentacion++;
                    }
                    if (artigo.getClass() == ArtigoFarmacia.class) {
                        importeTotalFarmacia += artigo.getPrezo();
                        totalFarmacia++;
                    }
                    if (artigo.getClass() == ArtigoLimpeza.class) {
                        importeTotalLimpieza += artigo.getPrezo();
                        totalLimpieza++;
                    }
                    if (artigo.getClass() == ArtigoPerfumeria.class) {
                        importeTotalPerfumeria += artigo.getPrezo();
                        totalPerfumeria++;
                    }
                    //System.out.println(almacen1.getArtigos()[i]);
                }

                System.out.println("Artigos totais:" + Almacen.getNumArtigos());
                System.out.println("Importe total:" + importeTotal);

                System.out.println("\nArtigos Alimentacion:" + totalAlimentacion);
                System.out.println("Importe Total" + importeTotalAlimentacion);

                System.out.println("\nArtigos Farmacia:" + totalFarmacia);
                System.out.println("Importe Total" + importeTotalFarmacia);

                System.out.println("\nArtigos Limpeza:" + totalLimpieza);
                System.out.println("Importe Total" + importeTotalLimpieza);

                System.out.println("\nArtigos Perfumeria:" + totalPerfumeria);
                System.out.println("Importe Total" + importeTotalPerfumeria);

                break;
            case 4:

                break;

        }
        }while(opcion!=4);
    }
}
