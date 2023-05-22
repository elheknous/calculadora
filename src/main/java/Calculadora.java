import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- MENU -----");
        System.out.println("1. Operaciones aritméticas");
        System.out.println("2. Ecuación cuadrática");
        System.out.println("3. Figuras geométricas");
        System.out.println("4. Sistema de ecuaciones lineales");
        System.out.println("5. Ecuación de la recta");
        System.out.println("6. Salir");
        System.out.println("----------------");

        System.out.println("Ingrese una opción: ");
        int opcion = verificarOpcion();

        aplicaciones(opcion);
    }

    private static int verificarOpcion() {
        boolean error;
        int u = 0;
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                u = sc.nextInt();
                if (u<1 || u>6){
                    System.err.println("Error, intente de nuevo");
                    error = true;
                }
            }catch (InputMismatchException e){
                System.err.println("Error, intente de nuevo");
                error = true;
            }
        }while (error);
        return u;

    }

    private static void aplicaciones(int opcion) {
        switch (opcion) {
            case 1:
                OperacionesAritmeticas();
                break;
            case 2:
                ecuacionesCuadraticas();
                break;
            case 3:
                figurasGeometricas();
                break;
            case 4:
                sistema();
                break;
            case 5:
                ecuacionDeLaRecta();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;

        }
    }

    private static void ecuacionDeLaRecta() {
        System.out.println("Ingrese las coordenadas del primer punto (x1, y1):");
        double x1 = ingresarNumero();
        double y1 = ingresarNumero();

        System.out.println("Ingrese las coordenadas del segundo punto (x2, y2):");
        double x2 = ingresarNumero();
        double y2 = ingresarNumero();

        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;

        System.out.println("La ecuación de la recta es: Y = " + m + "X + " + b);
    }

    private static void sistema() {
        System.out.println("Ingrese los coeficientes A, B y C de la primera ecuación:");
        double A = ingresarNumero();
        double B = ingresarNumero();
        double C = ingresarNumero();

        System.out.println("Ingrese los coeficientes D, E y F de la segunda ecuación:");
        double D = ingresarNumero();
        double E = ingresarNumero();
        double F = ingresarNumero();

        double determinante = A * E - B * D;

        if (determinante == 0) {
            System.out.println("El sistema de ecuaciones no tiene solución única.");
        } else {
            double x = (C * E - B * F) / determinante;
            double y = (A * F - C * D) / determinante;

            System.out.println("La solución del sistema de ecuaciones es:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }

    private static void figurasGeometricas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- CALCULADORA GEOMÉTRICA -----");
        System.out.println("1. Calcular cuadrado");
        System.out.println("2. Calcular rectángulo");
        System.out.println("3. Calcular circulo");
        System.out.println("4. Calcular esfera");
        System.out.println("5. Calcular cubo");
        System.out.println("6. Calcular cono");
        System.out.println("7. Salir");
        System.out.println("----------------------------------");

        System.out.println("Ingrese una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Cuadrado();
                break;
            case 2:
                rectangulo();
                break;
            case 3:
                circulo();
                break;
            case 4:
                esfera();
                break;
            case 5:
                cubo();
                break;
            case 6:
                cono();
                break;
            case 7:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                break;
        }
    }

    private static void cono() {
        System.out.println("Ingrese el radio de la base del cono: ");
        double radio = validarGeo();

        System.out.println("Ingrese la altura del cono: ");
        double altura = validarGeo();
        double generatriz = Math.sqrt(radio * radio + altura * altura);

        double area = Math.PI * radio * (radio + generatriz);
        double circunferencia = 2 * Math.PI * radio;
        double volumen = (1.0 / 3.0) * Math.PI * radio * radio * altura;

        System.out.println("El área del cono es: " + area);
        System.out.println("La circunferencia de la base del cono es: " + circunferencia);
        System.out.println("El volumen del cono es: " + volumen);
    }

    private static void cubo() {

        System.out.println("Ingrese el lado del cubo: ");
        double lado = validarGeo();

        double area = 6 * lado * lado;;
        double perimetro = 12 * lado;
        double volumen = lado * lado * lado;

        System.out.println("El área del cubo es: " + area);
        System.out.println("El perímetro del cubo es: " + perimetro);
        System.out.println("El volumen del cubo es: " + volumen);
    }

    private static void esfera() {
        System.out.println("Ingrese el radio de la esfera: ");
        double radio = validarGeo();

        double area = 4 * Math.PI * radio * radio;
        double circunferencia = 2 * Math.PI * radio;
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);

        System.out.println("El área de la esfera es: " + area);
        System.out.println("La circunferencia de la esfera es: " + circunferencia);
        System.out.println("El volumen de la esfera es: " + volumen);
    }

    private static void circulo() {
        System.out.println("Ingrese el radio del círculo: ");
        double radio = validarGeo();
        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;
        System.out.println("El área del círculo es: " + area);
        System.out.println("El perímetro del círculo es: " + perimetro);
    }

    private static void rectangulo() {
        System.out.println("Ingrese el lado del rectangulo: ");
        double lado = validarGeo();
        System.out.println("Ingrese el otro lado del rectangulo: ");
        double lado1 = validarGeo();


        System.out.println("El área del rectangulo es: " + (lado*lado1));
        System.out.println("El perímetro del rectangulo es: " + (lado*2+lado1*2));
    }

    private static void Cuadrado() {
        System.out.println("Ingrese el lado del cuadrado: ");
        double lado = validarGeo();

        System.out.println("El área del cuadrado es: " + (lado*lado));
        System.out.println("El perímetro del cuadrado es: " + (lado*4));

    }

    private static double validarGeo() {
        boolean error;
        int u = 0;
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                u = sc.nextInt();
                if (u<1){
                    System.err.println("Error, intente de nuevo");
                    error = true;
                }
            }catch (InputMismatchException e){
                System.err.println("Error, intente de nuevo");
                error = true;
            }
        }while (error);
        return u;
    }

    private static void ecuacionesCuadraticas() {

        System.out.println("Ingrese el coeficiente a:");
        double a = (double) ingresarNumero();

        System.out.println("Ingrese el coeficiente b:");
        double b = (double) ingresarNumero();

        System.out.println("Ingrese el coeficiente c:");
        double c = (double) ingresarNumero();

        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las raíces son: x1 = " + x1 + " y x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("La raíz doble es: x = " + x);
        } else {
            System.out.println("La ecuación no tiene soluciones reales.");
        }
    }

    private static void OperacionesAritmeticas() {
        double num1 = ingresarNumero();
        double num2 = ingresarNumero();
        suma(num1,num2);
        resta(num1,num2);
        multiplicacion(num1,num2);
        division(num1,num2);
        mayor(num1,num2);
        menor(num1,num2);
        porcentaje(num1,num2);

    }

    private static void multiplicacion(double num1, double num2) {
        System.out.println("La multiplicacion es: "+ (num1*num2));

    }
    private static void division(double num1, double num2) {
        double aux = num1/num2;
        System.out.println("La division es: "+ aux);

    }
    private static void mayor(double num1, double num2) {
        if (num1 > num2){
            System.out.println("El numero mayor es: "+num1);
        }else {
            System.out.println("El numero mayor es : "+num2);
        }
    }
    private static void menor(double num1, double num2) {
        if (num1 < num2){
            System.out.println("El numero menor es: "+num1);
        }else {
            System.out.println("El numero menor es : "+num2);
        }

    }

    private static void porcentaje(double num1, double num2) {
        float aux = (float)(num2/100.0);
        float por =  (float) num1 ;
        System.out.println("El "+num2+" porciento de "+num1+" es: "+(por*aux));
    }

    private static void suma(double num1, double num2) {
        System.out.println("La suma es: "+ (num1+num2));
    }
    private static void resta(double num1, double num2) {
        System.out.println("La resta es: "+ (num1-num2));

    }
    private static double ingresarNumero() {
        boolean error;
        double u = 0.0;
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese un numero: ");
                u = sc.nextDouble();
            }catch (InputMismatchException e){
                System.err.println("Error, intente de nuevo");
                error = true;
            }
        }while (error);
        return u;
    }
}
