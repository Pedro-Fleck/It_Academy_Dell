public enum Event{
    CONVINCING_PITCH("Pitch Convincente", 6),
    PRODUCT_WITH_BUGS("Produto com bugs", -4),
    USER_ATRACTION("Boa tração de usuarios", 3),
    IRRITATED_INVESTOR("Investidor irritado", -6),
    FAKE_NEWS("Fake news no pitch", -8);

    private String description;
    private int modifier;

    private Event(String description, int modifier){
        this.description = description;
        this.modifier = modifier;

    }
    public String getDescription() {
        return description;
    }
    public int getModifier() {
        return modifier;
    }
    public static String mostrarOpcoes() {
        StringBuilder sb = new StringBuilder("Eventos disponíveis:\n");
        for (Event event : values()) {
            sb.append(event.ordinal())
              .append(". ")
              .append(event.getDescription())
              .append(" (")
              .append(event.getModifier() > 0 ? "+" : "")
              .append(event.getModifier())
              .append(")\n");
        }
        return sb.toString();
    }
    public static Event porIndice(int index){
        Event[] events =  values();
        if((index < 0)||(index >= events.length)){
           throw new IllegalArgumentException("Indice do Evento é invalido: " + index); 
        }
        return events[index];
    }
}
