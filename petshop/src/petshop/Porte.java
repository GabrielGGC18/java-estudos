package petshop;

public enum Porte {
    PEQUENO(20.0),
    MEDIO(35.0),
    GRANDE(50.0);

    private final double precoBasicoBanho;
    
    Porte(double precoBasicoBanho){
        this.precoBasicoBanho = precoBasicoBanho;
    }
    public double getPrecoBasicoBanho(){
        return precoBasicoBanho;
    }
}