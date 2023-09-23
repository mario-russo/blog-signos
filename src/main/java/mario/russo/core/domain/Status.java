package mario.russo.core.domain;

public enum Status {
    ATIVO(1, "ativo"),
    inativo(1, "ativo");

    private int id;
    private String status;

    Status(int id, String status) {
        setStatus(status);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
