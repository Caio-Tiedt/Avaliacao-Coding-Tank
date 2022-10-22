import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        /*
        Inicialização
         */

        apresentacaoDoPrograma();

        int numeroDeTemperaturas = quantidadeDeTemperaturas();

        Temperatura[] temperaturas = new Temperatura[numeroDeTemperaturas];
        System.out.println();

        String unidadeEntrada = inputDaUnidadeDeEntrada();


        for (int i=0; i<numeroDeTemperaturas;i++){
            System.out.println("Defina o valor da "+(i+1)+"-ésima temperatura: ");
            temperaturas[i] = setarValorDaTemperatura(unidadeEntrada);
        }

        System.out.println();
        String unidadeSaida = inputDaUnidadeDeSaida();
        System.out.println("\n");

        Temperatura[] temperaturasConvertidas = new Temperatura[numeroDeTemperaturas];
        for (int i=0; i<numeroDeTemperaturas;i++){
            temperaturasConvertidas[i] =  conversorCasos(temperaturas[i],unidadeEntrada,unidadeSaida);
        }

        /*
        Apresentação dos resultados
         */

        System.out.println("Você escolheu como unidade de entrada "+Unidades.valorExtensoUnidade(unidadeEntrada));
        System.out.print("As Temperaturas de entrada foram: ");
        for (int i=0; i<numeroDeTemperaturas;i++){
            System.out.print(temperaturas[i].getvalorT()+" "+temperaturas[i].getUnidade()+"; ");
        }
        System.out.println();
        System.out.printf("A média das temperaturas de entrada ficou %.4f",CalcMedia.mediaTemperaturas(temperaturas));
        System.out.println(" "+unidadeEntrada);
        System.out.println();



        System.out.println("Você escolheu como unidade de saída "+Unidades.valorExtensoUnidade(unidadeSaida));
        System.out.print("As Temperaturas convertidas ficaram: ");
        for (int i=0; i<numeroDeTemperaturas;i++){
            System.out.print(temperaturasConvertidas[i].getvalorT()+" "+temperaturasConvertidas[i].getUnidade()+"; ");
        }
        System.out.println();
        System.out.printf("A média das temperaturas convertidas ficou %.4f",CalcMedia.mediaTemperaturas(temperaturasConvertidas));
        System.out.println(" "+unidadeSaida);
        System.out.println();


        /*
        Finalização
         */
        fimDoPrograma();

    }

    public static void apresentacaoDoPrograma(){
        System.out.println("Bem vindo ao programa de converter temperaturas");
        System.out.println();
    }

    public static int quantidadeDeTemperaturas(){
        System.out.print("Por favor Digite o número de temperaturas que você deseja converter: ");

        try {
            Scanner sc = new Scanner(System.in);
            int quanidade = sc.nextInt();
            if (quanidade < 1){
                throw new RuntimeException("Quantidade de temperaturas tem que ser inteiro positivo;");
            }
            return quanidade;
        } catch (InputMismatchException exception){
            System.err.println("Exceção na quantidade de Temperaturas, foi passado valor default"+exception);
            System.out.println("Quantidade de temperaturas deve ser número inteiro");
            System.out.println("Para rodar o código damos um valor default de 1");
            return 1;
        }
    }

    public static String inputDaUnidadeDeEntrada(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Agora iremos ver quais unidades de temperatura iremos converter");
        System.out.println("Unidades reconhecidas: C para Celsius, F para Farenheit e K para Kelvin");
        System.out.println("Qual unidade de temperatura você deseja de entrada?");
        String unidade = sc.nextLine();

        boolean verificadorDevoTentarDeNovo = true;

        while (verificadorDevoTentarDeNovo) {
            if (checarSeUnidadeEhValida(unidade)) {
                System.out.println("Unidade Válida");
                verificadorDevoTentarDeNovo=false;
            } else {
                System.out.println("Unidade Não reconhecida, tente novamente.");
                System.out.println("Qual unidade de temperatura você deseja de entrada?");
                unidade = sc.nextLine();
            }
        }
        return unidade;
    }

    public static String inputDaUnidadeDeSaida(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite agora a unidade de temperatura que você quer de saída: ");
        String unidade = sc.nextLine();

        boolean verificadorDevoTentarDeNovo = true;

        while (verificadorDevoTentarDeNovo) {
            if (checarSeUnidadeEhValida(unidade)) {
                System.out.println("Unidade Válida");
                verificadorDevoTentarDeNovo=false;
            } else {
                System.out.println("Unidade Não reconhecida, tente novamente.");
                System.out.println("Qual unidade de temperatura você deseja de saída?");
                unidade = sc.nextLine();
            }
        }
        return unidade;
    }


    public static boolean checarSeUnidadeEhValida(String unidade){
        return Objects.equals(unidade, "C") || Objects.equals(unidade, "F") || Objects.equals(unidade, "K");
    }

    public static Temperatura setarValorDaTemperatura(String unidade){
        System.out.print("Digite o valor da temperatura: ");
        try {
            Scanner sc = new Scanner(System.in);
            double valorT = sc.nextDouble();
            return new Temperatura(valorT,unidade);
        } catch (InputMismatchException exception){
            System.err.println("Exceção no valor de Temperaturas"+exception);
            System.out.println("Valor da temperatura deve ser um número");
            System.out.println("Para rodar o código damos um valor default de 27");
            return new Temperatura(27.0,unidade);
        }

    }

    public static Temperatura conversorCasos(Temperatura temperatura, String unitEntrada, String unitSaida){
        switch (unitEntrada){
            case "C":
                switch (unitSaida){
                    case "C":
                       return Conversores.converterCelsiusParaCelsius(temperatura.getvalorT());
                    case "F":
                        return Conversores.converterCelsiusParaFahrenheit(temperatura.getvalorT());
                    case "K":
                        return Conversores.converterCelsiusParaKelvin(temperatura.getvalorT());
                }
            case "F":
                switch (unitSaida){
                    case "C":
                        return Conversores.converterFahrenheitParaCelsius(temperatura.getvalorT());
                    case "F":
                        return Conversores.converterFahrenheitParaFahrenheit(temperatura.getvalorT());
                    case "K":
                        return Conversores.converterFahrenheitParaKelvin(temperatura.getvalorT());
                }
            case "K":
                switch (unitSaida){
                    case "C":
                        return Conversores.converterKelvinParaCelsius(temperatura.getvalorT());
                    case "F":
                        return Conversores.converterKelvinParaFahrenheit(temperatura.getvalorT());
                    case "K":
                        return Conversores.converterKelvinParaKelvin(temperatura.getvalorT());
                }
            default:
                System.out.println("Algo deu errado com as unidades. :(, retornando o valor inicial.");
                return temperatura;
        }

    }


    public static void fimDoPrograma(){
        System.out.println("Fim do programa de converter temperaturas!!!");
        System.out.println(":)");
    }



}
