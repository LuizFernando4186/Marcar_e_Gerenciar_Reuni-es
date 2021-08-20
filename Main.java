import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.IOException;
import java.util.*;

class Main{

    private static Scanner input = new Scanner(System.in);
    private static MarcadorDeReuniao marcar = new MarcadorDeReuniao();
    private static GerenciadorDeSalas criarSalas = new GerenciadorDeSalas();
   
     

    public static void main(String[] args) {    
      
        
        System.out.println("---------- BEM VINDO AO SISTEMA DE MARCACAO DE REUNIOES -----------");
        
      try{
           
            int opcao = 0;
            while(opcao != 10){

            exibirMenu();
            opcao = input.nextInt();
            switch(opcao){
            case 1: opc1(); continue;
            case 2: opc2(); continue;
            case 3: opc3(); continue;
            case 4: opc4(); continue;
            case 5: opc5(); continue;
            case 6: opc6(); continue;
            case 7: opc7(); continue;
            case 8: opc8(); continue;
            case 9: opc9(); continue;
            }
      }
      }

      catch(Exception e){ 
      e.printStackTrace();
      }

      System.out.println("\n----------------------------FIM-----------------------------\n");
        
      }

    private static void exibirMenu(){

        System.out.println("\n--------- GESTAO DAS REUNIOES ---------");
        System.out.println("(1) - MARCAR REUNIAO");
        System.out.println("(2) - INDICAR DISPONIBILIDADE DO PARTICIPANTE");
        System.out.println("(3) - MOSTRAR SOBREPOSICAO HORARIO");
        System.out.println("\n---------- GESTAO DAS SALAS ---------");
        System.out.println("(4) - ADICIONAR SALA");
        System.out.println("(5) - REMOVER SALA");
        System.out.println("(6) - LISTAR SALAS");
        System.out.println("(7) - LISTAR RESERVAS DA SALA");
        System.out.println("(8) - RESERVAR SALA");
        System.out.println("(9) - CANCELAR RESERVA");
        System.out.println("(10) - SAIR");
        System.out.println("\nDigite a opcao desejada: ");

    }

      

    private static void opc1(){
    Collection<String> listaPreenchida = new ArrayList<>();
  
    System.out.println("\nData Inicial (yyyy-MM-dd): ");
    LocalDate dataInicial = addData(input);

    System.out.println("\nData Final (yyyy-MM-dd): ");
    LocalDate dataFinal = addData(input); 
    
    System.out.println("\nDigite a lista de participantes e para finalizar digite x");
    while(true){ 
    String email = input.next();
    if(email.equals("x")) break;//Parar o laco quando apertar x
    listaPreenchida.add(email);
    }

    marcar.marcarReuniaoEntre(dataInicial,dataFinal,listaPreenchida);
    }



    private static void opc2(){
    System.out.println("Digite seu endereco eletronico: ");
    String email = CapturaNextLine();;

    System.out.println("Formato (Data inicial): (yyyy-mm-ddTHH:mm)");
    LocalDateTime horaDataInicial = addDataTime(input);

    System.out.println("Formato (Data final): (yyyy-mm-ddTHH:mm)");
    LocalDateTime horaDataFinal = addDataTime(input);

    marcar.indicaDisponibilidadeDe(email,horaDataInicial,horaDataFinal);
    }



    private static void opc3(){
    marcar.mostraSobreposicao();
    }
    

    
    private static void opc4(){
    
    System.out.println("Escreva o nome da sala: ");
    String nome = CapturaNextLine();
    
    System.out.println("Escreva o local da sala: "); 
    String local = CapturaNextLine();
   
    System.out.println("Digite a capacidade: ");
    int capacidade = input.nextInt();
    
    System.out.println("Escreva a observacao: ");
    String observacoes =  CapturaNextLine();


    criarSalas.local(local);
    criarSalas.adicionaSalaChamada(nome,capacidade,observacoes);
    }


    private static void opc5(){
    System.out.println("Escreva o nome da sala para remover: ");
    criarSalas.removeSalaChamada(CapturaNextLine());
    }

    private static void opc6(){
    criarSalas.listaDeSalas();
    }

    private static void opc7(){
    System.out.println("Escreva o nome da sala: ");
    criarSalas.imprimeReservasDaSala(CapturaNextLine()); 
    }

    private static void opc8() throws Exception{
    System.out.println("Escreva o nome da sala: ");
    String nome = CapturaNextLine();

    System.out.println("Formato (Data inicial): (yyyy-mm-ddTHH:mm)");
    LocalDateTime horaDataInicial = addDataTime(input);

    System.out.println("Formato (Data final): (yyyy-mm-ddTHH:mm)");
    LocalDateTime horaDataFinal = addDataTime(input);

    criarSalas.reservaSalaChamada(nome,horaDataInicial,horaDataFinal);

    }

    private static void opc9(){
    System.out.println("Escreva o nome da sala para cancelar a reserva.");
    String nomeSala = CapturaNextLine();

    System.out.println("Formato (Data inicial): (yyyy-mm-ddTHH:mm)");
    LocalDateTime horaDataInicial = addDataTime(input);

    System.out.println("Formato (Data final): (yyyy-mm-ddTHH:mm)");
    LocalDateTime horaDataFinal = addDataTime(input);

    Reserva reserva = criarSalas.cancelarReserva(nomeSala,horaDataInicial,horaDataFinal);

    criarSalas.cancelaReserva(reserva);
    }
    


    /**
     * Metodos Auxiliares.
     *
     */

    public static LocalDate addData(Scanner scan) {
    return LocalDate.parse(scan.next());
    }

    public static LocalDateTime addDataTime(Scanner scan) {
    return LocalDateTime.parse(scan.next());
    }

    //Metodo para consertar o erro de pula de linha do nextLine()
    private static String CapturaNextLine(){
    Scanner chave = new Scanner(System.in);
    return chave.nextLine();
    }

    }