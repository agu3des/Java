import ui.Player;
import ui.UI;

public class ClientPlayer {
	
	public static void main(String[] args) {
		
        System.out.println("ClientPlayer is running.");
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
        
    }

}