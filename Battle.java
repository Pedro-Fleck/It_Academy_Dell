import java.util.Random;
import java.util.Scanner;

public class Battle{
    private Startup startup1;
    private Startup startup2;
    private boolean concluded = false;
    int i = 1;
    public Battle(Startup s1, Startup s2){
        this.startup1 = s1;
        this.startup2 = s2;
    }
    public void adminBattle(Scanner scanner){
        System.out.println("Batalha entre "+ startup1.getName() + " vs " + startup2.getName());

        while(true){
            System.out.println("Rodada:" + i);
            System.out.println("1. Aplicar evento para "+ startup1.getName());
            System.out.println("2. Aplicar evento para "+ startup2.getName());
            System.out.println("3.Finalizar Batalha");

            int option = scanner.nextInt();

            if(option == 3){
                break;
            }

            System.out.println("Eventos disponiveis:");
            for(Event e: Event.values()){
                System.out.println(e.ordinal() + ". " + e.getDescription() + " (" + e.getModifier() + ")");
            }
            int chosenEvent = scanner.nextInt();
            Event event = Event.values()[chosenEvent];

            if(option == 1){
                if(startup1.receivedEvents(event)){
                    System.out.println("Esta Startup ja participou desse evento nesta rodada!");
                }
            }else if(option == 2){
                if(!startup2.receivedEvents(event)){
                    System.out.println("Esta Startup ja participou desse evento nesta rodada!");
                }
            }
            i++;
        }
        this.concluded = true;
    }
    public Startup getWinner(){
        if(!concluded) return null;
        if(startup1.getPoints() > startup2.getPoints()){
            return startup1;
        }else if(startup2.getPoints()> startup1.getPoints()){
            return startup2;
        }else{
            System.out.println("As Startups empataram!");
            System.out.println("Vamos para o Shark Fight!");
            Random random = new Random();
            if(random.nextBoolean()){
                return startup1;
            }else{
                return startup2;
            }
        }
    }
}