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
      while(!invernadero.cerrado){
          while(!invernadero.hayDato){
              Thread.yield();
          }
          invernadero.leerTemperatura(invernadero.temperatura);
          invernadero.hayDato = false;

      }

    }

}
