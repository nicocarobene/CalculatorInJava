public class furgoneta extends Coche{
    private int capacidad_extra;
    private int plazas_extras;

    public furgoneta(int rueda, int largo, int ancho, int motor, int peso_plataforma, int capacidad_extra, int plazas_extras) {
        super(rueda, largo, ancho, motor, peso_plataforma);
        this.capacidad_extra = capacidad_extra;
        this.plazas_extras = plazas_extras;
    }

    public String toString(){
        return super.toString() + "\nLa capacidad de carga es: "+capacidad_extra+" y las plazas son: "+plazas_extras;
    }
}
