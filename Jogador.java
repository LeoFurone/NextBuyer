package autobuyer;

import java.awt.Robot;

public class Jogador {
    private static String precoMin;
    private static String precoMax;
    private static boolean confusao;

    public static void setConfusao(boolean confusao) {
        Jogador.confusao = confusao;
    }
    
    
    public static void transfJogador(Robot robo) {
        while (!(robo.getPixelColor(1200, 640).equals(Cores.LIST_TRANSF))) {
            robo.delay(1000);
            robo.mouseMove(1200, 640);
        }
        if (robo.getPixelColor(1200, 640).equals(Cores.LIST_TRANSF)) {
            robo.delay(1000);
            Auto.apertarBotao(robo);
            robo.delay(1000);
            Busca.voltar(robo);
            robo.delay(1500);
            Auto.atualizarMercadoJog(robo);
        }
    }
    
    public static void listarJogador(Robot robo){
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
            if(confusao == true){
                Auto.gerarTecla(Auto.gerarConfusao(precoMin), robo);
            } else {
                Auto.gerarTecla(precoMin, robo);
            }
            robo.mouseMove(1130, 370); robo.delay(500);
            Auto.apertarBotao(robo); robo.delay(500);
            Auto.gerarTecla(precoMax, robo);
            robo.mouseMove(1212, 465); robo.delay(500);
            Auto.apertarBotao(robo); robo.delay(2000);
            
            Busca.voltar(robo);
            Auto.atualizarMercadoJog(robo);
        }
    }

    public static String getPrecoMin() {
        return precoMin;
    }

    public static void setPrecoMin(String precoMin) {
        Jogador.precoMin = precoMin;
    }

    public static String getPrecoMax() {
        return precoMax;
    }

    public static void setPrecoMax(String precoMax) {
        Jogador.precoMax = precoMax;
    }
    
}
