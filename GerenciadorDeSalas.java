import java.time.LocalDateTime;
import java.io.IOException;
import java.util.List;
import java.util.*;


public class GerenciadorDeSalas {

   @SuppressWarnings ("unchecked")

  
    private String nome, descricao, localReal;
    private int capacidadeMaxima;
    
    //Instancia de List com objetos do tipo Sala
    private List<Sala> lista = new ArrayList<Sala>();
    private Collection<Reserva> todasReservas = new ArrayList<Reserva>();
    
 

     /**
     * Metodos para gerenciar as salas de reunião.
     *
     */



    //Construtor da classe GerenciadorDeSalas
    public GerenciadorDeSalas(){}

    
    public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao){ 
    this.nome = nome;
    this.capacidadeMaxima = capacidadeMaxima;
    this.descricao = descricao;

    Sala sala = new Sala(nome,this.localReal,capacidadeMaxima,descricao);
    adicionaSala(sala);
    }


    public void removeSalaChamada(String nomeDaSala){
    
    Iterator<Sala> listaSala = lista.iterator();
   
    while(listaSala.hasNext()){
    Sala sala = listaSala.next();

    if(sala.getNome().equals(nomeDaSala)){
    listaSala.remove();
    break;

    }
        }
            }


    public List<Sala> listaDeSalas(){
    System.out.println(this.lista);//Para imprimir as salas
    return this.lista;
    }

    public void adicionaSala(Sala novaSala){
    lista.add(novaSala);
    }

    public void cancelaReserva(Reserva cancelada){
    todasReservas.remove(cancelada);
    }



    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) throws Exception{

    //Caso a data seja inválida 
    if (dataInicial.compareTo(dataFinal) > 0) {
			throw new IllegalArgumentException("Data inicial não pode ser maior do que Data final");
		}
    //Interface Iterator para percorrer a lista
    Iterator<Sala> listaSala = lista.iterator();
    //Iteração na coleção do tipo Sala
    while(listaSala.hasNext()){
    Sala sala = listaSala.next();
    //Comparar o nome da sala passada como parâmetro com as salas da lista
    if(sala.getNome().equals(nomeDaSala)){
    Reserva reserva = new Reserva(sala,dataInicial,dataFinal);
    //Caso a data seja igual, saiu do laco e lanco a excecao
    if(existe(nomeDaSala,dataInicial,dataFinal)) break;
    
    todasReservas.add(reserva);
    return reserva;
    }
    }
    throw new Exception("Erro ao reservar a sala, tente novamente mais tarde, ou contate o suporte");
    }

    //Filtrando as reservas para uma sala apenas
    public Collection<Reserva> reservasParaSala(String nomeSala){
    //Crio a coleção do tipo Reserva da sala desejada
    Collection<Reserva> reservaDaSala = new ArrayList<Reserva>();
    //Interface Iterator para percorrer a lista
    Iterator<Reserva> iteracaoReserva = todasReservas.iterator();
    //Iteração na coleção do tipo Reserva
    while(iteracaoReserva.hasNext()){ 
    Reserva reserva = iteracaoReserva.next();
    //Comparar o ponteiro do endereço de memoria usando o equals
    if(nomeSala.equals(reserva.getSala().getNome())){ 
    reservaDaSala.add(reserva);//Adiciona todas as reservas desejadas
    }
    }  
    return reservaDaSala;
    }


    //Metodo para imprimir a sala recebendo o seu nome
    public void imprimeReservasDaSala(String nomeSala){
    
    Collection<Reserva> reservaSala = reservasParaSala(nomeSala);
    Iterator<Reserva> iteracaoReserva = reservaSala.iterator();
    while(iteracaoReserva.hasNext()){ 
    Reserva reserva = iteracaoReserva.next();
    System.out.println("Sala: " +reserva.getSala().getNome() + " Data Inicial: " + reserva.getInicio() + " Data Final: " + reserva.getFim());
    }
  
    }



    /**
     * Metodos Auxiliares.
     *
     */


    public Reserva cancelarReserva(String nomeSala,LocalDateTime dataInicial, LocalDateTime dataFinal){ 
    //Collection<Reserva> reservaSala = reservasParaSala(nomeSala);
    Iterator<Reserva> iteracaoReserva = todasReservas.iterator();

    while(iteracaoReserva.hasNext()){ 
    Reserva reserva = iteracaoReserva.next();
    if(nomeSala.equals(reserva.getSala().getNome()) && dataInicial.equals(reserva.getInicio()) && dataFinal.equals(reserva.getFim())){ 
    return reserva;
    } 
    }
    return null;
    }



    public boolean existe(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal){
    //Interface Iterator para percorrer a lista de reservas
    Iterator<Reserva> iteracaoReserva = todasReservas.iterator();

    while(iteracaoReserva.hasNext()){ 
    Reserva reserva = iteracaoReserva.next();

    if(nomeDaSala.equals(reserva.getSala().getNome())){
    //Caso a sala já esteja reservada, devolve true
    if(reserva.getInicio().equals(dataInicial) && reserva.getFim().equals(dataFinal)) return true;
    }
    }    
    return false;
    }


    public void local(String local){ 
    this.localReal = local;
    }


    
}
