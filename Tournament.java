import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Tournament {
    private List<Startup> startups = new ArrayList<Startup>();
    private List<Battle> onBattle = new ArrayList<Battle>();
    private int rodadaAtual = 0;

    public void setStartup(String nome, String slogan, int ano){
        startups.add(new Startup(nome, slogan, ano));
    }

    public void begginTournament() {
        if(startups.size() < 4 || startups.size() > 8 || startups.size() % 2 != 0){
            System.out.println("Número inválido de startups! Deve ser entre 4 e 8 (par)");
            return;
        }
        rodadaAtual = 1;
        drawBattles();
    }

    private void drawBattles(){
        onBattle.clear();
        if (startups.size() < 2) return;
        System.out.println("Vamos Sortear as Batalhas!");
        Collections.shuffle(startups);
        

        for(int i = 0; i < startups.size() -1; i += 2){
            onBattle.add(new Battle(startups.get(i), startups.get(i+1)));
        }
        if (startups.size() % 2 != 0) {
            Startup last = startups.get(startups.size() - 1);
            last.setPoints(last.getPoints() + 30); 
        }
    }
    public void nextRound() {
        List<Startup> winners = onBattle.stream()
            .map(Battle::getWinner)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        if (startups.size() % 2 != 0) {
            winners.add(startups.get(startups.size() - 1));
        }    
        startups.retainAll(winners); 
        startups.forEach(Startup::resetEventsRound);
        rodadaAtual++;
        drawBattles();
    }

    public void showReport(){
        startups.sort((s1,s2) -> s2.getPoints() - s1.getPoints());

        System.out.println("\n=== RELATÓRIO FINAL ===");
        for(Startup s: startups){
            System.out.println(s.getName() + ": " + s.getPoints() + " pontos!");
        }
        System.out.println("\nCampeã: " + startups.get(0).getName());
        System.out.println("Slogan: " + startups.get(0).getSlogan());
           
    }
    public List<Battle> getOnBattle() {
        return onBattle;
    }

    public void setOnBattle(List<Battle> onBattle) {
        this.onBattle = onBattle;
    }
    public int getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(int rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }
    public List<Startup> getStartups() {
        return startups;
    }

    public void setStartups(List<Startup> startups) {
        if(startups.size()>=4 || startups.size()<=8){
            this.startups = startups;
        }
        
    }
}

