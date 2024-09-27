public abstract class ElementoConVolume extends ElementoMultimediale implements Riproducibile {
    protected int volume;
    protected int durata;
    private static final int MAX_VOLUME = 10;

    public ElementoConVolume(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        setVolume(volume);
    }

    public void alzaVolume() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    private void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(volume, MAX_VOLUME));
    }

    public int getVolume() {
        return volume;
    }
}

