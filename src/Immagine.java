public class Immagine extends ElementoMultimediale {
    private int luminosita;
    private static final int MAX_LUMINOSITA = 10;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        setLuminosita(luminosita);
    }

    public void aumentaLuminosita() {
        if (luminosita < MAX_LUMINOSITA) {
            luminosita++;
        }
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    private void setLuminosita(int luminosita) {
        this.luminosita = Math.max(0, Math.min(luminosita, MAX_LUMINOSITA));
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void show() {
        System.out.println(titolo + "*".repeat(luminosita));
    }

    @Override
    public void esegui() {
        show();
    }
}
