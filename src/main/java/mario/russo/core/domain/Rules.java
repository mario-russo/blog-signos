package mario.russo.core.domain;

public enum Rules {
    ADMIN(1, "ADMIN"),
    USUARIO(2, "USUARIO"),
    CRIADOR_CONTEUDO(3, "CRIADOR");

    private int id;
    private String rules;

    Rules(int id, String nome) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

}
