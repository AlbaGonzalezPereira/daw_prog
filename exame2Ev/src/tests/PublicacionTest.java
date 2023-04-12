package tests;

import library.Publicacion;

public class PublicacionTest {
    public static void main(String[] args) {
        Publicacion p=new Publicacion("978-1-4842-4827-0","Building Microservices Applications");
        System.out.println(p);
        p.addAutor("Yo mismo");
        System.out.println(p);
        p.setAutores(new String[] {"Otro más","y Yo mismo"});
        System.out.println(p);
        p.delAutor("Otro más");
        System.out.println(p);
        p.setAutor("Harsh Chawla");
        p.addAutor("Hemant Kathuria");
        System.out.println(p);
    }
}
