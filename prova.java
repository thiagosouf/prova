import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Converter Temperatura");
            System.out.println("================");
            int tamanho = escolherTamanho(sc);
            String origem = escolherUnidadeDeEntrada(sc);
            String resultado = escolherUnidadeDeSaida(sc);
            if (origem == resultado) {
                System.out.println("Escolha uma unidade de saida diferente da unidade de origem");
                resultado = escolherUnidadeDeSaida(sc);
            }
            converterTemperatura(sc, tamanho, origem, resultado);

        } catch (RuntimeException e) {
            System.out.println("Dados Incorretos!");
        }

    }

    public static void converterTemperatura(Scanner sc, int tamanho, String origem, String resultado) {
        double[] temperatura = new double[tamanho];
        double mediaInicial = 0;
        double mediaFinal = 0;

        for (int i = 0; i < tamanho; i++) {
            System.out.printf("Entre com a " + (i + 1) + "° temperatura: ");
            try {
                temperatura[i] = sc.nextDouble();
                mediaInicial = mediaInicial + temperatura[i];

            } catch (Exception e) {
                sc.next();
                System.out.println("Temperatura não identificada");
                System.out.println("Entre novamente com as temperaturas desejadas: ");
                temperatura = new double[tamanho];
                converterTemperatura(sc, tamanho, origem, resultado);
                System.exit(0);

            }
        }

        if (origem == "Celsius" && resultado == "Kelvin") {
            System.out.println("converter de Celsius para kelvin");
            mediaFinal = converterCK(sc, tamanho, temperatura);
        } else if (origem == "Celsius" && resultado == "Fahrenheit") {
            System.out.println("converter de Celsius para Fahrenheit");
            mediaFinal = converterCF(sc, tamanho, temperatura);
        } else if (origem == "Kelvin" && resultado == "Celsius") {
            System.out.println("converter de Kelvin para Celsius");
            mediaFinal = converterKC(sc, tamanho, temperatura);
        } else if (origem == "Kelvin" && resultado == "Fahrenheit") {
            System.out.println("converter de Kelvin para Fahrenheit");
            mediaFinal = converterKF(sc, tamanho, temperatura);
        } else if (origem == "Fahrenheit" && resultado == "Kelvin") {
            System.out.println("converter de Fahrenheit para Kelvin");
            mediaFinal = converterFK(sc, tamanho, temperatura);
        } else if (origem == "Fahrenheit" && resultado == "Celsius") {
            System.out.println("converter de Fahrenheit para Celsius");
            mediaFinal = converterFC(sc, tamanho, temperatura);
        } else {
            System.out.println("Escolha duas unidades validas e distintas");
        }

        System.out.println("Media das temperaturas antes da conversão: " + (mediaInicial / tamanho));
        System.out.println("Media das temperaturas depois da conversão: " + (mediaFinal / tamanho));

    }

    public static double converterFC(Scanner sc, int tamanho, double[] temperatura) {
        double mediaFinal = 0;
        for (int i = 0; i < tamanho; i++) {
            double kelvin = (temperatura[i] - 32) / 1.8;
            mediaFinal = mediaFinal + kelvin;
            System.out.println("De " + temperatura[i] + "ºF para " + kelvin + "ºC");
        }
        return mediaFinal;
    }

    public static double converterFK(Scanner sc, int tamanho, double[] temperatura) {
        double mediaFinal = 0;
        for (int i = 0; i < tamanho; i++) {
            double kelvin = (temperatura[i] - 32) * 5 / 9 + 273;
            mediaFinal = mediaFinal + kelvin;
            System.out.println("De " + temperatura[i] + "ºF para " + kelvin + "K");
        }
        return mediaFinal;
    }

    public static double converterKF(Scanner sc, int tamanho, double[] temperatura) {
        double mediaFinal = 0;
        for (int i = 0; i < tamanho; i++) {
            double kelvin = (temperatura[i] - 273) * 1.8 + 32;
            mediaFinal = mediaFinal + kelvin;
            System.out.println("De " + temperatura[i] + "K para " + kelvin + "ºF");
        }
        return mediaFinal;
    }

    public static double converterKC(Scanner sc, int tamanho, double[] temperatura) {
        double mediaFinal = 0;
        for (int i = 0; i < tamanho; i++) {
            double kelvin = temperatura[i] - 273;
            mediaFinal = mediaFinal + kelvin;
            System.out.println("De " + temperatura[i] + "K para " + kelvin + "ºC");
        }
        return mediaFinal;
    }

    public static double converterCF(Scanner sc, int tamanho, double[] temperatura) {
        double mediaFinal = 0;
        for (int i = 0; i < tamanho; i++) {
            double kelvin = temperatura[i] * 1.8 + 32;
            mediaFinal = mediaFinal + kelvin;
            System.out.println("De " + temperatura[i] + "ºC para " + kelvin + "ºF");
        }
        return mediaFinal;
    }

    public static double converterCK(Scanner sc, int tamanho, double[] temperatura) {
        double mediaFinal = 0;
        for (int i = 0; i < tamanho; i++) {
            double kelvin = temperatura[i] + 273;
            mediaFinal = mediaFinal + kelvin;
            System.out.println("De " + temperatura[i] + "ºC para " + kelvin + "K");
        }
        return mediaFinal;
    }

    public static String escolherUnidadeDeEntrada(Scanner sc) {
        System.out.println("Escolha a unidade da temperatura de entrada: ");
        System.out.println("[1] Celsius");
        System.out.println("[2] Kelvin");
        System.out.println("[3] Fahrenheit");
        try {
            int escolha = sc.nextInt();
            if (escolha == 1) {
                System.out.println("Celsius");
                return "Celsius";
            } else if (escolha == 2) {
                System.out.println("Kelvin");
                return "Kelvin";
            } else if (escolha == 3) {
                System.out.println("Fahrenheit");
                return "Fahrenheit";
            } else {
                System.out.println("Dados Incorretos!");
                escolherUnidadeDeEntrada(sc);
            }

        } catch (Exception e) {
            System.out.println("Escolha um numero");
            sc.next();
            escolherUnidadeDeEntrada(sc);
        }
        return null;
    }

    public static String escolherUnidadeDeSaida(Scanner sc) {
        System.out.println("Escolha a unidade da temperatura de saida: ");
        System.out.println("[1] Celsius");
        System.out.println("[2] Kelvin");
        System.out.println("[3] Fahrenheit");
        try {
            int escolha = sc.nextInt();
            if (escolha == 1) {
                System.out.println("Celsius");
                return "Celsius";
            } else if (escolha == 2) {
                System.out.println("Kelvin");
                return "Kelvin";
            } else if (escolha == 3) {
                System.out.println("Fahrenheit");
                return "Fahrenheit";
            } else {
                System.out.println("Dados Incorretos!");
                escolherUnidadeDeSaida(sc);
            }

        } catch (Exception e) {
            System.out.println("Escolha um numero");
            sc.next();
            escolherUnidadeDeSaida(sc);
        }
        return null;
    }

    public static int escolherTamanho(Scanner sc) {
        System.out.println("Quantas temperaturas voce deseja converter?");
        int tamanho = sc.nextInt();
        return tamanho;
    }

}
