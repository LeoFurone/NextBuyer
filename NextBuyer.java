package autobuyer;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

public class NextBuyer {

    public static void main(String[] args) throws AWTException {
        Robot robo = new Robot();
        TelaInicial frame = new TelaInicial();
        frame.setVisible(true);
        
        
        while(true) {
            robo.delay(2000);
            if(Auto.isFechar() == true){
                frame.setVisible(false);
                break;
            }
        }
        
        
                
        /*
        while (true) {  
            if (robo.getPixelColor(580, 330).equals(Cores.COR_VER_ROBO)) {
                System.exit(0);
            }

            Busca.Pesquisar(robo);

            Auto.apertarBotao(robo);

            Auto.comprar(robo);
            if (!(robo.getPixelColor(772, 668).equals(Cores.COR_BUSCAR))) {
                Busca.voltar(robo);
            }

        }*/
    }
}
