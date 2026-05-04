public class peao {
    String nome;
    String apelido;
    Categoria categoria;
    Montarias[] montarias;


    public peao(String nome, String apelido, Categoria categoria, Montarias[] montarias) {
        this.nome = nome;
        this.apelido = apelido;
        this.categoria = categoria;
        this.montarias = montarias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Montarias[] getMontarias() {
        return montarias;
    }

    public void setMontarias(Montarias[] montarias) {
        this.montarias = montarias;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Apelido: " + apelido);
        System.out.println("Categoria: " + categoria);
        System.out.println("Montarias: " + java.util.Arrays.toString(montarias));

    }
    @override toString(){
        this.modalidade = modalidade;}
}    