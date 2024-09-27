/*

Scrivere il codice Java necessario all’implementazione di un Player multimediale impiegando i principi OOP

Descrizione del sistema:

Un Elemento Multimediale è una Immagine, un Video o una Registrazione Audio identificato da un titolo.
Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un metodo play().

Una registrazione Audio è riproducibile e ha associato anche un volume (un valore positivo di tipo int) e i metodi abbassaVolume() e alzaVolume() per regolarlo. Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una sequenza di punti esclamativi di lunghezza pari al volume (una stampa per riga).

Un Video è riproducibile e ha associato un volume regolabile analogo a quello delle registrazioni audio e anche una luminosità (un valore positivo di tipo int) e i metodi aumentaLuminosita() e diminuisciLuminosita() per regolarla. Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una sequenza di punti esclamativi di lunghezza pari al volume e poi a una sequenza di asterischi di lunghezza pari alla luminosità (una stampa per riga).

Un’Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella dei filmati e un metodo show() che stampa il titolo concatenato a una sequenza di asterischi di lunghezza pari alla luminosità
Eseguire un oggetto multimediale significa invocarne il metodo show() se è un'immagine o il metodo play() se è riproducibile.

Organizzare opportunamente con classi astratte, interfacce e classi concrete il codice di un lettore multimediale che memorizza 5 elementi (creati con valori letti da tastiera) in un array e poi chiede ripetutamente all'utente quale oggetto eseguire (leggendo un intero da 1 a 5 oppure 0 per finire).

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerMultimediale player = new PlayerMultimediale();

        player.creaElementi(scanner);

        while (true) {
            System.out.println("Quale elemento vuoi eseguire? (1-5) || 0 per terminare");
            int scelta = scanner.nextInt();
            if (scelta == 0) break;
            player.eseguiElemento(scelta);
        }

        scanner.close();
    }
}