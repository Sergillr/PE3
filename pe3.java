import java.util.Scanner;

public class pe3 {
    public static void main(String[] args) {
        int selection, age;
        double weight, height;
        String name;
        System.out.println("Introduir dades (1)\r\n" + //
                "Modificar dades (2)\r\n" + //
                "Visualitzar dades (3)\r\n" + //
                "");
        Scanner e = new Scanner(System.in);
        try {
            selection = e.nextInt();
            e.nextLine();
            switch (selection) {
                case 1:
                    System.out.println("Introdueix les dades: Nom complet:");
                    name = e.nextLine();
                    if (name.equals("")) {
                        System.out.println("No deixis el camp buit");
                        break;
                    }
                    System.out.println("Edat:");
                    age = e.nextInt();
                    if (!(age >= 1 && age <= 120)) {
                        System.out.println("Numero en un rang impossible");
                        break;
                    }
                    System.out.println("Pes (kg):");
                    weight = e.nextDouble();
                    if (!(weight <= 200 && weight >=0)) {
                        System.out.println("Numero en un rang impossible");
                        break;
                    }
                    System.out.println("Alçada (m):");
                    height = e.nextDouble();
                    if(!(height>=0.5 && height <=2.5)){
                        System.out.println("Numero en un rang impossible");
                        break;

                    }
                    break;
                case 2:
                    System.out.println("hola 2");
                    break;
                case 3:
                    System.out.println("hola 3");
                    break;
                default:
                    System.out.println("Numero invalid");
                    break;
            }
        } catch (

        Exception InputMismatchException) {
            System.out.println("Valor introduit erroni");
        }
        e.close();
    }
}
