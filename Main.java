import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static int totalPlatosTipicos = 0;
    private static int totalPlatosCarta = 0;
    private static int totalPlatosInternacionales = 0;
    private static double totalValor = 0;
    private static String nombreUsuario;
    private static List<String> platosOrdenados = new ArrayList<>();

    public static void main(String[] args) {
        nombreUsuario = JOptionPane.showInputDialog(null, "Por favor, ingrese su nombre:", "Bienvenido", JOptionPane.QUESTION_MESSAGE);

        int codMenuPpal;
        do {
            String menu = "MENÚ RESTAURANTE\n\n"
                    + "1. Plato Típico\n"
                    + "2. Plato a la carta\n"
                    + "3. Plato internacional\n"
                    + "4. Ver estadísticas\n"
                    + "5. Imprimir factura\n"
                    + "6. Salir\n\n"
                    + "Por favor seleccione una opción: ";

            codMenuPpal = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.PLAIN_MESSAGE));

            switch (codMenuPpal) {
                case 1:
                    menuTipico();
                    break;
                case 2:
                    menuCarta();
                    break;
                case 3:
                    menuInternacional();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    imprimirFactura();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Gracias por su visita, " + nombreUsuario + ". ¡Hasta pronto!", "Despedida", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (codMenuPpal != 6);
    }

    private static void menuTipico() {
        int codMenuTipico;
        do {
            String menuTipico = "MENÚ TÍPICO\n\n"
                    + "1. Frijoles ($12,000)\n"
                    + "2. Sopa de Verduras ($8,000)\n"
                    + "3. Bandeja Paisa ($20,000)\n"
                    + "4. Regresar\n\n"
                    + "Por favor seleccione una opción: ";

            codMenuTipico = Integer.parseInt(JOptionPane.showInputDialog(null, menuTipico, "Menú Típico", JOptionPane.PLAIN_MESSAGE));

            switch (codMenuTipico) {
                case 1:
                    procesarPedido("Frijoles", 12000, "típico");
                    break;
                case 2:
                    procesarPedido("Sopa de Verduras", 8000, "típico");
                    break;
                case 3:
                    procesarPedido("Bandeja Paisa", 20000, "típico");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (codMenuTipico != 4);
    }

    private static void menuCarta() {
        int codMenuCarta;
        do {
            String menuCarta = "MENÚ A LA CARTA\n\n"
                    + "1. Filete de Pescado ($25,000)\n"
                    + "2. Pollo a la Plancha ($22,000)\n"
                    + "3. Lomo de Res ($28,000)\n"
                    + "4. Regresar\n\n"
                    + "Por favor seleccione una opción: ";

            codMenuCarta = Integer.parseInt(JOptionPane.showInputDialog(null, menuCarta, "Menú a la Carta", JOptionPane.PLAIN_MESSAGE));

            switch (codMenuCarta) {
                case 1:
                    procesarPedido("Filete de Pescado", 25000, "carta");
                    break;
                case 2:
                    procesarPedido("Pollo a la Plancha", 22000, "carta");
                    break;
                case 3:
                    procesarPedido("Lomo de Res", 28000, "carta");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (codMenuCarta != 4);
    }

    private static void menuInternacional() {
        int codMenuInternacional;
        do {
            String menuInternacional = "MENÚ INTERNACIONAL\n\n"
                    + "1. Sushi ($30,000)\n"
                    + "2. Pizza ($25,000)\n"
                    + "3. Tacos ($18,000)\n"
                    + "4. Regresar\n\n"
                    + "Por favor seleccione una opción: ";

            codMenuInternacional = Integer.parseInt(JOptionPane.showInputDialog(null, menuInternacional, "Menú Internacional", JOptionPane.PLAIN_MESSAGE));

            switch (codMenuInternacional) {
                case 1:
                    procesarPedido("Sushi", 30000, "internacional");
                    break;
                case 2:
                    procesarPedido("Pizza", 25000, "internacional");
                    break;
                case 3:
                    procesarPedido("Tacos", 18000, "internacional");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (codMenuInternacional != 4);
    }

    private static void procesarPedido(String plato, double precio, String tipo) {
        JOptionPane.showMessageDialog(null, "Se ha solicitado " + plato + ", el costo es de $" + precio, "Pedido", JOptionPane.INFORMATION_MESSAGE);
        platosOrdenados.add(plato + " - $" + precio);
        totalValor += precio;
        switch (tipo) {
            case "típico":
                totalPlatosTipicos++;
                break;
            case "carta":
                totalPlatosCarta++;
                break;
            case "internacional":
                totalPlatosInternacionales++;
                break;
        }
    }

    private static void mostrarEstadisticas() {
        String estadisticas = "ESTADÍSTICAS\n\n"
                + "Total platos típicos: " + totalPlatosTipicos + "\n"
                + "Total platos a la carta: " + totalPlatosCarta + "\n"
                + "Total platos internacionales: " + totalPlatosInternacionales + "\n"
                + "Total platos: " + (totalPlatosTipicos + totalPlatosCarta + totalPlatosInternacionales) + "\n"
                + "Valor total a pagar: $" + totalValor;
        JOptionPane.showMessageDialog(null, estadisticas, "Estadísticas", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void imprimirFactura() {
        StringBuilder factura = new StringBuilder("FACTURA\n\n")
                .append("Cliente: ").append(nombreUsuario).append("\n\n")
                .append("Platos ordenados:\n");

        for (String plato : platosOrdenados) {
            factura.append("- ").append(plato).append("\n");
        }

        factura.append("\nTotal a pagar: $").append(totalValor);
        JOptionPane.showMessageDialog(null, factura.toString(), "Factura", JOptionPane.INFORMATION_MESSAGE);
    }
}
