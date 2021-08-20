import java.time.LocalDateTime;

public class Horarios {
    
    @SuppressWarnings ("unchecked")

    private LocalDateTime[] disponibilidades = new LocalDateTime[2];
    private String nome;


    public Horarios(String nome, LocalDateTime[] disponibilidades){
        this.nome = nome;
        this.disponibilidades = disponibilidades;
    }



    //////////////////////////////////////////////
    //              GETs e SETs                 //
    //////////////////////////////////////////////



    public LocalDateTime getInicio(){ 
      return this.disponibilidades[0];
    }



    public LocalDateTime getFim(){ 
     return this.disponibilidades[1];
    }




    public String getNome(){ 
      return this.nome;
    }

}