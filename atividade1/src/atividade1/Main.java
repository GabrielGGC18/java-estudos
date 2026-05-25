package atividade1;

public class Main {
    public static void main(String[] args) {
        Animal[] animais = new Animal[6];
        animais[0] = new Animal(0, "Joadanete", Fazenda.VACA);
        animais[1] = new Animal(1, "Claudenilson", Fazenda.TOURO);
        animais[2] = new Animal(2, "Lamborghini", Fazenda.CAVALO);
        animais[3] = new Animal(3, "Mustang", Fazenda.PORCO);
        animais[4] = new Animal(4, "Rooster", Fazenda.GALINHA);
        animais[5] = new Animal(5, "Peixonauta", Fazenda.PEIXE);
        for (int i = 0; i< animais.length; i++){
            System.out.println(animais[i]);
        }
    }
}
