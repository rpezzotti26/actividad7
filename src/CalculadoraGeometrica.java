import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultados = new ArrayList<>();

        while (true) {
            try {
                int opcionFigura = seleccionarFigura(scanner);
                if (opcionFigura == 8) {
                    System.out.println("¡Adiós!");
                    break;
                } else if (opcionFigura == 7) {
                    mostrarResultados(resultados);
                    continue;
                }

                int opcionOperacion = seleccionarOperacion(scanner);
                double resultado = realizarOperacion(opcionFigura, opcionOperacion, scanner);
                resultados.add(resultado);
                System.out.println("El resultado es: " + resultado);
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
            }
        }
        scanner.close();
    }

    private static int seleccionarFigura(Scanner scanner) {
        System.out.println("Seleccione la figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");

        System.out.println("7. Ver resultados");
        System.out.println("8. Salir");
        return scanner.nextInt();
    }

    private static int seleccionarOperacion(Scanner scanner) {
        System.out.println("Seleccione la operación:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        System.out.println("3. Calcular potencia");
        return scanner.nextInt();
    }

    private static double realizarOperacion(int figura, int operacion, Scanner scanner) {
        switch (figura) {
            case 1:
                return calcularCirculo(operacion, scanner);
            case 2:
                return calcularCuadrado(operacion, scanner);
            case 3:
                return calcularTriangulo(operacion, scanner);
            case 4:
                return calcularRectangulo(operacion, scanner);
            case 5:
                return calcularPentagono(operacion, scanner);
            case 6:
                return calcularPotencia(scanner);
            default:
                System.out.println("Opción no válida.");
                return 0;
        }
    }

    private static double calcularCirculo(int operacion, Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        return (operacion == 1) ? Math.PI * Math.pow(radio, 2) : 2 * Math.PI * radio;
    }

    private static double calcularCuadrado(int operacion, Scanner scanner) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        return (operacion == 1) ? Math.pow(lado, 2) : 4 * lado;
    }

    private static double calcularTriangulo(int operacion, Scanner scanner) {
        System.out.print("Ingrese la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = scanner.nextDouble();
        if (operacion == 1) {
            return (base * altura) / 2;
        } else {
            System.out.print("Ingrese los otros dos lados del triángulo (separados por espacio): ");
            double lado2 = scanner.nextDouble();
            double lado3 = scanner.nextDouble();
            return base + lado2 + lado3;
        }
    }

    private static double calcularRectangulo(int operacion, Scanner scanner) {
        System.out.print("Ingrese la longitud del rectángulo: ");
        double longitud = scanner.nextDouble();
        System.out.print("Ingrese el ancho del rectángulo: ");
        double ancho = scanner.nextDouble();
        return (operacion == 1) ? longitud * ancho : 2 * (longitud + ancho);
    }

    private static double calcularPentagono(int operacion, Scanner scanner) {
        System.out.print("Ingrese el lado del pentágono: ");
        double lado = scanner.nextDouble();
        System.out.print("Ingrese el apotema del pentágono: ");
        double apotema = scanner.nextDouble();
        return (operacion == 1) ? (5 * lado * apotema) / 2 : 5 * lado;
    }

    private static double calcularPotencia(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        int base = scanner.nextInt();
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();
        return potenciaRecursiva(base, exponente);
    }

    private static double potenciaRecursiva(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potenciaRecursiva(base, exponente - 1);
    }

    private static void mostrarResultados(ArrayList<Double> resultados) {
        System.out.println("Resultados almacenados:");
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados almacenados.");
        } else {
            for (int i = 0; i < resultados.size(); i++) {
                System.out.println((i + 1) + ". " + resultados.get(i));
            }
        }
    }
}
