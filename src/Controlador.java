import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class Controlador extends Thread {

    private final Invernadero invernadero;
    private final int umbral;
    private final Random random = new Random();

    public Controlador(Invernadero invernadero, int umbral) {
        super("Controlador");
        this.invernadero = invernadero;
        this.umbral = umbral;
    }

    @Override
    public void run() {
        try {
            int n = 0;
            while (invernadero.esperarMedicion()) {
                int temp = invernadero.leer();
                n++;
                if (temp > umbral) {
                    System.out.printf("[CONTROL] lee medicion %02d: %d°C -> EXCEDE EL UMBRAL de %d°C, VENTILACION ACTIVADA%n", n, temp, umbral);
                } else {
                    System.out.printf("[CONTROL] lee medicion %02d: %d°C -> en rango normal, todo correcto%n", n, temp);
                }
                Thread.sleep(100 + random.nextInt(200));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[CONTROL] fin del monitoreo");
    }
}