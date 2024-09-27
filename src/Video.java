public class Video extends ElementoConVolume {
    private int luminosita;
    private static final int MAX_LUMINOSITA = 10;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume);
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

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + "!".repeat(getVolume()) + "*".repeat(luminosita));
        }
    }

    @Override
    public void esegui() {
        play();
    }
}