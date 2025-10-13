import java.util.Scanner;
import java.time.LocalDate;

public class pe3 {
    public static void main(String[] args) {
        // Definim variables variables
        int age = 0;
        String selection, name = "", weightInput, heightInput;
        double weight = 0, height = 0;
        Scanner e = new Scanner(System.in);
        boolean working = true;
        while (working) {
            // preguntem que vol fer al usuari
            System.out.println("Introduir dades (a)\r\n" +
                    "Modificar dades (b)\r\n" +
                    "Visualitzar dades (c)\r\n" +
                    "Sortir (d)");
            // prova--
            try {
                selection = e.nextLine();
                switch (selection) {
                    // en cas de haver intruduit 1
                    case "a":
                        // pregunta el nom
                        System.out.println("Introdueix les dades: Nom complet:");
                        name = e.nextLine();
                        // si no es introdueix res es cancela
                        if (name.equals("")) {
                            System.out.println("No deixis el camp buit");
                            break;
                        }
                        // Preguntem la edat
                        System.out.println("Edat:");
                        age = e.nextInt();
                        e.nextLine();
                        // si no es troba dins del rang es cancela
                        if (!(age >= 1 && age <= 120)) {
                            System.out.println("Numero en un rang impossible");
                            age = 0;
                            break;
                        }
                        // preguntem el pes (String) el formatem i el pasem a double
                        System.out.println("Pes (kg):");
                        weightInput = e.nextLine();
                        weightInput = weightInput.replace(',', '.');
                        weight = Double.parseDouble(weightInput);
                        // si el pes no es correcte es cancela
                        if (!(weight <= 200 && weight >= 0.1)) {
                            System.out.println("Numero en un rang impossible");
                            weight = 0;
                            break;
                        }
                        // Preguntem la alçada el formatem i el pasem a double
                        System.out.println("Alçada (m):");
                        heightInput = e.nextLine();
                        heightInput = heightInput.replace(',', '.');
                        height = Double.parseDouble(heightInput);

                        // si no es troba dins del rang es cancela
                        if (!(height >= 0.5 && height <= 2.5)) {
                            System.out.println("Numero en un rang impossible");
                            height = 0;
                            break;
                        } else {
                            System.out.println("Dades introoduides correctament!");
                            break;
                        }
                    case "b":
                        // comprovem
                        if (name.equals("") || age == 0 || weight == 0 || height == 0) {
                            System.out.println("Falta dates, introdoueixles.");
                            break;
                        }

                        System.out.println("Que vols modificar?\r\n Nom:" + name + " (a)\r\n Edat: " + age
                                + "(b)\r\n Pes: " + weight + "(c)\r\n Altura: " + height + "(d)\r\n Sortir (e)");
                        selection = e.nextLine();
                        switch (selection) {
                            case "a":
                                System.out.println("Introdueix les dades: Nom complet:");
                                name = e.nextLine();
                                // si no es introdueix res es cancela
                                if (name.equals("")) {
                                    System.out.println("No deixis el camp buit");
                                    break;
                                }
                                break;
                            case "b":
                                // Preguntem la edat
                                System.out.println("Edat:");
                                age = e.nextInt();
                                e.nextLine();
                                // si no es troba dins del rang es cancela
                                if (!(age >= 1 && age <= 120)) {
                                    System.out.println("Numero en un rang impossible");
                                    break;
                                }
                                break;

                            case "c":
                                // preguntem el pes (String) el formatem i el pasem a double
                                System.out.println("Pes (kg):");
                                weightInput = e.nextLine();
                                weightInput = weightInput.replace(',', '.');
                                weight = Double.parseDouble(weightInput);
                                // si el pes no es correcte es cancela
                                if (!(weight <= 200 && weight >= 1)) {
                                    System.out.println("Numero en un rang impossible");
                                    break;
                                }
                                break;

                            case "d":
                                // Preguntem la alçada el formatem i el pasem a double
                                System.out.println("Alçada (m):");
                                heightInput = e.nextLine();
                                heightInput = heightInput.replace(',', '.');
                                height = Double.parseDouble(heightInput);

                                // si no es troba dins del rang es cancela
                                if (!(height >= 0.5 && height <= 2.5)) {
                                    System.out.println("Numero en un rang impossible");
                                    break;
                                }
                                break;
                            case "e":
                                System.out.println("Gracies");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "c":
                        if (name.equals("") || age == 0 || weight == 0 || height == 0) {
                            System.out.println("Falta dates, introdoueixles.");
                            break;
                        }
                        // fe
                        double imc = weight / (height * height);
                        String category;
                        if (imc < 18.5)
                            category = "pes baix";
                        else if (imc < 25)
                            category = "pes normal";
                        else if (imc < 30)
                            category = "sobrepès";
                        else
                            category = "obesitat";

                        // 🔹 Freqüència cardíaca
                        int fcMax = 220 - age;
                        int fc50 = (int) Math.round(fcMax * 0.5);
                        int fc85 = (int) Math.round(fcMax * 0.85);

                        // 🔹 Aigua recomanada
                        double litres = weight * 35 / 1000.0;

                        // 🔹 Any de naixement
                        int currentYear = LocalDate.now().getYear();
                        int birthYear = currentYear - age;

                        // 🔹 Mostra la informació
                        System.out.printf(
                                "Hola, %s!\r\nEdat: %d anys | Pes: %.2f kg | Alçada: %.2f m \r\nIMC: %.2f (%s)\r\nFC màxima estimada: %d bpm\r\nFC objectiu: %d - %d bpm\r\nAigua recomanada: %.2f L/dia\r\nAny de naixement aproximat: %d\r\n\r\n",
                                name, age, weight, height, imc, category, fcMax, fc50, fc85, litres, birthYear);

                        break;

                    // mostrem un missatge de despedida
                    case "d":
                        System.out.println("Gracies per fer nos us");
                        working = false;
                        break;

                    default:
                        System.out.println("Instrucció invalida");
                        break;
                }
            } catch (

            Exception InputMismatchException) {
                System.out.println("Error: Valor introduit no valid");
            }
        }
        e.close();
        // falta normalitzar el nom
    }
}
