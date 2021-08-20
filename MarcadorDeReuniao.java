import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.IOException;
import java.util.*;
import java.time.Duration;



public class MarcadorDeReuniao{

    @SuppressWarnings ("unchecked")


    //Classe para verificar a disponibilidade de horarios
    private LocalDate dataInicial, dataFinal;
    private Collection<String> listaDeParticipantes;
    private List<Horarios> disponibilidades = new ArrayList<>();
    private List<ListaDeReunioes> reunioes = new ArrayList<>();


     /**
     * Metodos para marcar e encontrar a melhor data e hora para reuniao.
     */
    

    //Construtor da classe MarcadorDeReuniao
    public MarcadorDeReuniao(){}


    //1° Indica uma data inicial e final e uma lista de participantes 
    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){
    
    ListaDeReunioes marcador = new ListaDeReunioes(dataInicial,dataFinal,listaDeParticipantes);
    reunioes.add(marcador);


    //Caso a data seja invalida 
    if (dataInicial.compareTo(dataFinal) > 0) {
			throw new IllegalArgumentException("DATA INICIAL NAO PODE SER MAIOR DO QUE DATA FINAL");
		}

    this.dataInicial = dataInicial;
    this.dataFinal = dataFinal;
    this.listaDeParticipantes = listaDeParticipantes;  
    
    imprimeReunioes();
    }
    
    
    //2° Cada participante define os seus horários disponíveis
    public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
    //Convertendo LocalDate para LocalDateTime, com data inicial começando em 00:00 e final com 23:59.
    if(dataInicial != null && dataFinal != null) { 
    LocalDateTime novaDataInicial = this.dataInicial.atTime(0,0);
    LocalDateTime novaDataFinal = this.dataFinal.atTime(23,59);
    

    //Caso a data seja invalida
    if (inicio.compareTo(fim) > 0) {
		System.out.println("DATA INICIAL NAO PODE SER MAIOR DO QUE DATA FINAL");
    return;
		}
    }

    LocalDateTime[] datas = new LocalDateTime[] {inicio, fim};

    Horarios horas = new Horarios(participante,datas);

    disponibilidades.add(horas);
  
    
    }


    //3° Pegar todos os horarios disponiveis e gerar uma hora para reuniao
    public void mostraSobreposicao(){
    System.out.println("---------- DISPONIBILIDADES DE HORARIOS : GERAL -----------");
    horariosDisponiveisGeral();

    System.out.println("\n---------- DISPONIBILIDADE DE HORARIO : POSSIVEL-----------");
    horariosDisponiveisPossivel();
    }


    /**
     * Metodos Auxiliares.
     *
     */

   

    private void horariosDisponiveisPossivel(){
    long comparacaoMilissegundos = 0;
    LocalDateTime dataRealDaReuniao = null;

    Iterator<Horarios> iteracaoHorarios = disponibilidades.iterator();

    while(iteracaoHorarios.hasNext()){
    
    Horarios horas = iteracaoHorarios.next();
    
    Duration duracao = Duration.between(horas.getInicio(),horas.getFim());
    long duracaoMilissegundos = duracao.toMillis();

    if(duracaoMilissegundos <= comparacaoMilissegundos || comparacaoMilissegundos == 0){
    comparacaoMilissegundos = duracaoMilissegundos;
    dataRealDaReuniao = horas.getInicio();
    }
  
    }
    System.out.println("DATA DA REUNIAO: " + dataRealDaReuniao);
    }

    //Horas e datas preenchidos
    private void horariosDisponiveisGeral(){
    Iterator<Horarios> iteracaoHorarios = disponibilidades.iterator();

    while(iteracaoHorarios.hasNext()){
    
    Horarios horas = iteracaoHorarios.next();

    System.out.println("Participante: " + horas.getNome() + "\tDE: " + horas.getInicio() + "\tATE: " + horas.getFim());
    }

    }

    //Metodo para imprimir as reunioes que foram marcadas
    public void imprimeReunioes(){ 
    Iterator<ListaDeReunioes> iteracaoReunioes = reunioes.iterator();

    while(iteracaoReunioes.hasNext()){
    ListaDeReunioes reunioes = iteracaoReunioes.next();
    System.out.println("LISTA DE PARTICIPANTES: " + reunioes.getListaDeParticipantes() + "  DATA INICIAL: " + reunioes.getInicial() + "  DATA FINAL: " + reunioes.getFinal());
    }
    }


}