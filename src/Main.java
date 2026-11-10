//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Invernadero invernadero = new Invernadero();
    List<Integer> temperaturas = new ArrayList<>();

    Sensor sensor = new Sensor(invernadero);
    Controlador controlador = new Controlador(invernadero);


}
