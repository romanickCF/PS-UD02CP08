import java.util.Random;

public class Invernadero {


    Random rand = new Random();
    int temperatura;
    volatile boolean hayDato;
    volatile boolean cerrado;
    static final int LIMITE_TEMPERATURA = 28;

    public Invernadero() {
        temperatura = rand.nextInt(16 )+20 ;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void publicarTemperatura(int n){
        System.out.println("[SENSOR] publica medicion"+ n+ ": "+temperatura +"ºC");
        hayDato = true;
    }

    public  void leerTemperatura(int n){
        System.out.println("lee medicion "+ n + ": "+temperatura +" -> "+ mensaje());
        hayDato = false;
    }

    public String mensaje(){
        boolean rangoNormal = temperatura<= LIMITE_TEMPERATURA;

        return rangoNormal?"en rango normal, todo correcto":
                "EXCEDE EL UMBRAL de 28º, VENTILACION ACTIVADA";
    }


}
