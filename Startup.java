import java.util.*;

public class Startup{
    private String name;
    private String slogan;
    private int yearFoundation;
    private int points = 70;
    private Map<Event, Integer> receivedEvents = new HashMap<>();


    public Startup(String name, String slogan, int yearFoundation){
        this.name = name;
        this.slogan = slogan;
        this.yearFoundation = yearFoundation;
    }

    public boolean receivedEvents(Event event){
        if(receivedEvents.containsKey(event)){
            return false;
        }
        switch (event) {
            case CONVINCING_PITCH: points = points + 6;
                break;

            case PRODUCT_WITH_BUGS: points = points - 4;
                break;

            case USER_ATRACTION: points = points + 3;
                break;

            case IRRITATED_INVESTOR: points = points - 6;
                break;
            
            case FAKE_NEWS: points = points - 8;
                break;
                
            default:
                System.out.println("Evento inválido: " + event);
                return false;
        }
        receivedEvents.put(event, 1);
        return true;
    }
    public void resetEventsRound() {
        receivedEvents.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Nome deve conter caracteres!");
        }
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        if(slogan == null){
            throw new IllegalArgumentException("slogan deve conter caracteres!");
        }
        this.slogan = slogan;
    }

    public int getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(int yearFoundation) {
        if((yearFoundation < 1000)||(yearFoundation > 2026)){
            throw new IllegalArgumentException("Ano de fundação deve conter quatro números inteiros!");
        }
            this.yearFoundation = yearFoundation;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Map<Event, Integer> getReceivedEvents() {
        return receivedEvents;
    }

    public void setReceivedEvents(Map<Event, Integer> receivedEvents) {
        this.receivedEvents = receivedEvents;
    }
}