package autobuyer;

import java.awt.AWTException;
import java.awt.Robot;

public class AutoBuyer {

    public static void main(String[] args) throws AWTException {
        Robot robo = new Robot();
        Cores cor = new Cores();
        robo.delay(2000);
        
        while (true) {
            Busca.Pesquisar(robo);
            
            Auto.apertarBotao(robo);

            Auto.comprarJogador(robo);

            if(!(robo.getPixelColor(772, 668).equals(Cores.COR_BUSCAR) )) {
                Busca.voltar(robo);
            }

        }
    }
}
