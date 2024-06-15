import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    private HashMap<Integer, String> currencyCodes;
    private List<Conversion> historialConversiones;

    public Menu() {
        currencyCodes = new HashMap<>();
        // Códigos de Monedas
        currencyCodes.put(1,"USD");
        currencyCodes.put(2,"CAD");
        currencyCodes.put(3,"EUR");
        currencyCodes.put(4,"ARS");
        currencyCodes.put(5,"BRL");

    }

    public void showMenu(List<Conversion> historialConversiones) {
        String fromCode, toCode;
        double amount;

        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        while (continuar) {
            try {
                // Cabecera del programa
                System.out.println("**********************************");
                System.out.println("Bienvenido al conversor de monedas");
                System.out.println("***********************************");
                // Moneda origen a convertir
                System.out.println("Seleccione la Moneda Origen a convertir");
                System.out.println("1:USD (Dollar Americano) 2:CAD (Dollar Canadiense) 3:EUR (Euro) 4:ARS (Peso Argentino) 5:BRL (Real Brasileño)");
                fromCode = currencyCodes.get(sc.nextInt());
                // Moneda a convertir
                System.out.println("Seleccione la Moneda Destino a convertir");
                System.out.println("1:USD (Dollar Americano) 2:CAD (Dollar Canadiense) 3:EUR (Euro) 4:ARS (Peso Argentino) 5:BRL (Real Brasileño)");
                toCode = currencyCodes.get(sc.nextInt());
                // Cantidad a convertir
                System.out.println("Ingrese la cantidad a convertir");
                amount = sc.nextDouble();

                Cambio cambio = new Cambio();
                double resultado = cambio.convertir(fromCode, toCode, amount);

                // Registro de la conversión
                LocalDateTime fechaHora = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaHoraFormateada = fechaHora.format(formatter);
                Conversion conversion = new Conversion(fromCode, toCode, amount, resultado, fechaHoraFormateada);
                historialConversiones.add(conversion);

                System.out.println("Gracias por usar el convertidor de moneda");
                System.out.println("Historial de conversiones:");
                for (Conversion c : historialConversiones) {
                    System.out.println(c.toString());
                }

                System.out.println("¿Desea realizar otra conversión? (S/N)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}