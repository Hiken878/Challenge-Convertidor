import java.util.ArrayList;
import java.util.List;


public class MenuPrincipal {
    private Menu menu;
    private final List<Conversion> historialConversiones;

    public MenuPrincipal() {
        menu = new Menu();
        historialConversiones = new ArrayList<>();
    }

    public void showMenu() {
        menu.showMenu(historialConversiones);
    }
}