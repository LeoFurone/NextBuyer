package autobuyer;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Busca {
    Cores cor = new Cores();
    
    public static void Pesquisar(Robot robo) {
        while((!(robo.getPixelColor(780,670).equals(Cores.COR_BUSCAR_SELECIONADO))) && robo.getPixelColor(560, 90).equals(Cores.COR_TELA)){
            robo.delay(500);
            robo.mouseMove(780, 670);
            
            if(robo.getPixelColor(580, 330).equals(Cores.COR_VER_ROBO)){
                System.exit(0);
            }
        }
    }

    public static void atrasarCompra(Robot robo) {
        if (robo.getPixelColor(485, 350).equals(Cores.COR_PESQUISA_DEMORANDO)) {
            robo.delay(600);
        }
    }

    public static void voltar(Robot robo) {
        robo.delay(80);
        robo.mouseMove(100, 135);
        Auto.apertarBotao(robo);
    }

}
