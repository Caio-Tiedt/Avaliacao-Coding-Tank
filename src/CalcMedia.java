public class CalcMedia {

    /*
    Método que cálcula a média
     */

    public static double mediaTemperaturas(Temperatura[] temperaturas){
        double media = 0;
        for (Temperatura temperatura:temperaturas){
            media += temperatura.getvalorT();
        }
        return media/temperaturas.length;
    }
    public static double mediaTemperaturas(Temperatura[] temperaturas, int quantidadeTemperaturas){
        double media = 0;
        for (Temperatura temperatura:temperaturas){
            media += temperatura.getvalorT();
        }
        return media/( (double) quantidadeTemperaturas);
    }
}
