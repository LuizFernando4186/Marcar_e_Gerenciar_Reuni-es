public class Sala {
    
    @SuppressWarnings ("unchecked")

    private String nome, local, observacoes;
    private int capacidade;


    public Sala(String nome, String local, int capacidade, String observacoes){
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
        this.observacoes = observacoes;
    }


    //////////////////////////////////////////////
    //              GETs e SETs                 //
    //////////////////////////////////////////////

    public String getNome(){
      return nome;
    }

    public String getLocal(){
      return local;
    }

    public int getCapacidade(){
      return capacidade;
    }

    public String getObservacoes(){
      return observacoes;
    }
    
    public void setNome(String novoNome){
      this.nome = novoNome;
    }

    public void setCapacidade(int novaCapacidade){
      this.capacidade = novaCapacidade;
    }

    public void setObservacoes(String novaObservacoes){
      this.observacoes = novaObservacoes;
    }

    
}
