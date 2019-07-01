package autobuyer;

import java.awt.AWTKeyStroke;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Auto {

    private static int i = 0;

 
   public static void apertarBotao(Robot robo) {
        robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
    }
    public static void comprar(Robot robo) {
        for (int l = 0; l < 10; l++) {
            robo.delay(50);
            Busca.atrasarCompra(robo);
            if (robo.getPixelColor(485, 240).equals(Cores.COR_JOGADOR)) {
                robo.mouseMove(1150, 590);
                robo.delay(250);
                Auto.apertarBotao(robo);
                robo.delay(250);
                robo.mouseMove(737, 465);
                Auto.apertarBotao(robo);
                System.out.println("Achou!!");
                Toolkit.getDefaultToolkit().beep();
                
                robo.delay(5000);
                
                verificarErro(robo);

                if (robo.getPixelColor(165,245).equals(Cores.COR_COMPRADO)) {
                    Jogador.listar(robo, "5500", "5600");
                }
                break;
            }
        }
    }

    public static void verificarErro(Robot robo) {
        if ((robo.getPixelColor(165, 245).equals(Cores.COR_ERRO))) {
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

    public static void gerarTecla(String p, Robot robo) {
        char[] cMin = p.toCharArray();

        for (int j = 0; j < cMin.length; j++) {
            robo.delay(300);
            switch (cMin[j]) {
                case '0':
                    robo.keyPress(KeyEvent.VK_0);
                    robo.keyRelease(KeyEvent.VK_0);
                    break;

                case '1':
                    robo.keyPress(KeyEvent.VK_1);
                    robo.keyRelease(KeyEvent.VK_1);
                    break;

                case '2':
                    robo.keyPress(KeyEvent.VK_2);
                    robo.keyRelease(KeyEvent.VK_2);
                    break;

                case '3':
                    robo.keyPress(KeyEvent.VK_3);
                    robo.keyRelease(KeyEvent.VK_3);
                    break;

                case '4':
                    robo.keyPress(KeyEvent.VK_4);
                    robo.keyRelease(KeyEvent.VK_4);
                    break;

                case '5':
                    robo.keyPress(KeyEvent.VK_5);
                    robo.keyRelease(KeyEvent.VK_5);
                    break;

                case '6':
                    robo.keyPress(KeyEvent.VK_6);
                    robo.keyRelease(KeyEvent.VK_6);
                    break;

                case '7':
                    robo.keyPress(KeyEvent.VK_7);
                    robo.keyRelease(KeyEvent.VK_7);
                    break;

                case '8':
                    robo.keyPress(KeyEvent.VK_8);
                    robo.keyRelease(KeyEvent.VK_8);
                    break;

                case '9':
                    robo.keyPress(KeyEvent.VK_9);
                    robo.keyRelease(KeyEvent.VK_9);
                    break;

            }
        }
    }

}
