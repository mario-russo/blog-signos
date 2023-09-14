package mario.russo.core.domain;

public enum SignoZodiaco {
    ARIES("Áries", "21 de março - 19 de abril"),
    TOURO("Touro", "20 de abril - 20 de maio"),
    GEMEOS("Gêmeos", "21 de maio - 20 de junho"),
    CANCER("Câncer", "21 de junho - 22 de julho"),
    LEAO("Leão", "23 de julho - 22 de agosto"),
    VIRGEM("Virgem", "23 de agosto - 22 de setembro"),
    LIBRA("Libra", "23 de setembro - 22 de outubro"),
    ESCORPIAO("Escorpião", "23 de outubro - 21 de novembro"),
    SAGITÁRIO("Sagitário", "22 de novembro - 21 de dezembro"),
    CAPRICÓRNIO("Capricórnio", "22 de dezembro - 19 de janeiro"),
    AQUÁRIO("Aquário", "20 de janeiro - 18 de fevereiro"),
    PEIXES("Peixes", "19 de fevereiro - 20 de março");

    private final String nome;
    private final String datas;

    SignoZodiaco(String nome, String datas) {
        this.nome = nome;
        this.datas = datas;
    }

    public String getNome() {
        return nome;
    }

    public String getDatas() {
        return datas;
    }

    @Override
    public String toString() {
        return nome;
    }
}
