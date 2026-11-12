import java.util.Random;

public class Invernadero {


    Random rand = new Random();
    volatile int temperatura;
    volatile boolean disponible;
    volatile boolean cerrado;


    public void publicar(int valor) {
        while (disponible) {
            Thread.onSpinWait();
        }
        temperatura = valor;
        disponible = true;
    }

    public boolean esperarMedicion() {
        boolean avisado = false;
        while (true) {
            boolean fin = cerrado;      // se lee ANTES que 'disponible' para no perder la ultima medicion
            if (disponible) return true;
            if (fin) return false;
            if (!avisado) {
                System.out.println("[CONTROL] esperando medicion...");
                avisado = true;
            }
            Thread.onSpinWait();
        }
    }

    public int leer() {
        int valor = temperatura;
        disponible = false;
        return valor;
    }

    public void cerrar() {
        cerrado = true;
    }




}
