//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws InterruptedException {


        final int UMBRAL = 28;
        final int MEDICIONES = 12;

        System.out.println("=== Monitorizacion ambiental del invernadero (productor/consumidor) ===");
        System.out.println("Espera activa: el sensor no sobrescribe hasta que el controlador ha leido.");
        System.out.println("Umbral de ventilacion: " + UMBRAL + "°C | mediciones: " + MEDICIONES + "\n");

        Invernadero invernadero = new Invernadero();
        Sensor sensor = new Sensor(invernadero, MEDICIONES);
        Controlador controlador = new Controlador(invernadero, UMBRAL);

        sensor.start();
        controlador.start();

        sensor.join();
        controlador.join();
    }



