package autobuyer;

import com.sun.glass.events.KeyEvent;
import java.awt.Robot;

public class Jogador {
    private int precoMin;
    private int precoMax;
    
    
    public static void mandarTransf(Robot robo) {
        while (!(robo.getPixelColor(1200, 640).equals(Cores.LIST_TRANSF))) {
            robo.delay(1000);
            robo.mouseMove(1200, 640);
        }
        if (robo.getPixelColor(1200, 640).equals(Cores.LIST_TRANSF)) {
            robo.delay(1000);
            Auto.apertarBotao(robo);
            robo.delay(1000);
        }
    }
    
    public static void listar(Robot robo, String pMin, String pMax){
        while (!(robo.getPixelColor(1250, 510).equals(Cores.LIST_TRANSF))) {
            robo.delay(500);
            robo.mouseMove(1250, 510);
        }
        if (robo.getPixelColor(1250, 510).equals(Cores.LIST_TRANSF)) {
            robo.delay(400);
            Auto.apertarBotao(robo);
            robo.delay(2000);            
            robo.mouseMove(1273, 677); robo.delay(500);            
            robo.mousePress(java.awt.event.KeyEvent.BUTTON1_DOWN_MASK);
            robo.delay(1300);
            robo.mouseRelease(java.awt.event.KeyEvent.BUTTON1_DOWN_MASK);
            
            robo.mouseMove(1120, 315); robo.delay(500);
            Auto.apertarBotao(robo); robo.delay(500);
            Auto.gerarTecla(pMin, robo);
            robo.mouseMove(1130, 370); robo.delay(500);
            Auto.apertarBotao(robo); robo.delay(500);
            Auto.gerarTecla(pMax, robo);
            robo.mouseMove(1212, 465); robo.delay(500);
            Auto.apertarBotao(robo); robo.delay(2000);
        }
    }
}
