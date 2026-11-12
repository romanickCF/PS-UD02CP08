import java.util.List;

public class Sensor  extends Thread{

    Invernadero invernadero;
    int i;



        public Sensor(Invernadero invernadero){
            this.invernadero = invernadero;
            i = 1;
        }

    @Override
    public void run() {
            while(!invernadero.cerrado){
                while (invernadero.hayDato){
                    Thread.yield();
                }
                invernadero.publicarTemperatura(i);
                i++;
            }

        System.out.println("Buffer Cerrado, no hay nada que medir");
    }
}
