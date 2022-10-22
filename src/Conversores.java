public class Conversores {

    /*
    Métodos para conversão
     */

    public static Temperatura converterCelsiusParaKelvin(double valorT){
        valorT += 273.15;
        return new Temperatura(valorT,"K");
    }
    public static Temperatura converterKelvinParaCelsius(double valorT){
        valorT -= 273.15;
        return new Temperatura(valorT,"C");
    }
    public static Temperatura converterCelsiusParaFahrenheit(double valorT){
        valorT = valorT * 9.0/5.0 + 32.0;
        return new Temperatura(valorT,"F");
    }

    public static Temperatura converterFahrenheitParaCelsius(double valorT){
        valorT = (valorT - 32.0) * 5.0/9.0;
        return new Temperatura(valorT,"C");
    }
    public static Temperatura converterKelvinParaFahrenheit(double valorT){
        valorT = (valorT - 273.15) * 9.0/5.0 + 32.0;
        return new Temperatura(valorT,"F");
    }

    public static Temperatura converterFahrenheitParaKelvin(double valorT){
        valorT = (valorT - 32.0) * 5.0/9.0 + 273.15;
        return new Temperatura(valorT,"K");
    }

    public static Temperatura converterFahrenheitParaFahrenheit(double valorT){
        return new Temperatura(valorT,"F");
    }

    public static Temperatura converterKelvinParaKelvin(double valorT){
        return new Temperatura(valorT,"K");
    }

    public static Temperatura converterCelsiusParaCelsius(double valorT){
        return new Temperatura(valorT,"C");
    }
}
