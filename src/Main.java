import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class Main {

    private static TreeSet<Zona> zonas = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.println(menu());
                int opc = parseInt(in.nextLine());
                System.out.println();
                switch (opc) {
                    case 1:
                        regZona(in);
                        break;
                    case 2:
                        addSensor(in);
                        break;
                    case 3:
                        imprimirRelatorio(in);
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        in.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        System.out.println();
                }
            } catch (Exception e){
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println( );
                continue;
            }
        }
    }
    private static String menu() {
        return "1 - Registrar Zona\n" +
                "2 - Adicionar Sensor\n" +
                "3 - Imprimir relatório\n" +
                "4 - Sair\n" +
                "Escolha uma opção: ";
    }

    private static void regZona(Scanner in) {
        while(true){
            try{
                System.out.println("1 - Zona rural\n" +
                        "2 - Zona urbana\n" +
                        "Insira o tipo de zona: ");
                int opc = parseInt(in.nextLine());

                if (opc < 1 || opc > 2) {
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
                    continue;
                }

                System.out.println();
                System.out.println("Insira o nome da zona: ");
                String nome = in.nextLine();

                if (opc == 1) {
                    Zona zona = new ZonaRural(nome);
                    zonas.add(zona);
                    System.out.println("Zona rural registrada: " + zona.getNome());
                } else {
                    Zona zona = new ZonaUrbana(nome);
                    zonas.add(zona);
                    System.out.println("Zona urbana registrada: " + zona.getNome());
                }
                System.out.println();
                return;

            }catch (Exception e){
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println();
                continue;
            }
        }
    }

    private static void addSensor(Scanner in) {
        while(true){
            try{
                System.out.println("Insira o nome da zona: ");
                String nomeZona = in.nextLine();
                System.out.println();
                Zona zona = buscaZona(nomeZona);

                if (zona == null) {
                    System.out.println("Zona não encontrada. Tente novamente.");
                    System.out.println();
                    return;
                }

                if(zona instanceof ZonaRural) {
                    System.out.println("Esta zona é rural, logo não é possível adicionar sensores.");
                    System.out.println();
                    return;
                } 

                // Selmini eu juro q fui eu q fiz isso, não foi robo
                ((ZonaUrbana) zona).addSensor(
                    new Sensor(
                        (int)(Math.random()* 100), // Isso eu pesquisei, mas foi no stackoverflow
                        "0000/00/00",
                        Math.random() *500));
                
                System.out.println("Sensor adicionado à zona: " + zona.getNome());
                System.out.println();
                return;

            } catch (Exception e){
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }
        }
    }

    private static void imprimirRelatorio(Scanner in) {
        System.out.println("Insira o nome da zona: ");
        String nomeZona = in.nextLine();
        System.out.println();
        Zona zona = buscaZona(nomeZona);
        if (zona == null) {
            System.out.println("Zona não encontrada.");
            System.out.println();
            return;
        }
        String str = "";
        if(zona instanceof ZonaUrbana){
            double media = ((ZonaUrbana) zona).calcularMedia();
            if (media >300){
                str += ">>> ALERTA EXTREMO: Média crítica ultrapassada!\n";
            }
        }
        System.out.println(zona.relatorio() + str);
        System.out.println();
        return;
    }

    private static Zona buscaZona(String nomeZona) {
        for (Zona z : zonas) {
            if (z.getNome().equals(nomeZona)) {
                return z;
            }
        }
        return null;
    }
}
