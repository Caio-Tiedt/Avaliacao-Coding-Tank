public class Temperatura {

    private final double valorT;
    private final String unidade;


    /*
    Getter and Setters
     */

    public double getvalorT() {
        return valorT;
    }



    public String getUnidade() {
        return unidade;
    }



    /*
    Aqui está o construtor
     */
    public Temperatura(double valorT, String unidade){
        this.valorT = valorT;
        this.unidade = unidade;
    }

}
