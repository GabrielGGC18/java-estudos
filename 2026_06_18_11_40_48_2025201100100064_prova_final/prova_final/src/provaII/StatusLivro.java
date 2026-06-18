package provaII;

public enum StatusLivro {
    DISPONIVEL(1),
    EMPRESTADO(2),
    INATIVO(3);

    private final int status;

    StatusLivro(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
