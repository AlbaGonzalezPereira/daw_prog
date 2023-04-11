package funcions;

import static funcions.Verbosity.DEBUG;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Clase que que define obxectos Exception
 *
 * @author alba_
 */
public class VerboseException extends Exception {

    //atributo que non se poderá almacenar máis de un obxecto ErrorMessage co mesmo id, 
    //non poden existir id duplicados
    HashMap<Integer, ErrorMessage> informacion;
    private static Level level=LevelFactory.get(Verbosity.INFO);

    /**
     * método constructor accesible dende calquera parte, que creará unha VerboseException con id 1
     * @param msg 
     */
    public VerboseException(String msg){
        informacion =new HashMap<>();
        informacion.put(1, new ErrorMessage(msg));
    }
    /**
     * método constructor sobrecargado, accesible dende calquera parte, que creará unha VerboseException con id 1, 
     * e a mensaxe almacenada en Information msg con id 1I, engadindo a mensaxe 
     * de nivel ERR description
     * @param msg
     * @param description 
     */
    public VerboseException(String msg,String description){
        informacion =new HashMap<>();
        ErrorMessage e=new ErrorMessage(msg);
        e.addDetail(Verbosity.ERR, description);
        informacion.put(1, e);
        
    }
    /**
     * constructor sobrecargado, accesible dende calquera parte, que transformará a Exception e nunha VerboseException 
     * respetando a mensaxe e establecendo a información de nivel DEBUG ligadas a Exception e.
     * @param e 
     */
    public VerboseException(Exception e){
        //copiado do seu exercicio --> non sabía como plantexalo
        informacion=new HashMap<>();
        informacion.put(1,new ErrorMessage("1I",e.getMessage()));
        
        StackTraceElement[] trace=e.getStackTrace();
        Arrays.stream(trace)
                .map((t)->"Line "+t.getLineNumber()+" in "+t.getMethodName()+" in "+t.getFileName())
                .forEach((m)->addMensaxe(DEBUG,1,m));
        /** Alternativamente ....
         for(StackTraceElement t: trace) {
            String m="Line "+t.getLineNumber()+" in "+t.getMethodName()+" in "+t.getFileName();
            addMensaxe(DEBUG,1,m);
         }
         */
        
    }
    
    /**
     * método que cambia o Verbosity da clase
     * @param level 
     */
    public static void setLevel(Verbosity level) {
        VerboseException.level=LevelFactory.get(level);
    }
    
    
    /**
     * método que nos da diferentes informacións dependendo do level e da id
     * @param level
     * @param id
     * @param msg
     * @return 
     */
    public int addMensaxe(Verbosity level, int id, String msg) {
        if (level == Verbosity.INFO) {
            informacion.put(id, new ErrorMessage(id + "I", msg));

        } else if ((level == Verbosity.ERR) || (level == Verbosity.DEBUG)) {
            if (informacion.containsKey(id)) {//comproba se existe a id
                informacion.get(id).addDetail(level, msg);//recolle ErrorMessage e engade details co valor id+'E'

            } else {
                throw new IllegalArgumentException("Non existe erro de nivel previo");
            }
        }
        return id;
    }//fin addMensaxe
    
    //sobrecargamos o método addMensaxe
    /**
     * método sobrecargado que no que non é necesario pasarlle o id (se xera por 
     * defecto o id seguinte ao mais alto dos existentes) 
     * @param level
     * @param msg
     * @return 
     */
    public int addMensaxe(Verbosity level, String msg) {
        int maior=0;
        for (Integer id : informacion.keySet()) {
            //temos o id máis alto
            if(maior<id)
                maior=id;
        }
        return addMensaxe(level, maior, msg);
    }
    
    /**
     * método sobrecargado que so recibe unha mensaxe, que se engadirá a Verbosity INFO
     * @param msg
     * @return 
     */
    public int addMensaxe(String msg) {
        return addMensaxe(Verbosity.INFO, msg);
    
    }
    // copiado
    @Override
    public String getMessage() {
        //return Arrays.stream(level.messages(this)).map((s)->s+"\n").reduce("",String::concat);
        /** Alternativamente.... */
             String[] data=level.messages(this);
             String r="";
             for(String s:data) {
                 r=(r+"\n").concat(s);
             }
             return r;
        
    }   
    //copiado
    public String getMessage(Verbosity v) {
        Level mylevel=LevelFactory.get(v);
        return Arrays.stream(mylevel.messages(this)).map((s)->s+"\n").reduce("",String::concat);
    }
    
    
}//fin clase
