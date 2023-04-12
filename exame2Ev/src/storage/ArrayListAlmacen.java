/*************************EXERCICIO 4.3 - 2AVALIACION ***************************************/

package storage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * clase que será capaz de almacenar obxectos da clase asociada, polo que se deseñará 
 * facendo uso de tipos xenéricos (Generics)
 * @author alba_
 */
public class ArrayListAlmacen<T> implements Almacen<T> {//implementamos a interface Almacen
    private ArrayList<T> almacen = new ArrayList<>();

    /***********************implementamos os métodos abstractos*******************/
    /**
     * método que engade ao Almacen o obxecto recibido como parámetro, retornando 
     * true si se engade correctamente . Si o obxecto xa se atopaba no Almacen 
     * (no sentido de que xa existe outro obxecto que é “equals” co que queremos 
     * engadir), non se engade e se retorna false. 
     * @param obxecto
     * @return
     * @throws Exception - se se produce un erro grave
     */
    @Override
    public boolean engadir(T obxecto) throws Exception {
        if (obxecto == null)
            throw new Exception("O obxecto é nulo");
        
        if(!almacen.contains(obxecto))
            return almacen.add(obxecto);
        return false; 
    }

    /**
     * método que recibe un Filtro e un array onde gardar a información, e retorna un array 
     * con todos os obxectos do Almacen que son “validos” segundo o Filtro recibido. 
     * @param f
     * @param informacion
     * @return
     * @throws Exception - se se produce un erro grave
     */
    @Override
    public T[] cargar(Filtro f, T[] informacion) throws Exception {
        //T[] informacion é o tipo al que se quere enviar a información
        if (f == null)
            throw new Exception("O filtro non pode ser nulo");
        //declaramos un ArrayList onde gardar os elementos filtrados porque non sabemos o que vai ocupar o array
        ArrayList<T> filtrado = new ArrayList<>(); 
        for (T almacenF : almacen) {
            if(f.match(almacenF))
                filtrado.add(almacenF);
        }
        return filtrado.toArray(informacion); //pasamos o ArrayList a un array
    }

    /**
     * método que recibe un array onde gardar a información e retorna un array con 
     * todos os elementos gardados no Almacen. 
     * @param informacion
     * @return
     * @throws Exception - se se produce un erro grave
     */
    @Override
    public T[] cargar(T[] informacion) throws Exception {
        if (informacion == null)
            throw new Exception("Hai que poñer algunha información");
        return almacen.toArray(informacion);//pasamos un ArrayList a un array       
        } 
    

    /**
     * método que recibe un Filtro e elimina do almacén todos os obxectos que son 
     * “validos” segundo o Filtro recibido retornando o número de elementos eliminados. 
     * @param f - filtro recibido
     * @return - número de elementos eliminados
     * @throws Exception - Se se produce un erro grave
     */
    @Override
    public int eliminar(Filtro f) throws Exception {
        if (f == null)
            throw new Exception("O filtro non existe");
        int contador=0; 
//        //isto pode dar erros ao estar recorrendo e eliminando á vez
//        for (T almacenB : almacen) {
//            if(f.match(almacenB))
//                almacen.remove(almacenB);
//                contador++;
//        }

//        //para solucionar o problema anterior debemos utilizar un iterador e o seu método remove()
        Iterator it = almacen.iterator(); //declaramos un iterador co ArrayList que temos
        while(it.hasNext()){
            if(f.match(it.next())){//se coinciden
                it.remove(); //eliminamos o elemento.
                contador++;
            }
        }
        return contador; //pasamos o ArrayList a un array
        
    }

    /**
     * método que recibe un obxecto e o elimina do Almacen. 
     * @param obxecto
     * @return - 1 si elimina o obxecto ou 0 si non existe
     * @throws Exception - Si se produce un erro grave
     */
    @Override
    public int eliminar(T obxecto) throws Exception {
        if (obxecto == null)
            throw new Exception("O obxecto é nulo e non se pode eliminar");
//      if(almacen.contains(obxecto)){
//            almacen.remove(obxecto);
        //unha solución máis correcta ao anterior é:
        if(almacen.remove(obxecto)) //xa devolve true se o atopa e o elimina
            return 1;
        return 0;
        
    }

    /**
     * método que recibe un obxecto e substitúe a información do obxecto existente 
     * no Almacen pola do obxecto recibido.
     * @param obxecto
     * @return - false si o obxecto non existe, e true si se modifica correctamente
     * @throws Exception - Se se produce un erro grave
     */
    @Override
    public boolean modificar(T obxecto) throws Exception {
        if (obxecto == null)
            throw new Exception("Non pode ser nulo");
        if (almacen.contains(obxecto)){
            almacen.set(almacen.indexOf(obxecto), obxecto);
            return true;
        }
        return false;
        
    }

    /**
     * método que recibe un obxecto e o engade ao Almacen si non existe, ou o modifica 
     * se xa existe. 
     * @param obxecto
     * @return - true se se garda/modifica e false en outro caso
     * @throws Exception - Se se produce un erro grave
     */
    @Override
    public boolean gardar(T obxecto) throws Exception {
        if (obxecto == null)
            throw new Exception("O obxecto non pode ser nulo");
        if(!almacen.contains(obxecto))
            return almacen.add(obxecto); //engadimos o obxecto a almacen
        else
            return modificar(obxecto); //chamamos ao método anterior
        
    }

    /**
     * método que debe permitir percorrer os elementos almacenados mediante un 
     * Iterator, un for ou un forEach.
     * @return 
     */
    @Override
    public Iterator<T> iterator() {
        return almacen.iterator();
    }
    
}
