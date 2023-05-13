package Database;

//interface que só ten un método. É como un where dentro dunha consulta
public interface Criteria<R> {
    // Devolve true si o parámetro r resulta "aceptable" segundo a Criteria elexida.
    public boolean accept(R r); //vai filtrar
}
