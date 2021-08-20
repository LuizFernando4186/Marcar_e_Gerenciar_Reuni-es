import java.time.LocalDateTime;

public class Reserva {
  
    @SuppressWarnings ("unchecked")

    private Sala sala;
    private LocalDateTime inicio,fim;



    public Reserva(Sala sala, LocalDateTime inicio, LocalDateTime fim){
    this.sala = sala;
    this.inicio = inicio;
    this.fim = fim;
    }


    //////////////////////////////////////////////
    //              GETs e SETs                 //
    //////////////////////////////////////////////
    

    public Sala getSala(){
        return this.sala;
    }


    
    public LocalDateTime getInicio(){
        return this.inicio;
    }



    public LocalDateTime getFim(){
        return this.fim;
    }
    
}
