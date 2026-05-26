package atividade1;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Animal[] animais = new Animal[6];
        animais[0] = new Animal(0, "Joadanete",LocalDate.of(2020,2, 15),Fazenda.VACA);
        animais[1] = new Animal(1, "Claudenilson", LocalDate.of(2126,3,12), Fazenda.TOURO);
        animais[2] = new Animal(2, "Lamborghini", LocalDate.of(2226,4,11), Fazenda.CAVALO);
        animais[3] = new Animal(3, "Mustang",LocalDate.of(2580,3,12), Fazenda.PORCO);
        animais[4] = new Animal(4, "Rooster", LocalDate.of(2999,9,29),Fazenda.GALINHA);
        animais[5] = new Animal(5, "Peixonauta", LocalDate.of(1888,8,28), Fazenda.PEIXE);
        for (int i = 0; i< animais.length; i++){
            System.out.println(animais[i]);
        }
    }
}
