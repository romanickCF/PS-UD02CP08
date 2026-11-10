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
        while (invernadero.hayDato){

        }
        invernadero.publicarTemperatura(i);
        i++;

    }

    private int medirTemperatura(List<Integer> mediciones){

            mediciones.add(invernadero.getTemperatura());
            return invernadero.getTemperatura();
    }
}
