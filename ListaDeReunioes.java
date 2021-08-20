import java.time.LocalDate;
import java.util.*;

public class ListaDeReunioes{

@SuppressWarnings ("unchecked")

private LocalDate dataInicial, dataFinal;
private Collection<String> listaDeParticipantes;



public ListaDeReunioes(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){
this.dataInicial = dataInicial;
this.dataFinal = dataFinal;
this.listaDeParticipantes = listaDeParticipantes;
}


 //////////////////////////////////////////////
 //              GETs e SETs                 //
 //////////////////////////////////////////////

public LocalDate getInicial(){
return this.dataInicial;
}

public LocalDate getFinal(){
return this.dataFinal;
}

public Collection<String> getListaDeParticipantes(){
return this.listaDeParticipantes;
}

}