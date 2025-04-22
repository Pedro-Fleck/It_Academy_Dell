import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Tournament tournament = new Tournament();
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("=== CADASTRO DE STARTUPS ===");
        System.out.println("Quantas startups participarão? (4, 6 ou 8)");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i <= qtd; i++){
            System.out.println("Startup #" + (i));
            System.out.print("Nome: ");
            String name = scanner.nextLine();
            System.out.print("Slogan: ");
            String slogan = scanner.nextLine();
            System.out.print("Ano de fundação: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            tournament.setStartup(name, slogan, ano);
        }
        
        tournament.begginTournament();

        while (true) {
            System.out.println("\n=== FASE " + tournament.getRodadaAtual() + " ===");
            if(!tournament.getOnBattle().isEmpty()){
                for(Battle b : tournament.getOnBattle()) {
                    b.adminBattle(scanner);
                    Startup winner = b.getWinner();
                    if (winner != null) {
                        winner.setPoints(winner.getPoints() + 30);
                        System.out.println("Campeão da fase: " + winner.getName() +" com " + winner.getPoints() + " pontos!\n" );
                    }
                    
                }
            }

            if(tournament.getStartups().size() <= 1){
                break;
            }

            tournament.nextRound();
        }

        tournament.showReport();
    }
}