import java.util.Scanner;

public class PlayerMultimediale {
    private ElementoMultimediale[] elementi;

    public PlayerMultimediale() {
        elementi = new ElementoMultimediale[5];
    }

    public void creaElementi(Scanner scanner) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di elemento (1=Audio, 2=Video, 3=Immagine):");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            switch (tipo) {
                case 1:
                    System.out.println("Inserisci la durata:");
                    int durataAudio = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volumeAudio = scanner.nextInt();
                    elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                    break;
                case 2:
                    System.out.println("Inserisci la durata:");
                    int durataVideo = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volumeVideo = scanner.nextInt();
                    System.out.println("Inserisci la luminosità:");
                    int luminositaVideo = scanner.nextInt();
                    elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                case 3:
                    System.out.println("Inserisci la luminosità:");
                    int luminositaImmagine = scanner.nextInt();
                    elementi[i] = new Immagine(titolo, luminositaImmagine);
                    break;
            }
        }
    }

    public void eseguiElemento(int indice) {
        if (indice >= 1 && indice <= 5) {
            ElementoMultimediale elemento = elementi[indice - 1];
            elemento.esegui();

            if (elemento instanceof ElementoConVolume) {
                regolaVolume((ElementoConVolume) elemento);
            }

            if (elemento instanceof Video || elemento instanceof Immagine) {
                regolaLuminosita(elemento);
            }
        } else {
            System.out.println("Scelta non valida.");
        }
    }

    private void regolaVolume(ElementoConVolume elemento) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Vuoi regolare il volume? (1)Alza, (2)Abbassa, (N)No");
            String scelta = scanner.nextLine().toUpperCase();
            switch (scelta) {
                case "1":
                    if (elemento.getVolume() < 10) {
                        elemento.alzaVolume();
                        System.out.println("Volume alzato a " + elemento.getVolume());
                    } else {
                        System.out.println("Il volume è già al massimo.");
                    }
                    break;
                case "2":
                    if (elemento.getVolume() > 0) {
                        elemento.abbassaVolume();
                        System.out.println("Volume abbassato a " + elemento.getVolume());
                    } else {
                        System.out.println("Il volume è già al minimo.");
                    }
                    break;
                case "N":
                    break label;
            }
            elemento.esegui();
        }
    }

    private void regolaLuminosita(ElementoMultimediale elemento) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Vuoi regolare la luminosità? (1)Aumenta, (2)Diminuisci, (N)No");
            String scelta = scanner.nextLine().toUpperCase();
            switch (scelta) {
                case "1":
                    if (elemento instanceof Video) {
                        Video video = (Video) elemento;
                        if (video.getLuminosita() < 10) {
                            video.aumentaLuminosita();
                            System.out.println("Luminosità aumentata a " + video.getLuminosita());
                        } else {
                            System.out.println("La luminosità è già al massimo.");
                        }
                    } else if (elemento instanceof Immagine) {
                        Immagine immagine = (Immagine) elemento;
                        if (immagine.getLuminosita() < 10) {
                            immagine.aumentaLuminosita();
                            System.out.println("Luminosità aumentata a " + immagine.getLuminosita());
                        } else {
                            System.out.println("La luminosità è già al massimo.");
                        }
                    }
                    break;
                case "2":
                    if (elemento instanceof Video) {
                        Video video = (Video) elemento;
                        if (video.getLuminosita() > 0) {
                            video.diminuisciLuminosita();
                            System.out.println("Luminosità diminuita a " + video.getLuminosita());
                        } else {
                            System.out.println("La luminosità è già al minimo.");
                        }
                    } else if (elemento instanceof Immagine) {
                        Immagine immagine = (Immagine) elemento;
                        if (immagine.getLuminosita() > 0) {
                            immagine.diminuisciLuminosita();
                            System.out.println("Luminosità diminuita a " + immagine.getLuminosita());
                        } else {
                            System.out.println("La luminosità è già al minimo.");
                        }
                    }
                    break;
                case "N":
                    break label;
            }
            elemento.esegui();
        }
    }
}