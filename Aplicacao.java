package autobuyer;

import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JOptionPane;

public class Aplicacao {

    public static void sortaNois() throws AWTException {
        Robot robo = new Robot();
        Cores cor = new Cores();
        robo.delay(2000);

        while (robo.getPixelColor(560, 90).equals(Cores.COR_TELA)) {
            if (robo.getPixelColor(580, 330).equals(Cores.COR_VER_ROBO)) {
                JOptionPane.showMessageDialog(null, "Vamos ter que verificar que não sou um robô. Sendo assim, NextBuyer se encerrou.");
                System.exit(0);
            }
            
            Busca.Pesquisar(robo);

            Auto.apertarBotao(robo);

            Auto.comprar(robo);

            if (!(robo.getPixelColor(772, 668).equals(Cores.COR_BUSCAR))) {
                Busca.voltar(robo);
            }
        }
        
        JOptionPane.showMessageDialog(null, "Não estamos na tela do WebApp. Sendo assim, NextBuyer se encerrou.");
    }
}
