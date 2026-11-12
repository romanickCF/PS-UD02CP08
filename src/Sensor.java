import java.util.List;
import java.util.Random;

public class Sensor  extends Thread{

    private final Invernadero invernadero;
    private final int mediciones;
    private final Random random = new Random();

    public Sensor(Invernadero invernadero, int mediciones) {
        super("Sensor");
        this.invernadero = invernadero;
        this.mediciones = mediciones;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= mediciones; i++) {
                Thread.sleep(100 + random.nextInt(200));   // periodo de medicion
                int temp = 15 + random.nextInt(21);        // entero entre 15 y 35
                invernadero.publicar(temp);
                System.out.printf("[SENSOR]  publica medicion %02d: %d°C%n", i, temp);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            invernadero.cerrar();
            System.out.println("[SENSOR]  fin de las mediciones, buffer cerrado");
        }
    }
}