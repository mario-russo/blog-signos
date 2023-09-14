package mario.russo.core.domain;

public enum SignoZodiaco {
    ARIES(1, "Áries", "21 de março - 19 de abril"),
    TOURO(2, "Touro", "20 de abril - 20 de maio"),
    GEMEOS(3, "Gêmeos", "21 de maio - 20 de junho"),
    CANCER(4, "Câncer", "21 de junho - 22 de julho"),
    LEAO(5, "Leão", "23 de julho - 22 de agosto"),
    VIRGEM(6, "Virgem", "23 de agosto - 22 de setembro"),
    LIBRA(7, "Libra", "23 de setembro - 22 de outubro"),
    ESCORPIAO(8, "Escorpião", "23 de outubro - 21 de novembro"),
    SAGITÁRIO(9, "Sagitário", "22 de novembro - 21 de dezembro"),
    CAPRICÓRNIO(10, "Capricórnio", "22 de dezembro - 19 de janeiro"),
    AQUÁRIO(11, "Aquário", "20 de janeiro - 18 de fevereiro"),
    PEIXES(12, "Peixes", "19 de fevereiro - 20 de março");

    private final String nome;
    private final String datas;
    private final int id;

    SignoZodiaco(int id, String nome, String datas) {
        this.nome = nome;
        this.id = id;
        this.datas = datas;
    }

    public int getId() {
        return this.id;
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
