package autobuyer;

import java.awt.AWTKeyStroke;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Auto {
    
    private static boolean lista;
    private static boolean fechar;
    private static boolean tipo;
    private static String ItemMin;
    private static String ItemMax;
    private static boolean i;
    private static boolean confusao;

    public static void setLista(boolean lista) {
        Auto.lista = lista;
    }
    
    public static boolean isFechar() {
        return fechar;
    }

    public static void setFechar(boolean fechar) {
        Auto.fechar = fechar;
    }
    
    
    public static void setTipo(boolean tipo) {
        Auto.tipo = tipo;
    }
    
    public static void setItemMin(String ItemMin) {
        Auto.ItemMin = ItemMin;
    }

    public static void setItemMax(String ItemMax) {
        Auto.ItemMax = ItemMax;
    }
    
    public static void setConfusao(boolean confusao) {
        Auto.confusao = confusao;
    }
    
    
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

                if (robo.getPixelColor(165, 245).equals(Cores.COR_COMPRADO)) {
                    for (int q = 0; q < 10; q++) {
                        Busca.atrasarCompra(robo);
                    }
                    
                    if(tipo == true){
                        if(lista == false){
                        Jogador.listarJogador(robo);
                        } else {
                            Jogador.transfJogador(robo);
                        }
                    } else {
                        if(lista == false) {
                            Auto.listarItem(robo);
                        } else {
                            Auto.tranfCons(robo);
                        }
                    }
                }
                break;
            }
        }
    }
    
    public static void tranfCons(Robot robo){
        while (!(robo.getPixelColor(1200, 610).equals(Cores.LIST_TRANSF))) {
            robo.delay(1000);
            robo.mouseMove(1200, 610);
        }
        if (robo.getPixelColor(1200, 610).equals(Cores.LIST_TRANSF)) {
            robo.delay(1000);
            Auto.apertarBotao(robo);
            robo.delay(1000);
            Busca.voltar(robo);
            robo.delay(1500);
            Auto.atualizarMercadoJog(robo);
        }
    }

    public static void verificarErro(Robot robo) {
        if ((robo.getPixelColor(165, 245).equals(Cores.COR_ERRO)) || (robo.getPixelColor(1125, 206).equals(Cores.COR_ERRO))) {
            robo.delay(800);
            Busca.voltar(robo);
            atualizarMercadoJog(robo);
        }
    }

    public static void atualizarMercadoJog(Robot robo) {
        if (i == false) {
            robo.mouseMove(687, 532);
            robo.delay(2000);
            Auto.apertarBotao(robo);
            i = true;
        } else {
            robo.mouseMove(420, 532);
            robo.delay(2000);
            Auto.apertarBotao(robo);
            i = false;
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

    public static void listarItem(Robot robo) {
        while (!(robo.getPixelColor(1250, 510).equals(Cores.LIST_TRANSF))) {
            robo.delay(500);
            robo.mouseMove(1250, 510);
        }
        if (robo.getPixelColor(1250, 510).equals(Cores.LIST_TRANSF)) {
            robo.delay(400);
            Auto.apertarBotao(robo);
            robo.delay(2000);
            robo.mouseMove(1273, 677);
            robo.delay(500);
            robo.mousePress(java.awt.event.KeyEvent.BUTTON1_DOWN_MASK);
            robo.delay(1300);
            robo.mouseRelease(java.awt.event.KeyEvent.BUTTON1_DOWN_MASK);

            robo.mouseMove(1140, 340);
            robo.delay(500);
            Auto.apertarBotao(robo);
            robo.delay(500);
            if(confusao == true){
                Auto.gerarTecla(Auto.gerarConfusao(ItemMin), robo);
            } else {
                Auto.gerarTecla(ItemMin, robo);
            }
            robo.mouseMove(1140, 400);
            robo.delay(500);
            Auto.apertarBotao(robo);
            robo.delay(500);
            Auto.gerarTecla(ItemMax, robo);
            robo.mouseMove(1215, 500);
            robo.delay(500);
            Auto.apertarBotao(robo);
            robo.delay(2000);
        }
    }

    public static String gerarConfusao(String p) {
        int a = Integer.parseInt(p);

        double b = Math.floor(Math.random() * 3);
        int c = a - ((int) b * 100);

        String d = Integer.toString(c);

        return d;
    }
    
    
}
