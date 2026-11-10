import java.util.List;

public class Controlador extends Thread {

    Invernadero invernadero;
    int j;

  public Controlador(Invernadero invernadero){
      this.invernadero = invernadero;
      j=1;

  }

    @Override
    public void run() {
      while(!invernadero.hayDato){

      }

    }

    public String mensaje(){
      boolean rangoNormal = invernadero.getTemperatura()< 28;

      return rangoNormal?"en rango normal, todo correcto":
              "EXCEDE EL UMBRAL de 28º, VENTILACION ACTIVADA";
    }
}
