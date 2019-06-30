package autobuyer;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Auto {
    private static int i = 0;
    
    public static void apertarBotao(Robot robo) {
        robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
    }

    public static void comprarJogador(Robot robo) {
        for (int i = 0; i < 10; i++) {
            robo.delay(50);
            Busca.atrasarCompra(robo);
            if (robo.getPixelColor(485, 240).equals(Cores.COR_JOGADOR)) {
                robo.mouseMove(1150, 590);
                robo.delay(250);
                Auto.apertarBotao(robo);
                robo.delay(250);
                robo.mouseMove(737, 465);
                Auto.apertarBotao(robo);
                robo.delay(1500);
                System.out.println("Achou!!");
                
                verificarErro(robo);
                
                if(robo.getPixelColor(1150, 395).equals(Cores.COR_COMPRADO)){
                    Auto.mandarTransf(robo);
                }
                break;
            }
        }
    }

    public static void verificarErro(Robot robo) {
        if ((robo.getPixelColor(1120, 640).equals(Cores.COR_ERRO))) {
            robo.delay(800);
            Busca.voltar(robo);
            atualizar_mercado(robo);
        }
    }

    public static void atualizar_mercado(Robot robo) {
        if (i == 0) {
            robo.mouseMove(687, 532);
            robo.delay(500);
            Auto.apertarBotao(robo);
            i++;
        } else {
            robo.mouseMove(420, 532);
            robo.delay(500);
            Auto.apertarBotao(robo);
            i--;
        }
    }

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

}
