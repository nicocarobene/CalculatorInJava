public class Coche {
    private int rueda=4,
    largo=2000,
    ancho=300,
    motor=1600,
    peso_plataforma=500;

    public Coche(int rueda, int largo, int ancho, int motor, int peso_plataforma) {
        this.rueda = rueda;
        this.largo = largo;
        this.ancho = ancho;
        this.motor = motor;
        this.peso_plataforma = peso_plataforma;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "rueda=" + rueda +
                ", largo=" + largo +
                ", ancho=" + ancho +
                ", motor=" + motor +
                ", peso_plataforma=" + peso_plataforma +
                '}';
    }
}
