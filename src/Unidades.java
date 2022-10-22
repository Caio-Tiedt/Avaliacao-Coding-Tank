import java.util.Objects;

public class Unidades {

    /*
    Método para extender o nome da unidade
     */
    public static String valorExtensoUnidade(String unidade) {
        if (Objects.equals(unidade, "C")) {
            return "Celsius";
        } else if (Objects.equals(unidade, "F")) {
            return "Fahrenheit";
        } else if (Objects.equals(unidade, "K")) {
            return "Kelvin";
        } else {
            return unidade;
        }
    }
}
