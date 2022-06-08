package butelka;

import javax.sound.sampled.*;
import java.io.*;
//import java.io.IOException;
import java.util.Scanner;

public class ButelkaApp {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Butelka[] butelka = new Butelka[10];
        double pojemnosc, ileJestWody = 0;

        //Stworzenie butelek 1.5 i 2 litrowych z różną ilością wody
        for (int i = 0; i < butelka.length; i++) {
            if(i%2 == 0) pojemnosc = 1.5;
            else pojemnosc = 2;
            if (ileJestWody<pojemnosc) ileJestWody+=0.5;
            else ileJestWody = 0;
            butelka[i] = new Butelka(pojemnosc,ileJestWody);
        }

        Scanner scanner = new Scanner(System.in);

        //Włączenie muzyki
        playMusic();

        int choice=0;

        //Działania na butelkach
        do
        {
            //Wyświetlanie aktualnego stanu
            System.out.println("\n------TWOJE BUTELKI------");
            for(int i=1;i<=9;i++)
                System.out.printf("butelka[%d] %.1fl, %.1f wody\n",i, butelka[i].getIleLitrow(), butelka[i].getIleWody());

            //wyświetlanie menu
            System.out.print("""

                    1. Napij się
                    2. Napełnij wybraną butelke
                    3. Przelej z jednej do drugiej
                    0. Koniec
                    Twój wybór:\s""");

            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Z której butelki: ");
                    int nrButelki = scanner.nextInt();
                    System.out.print("Ile wody wypijesz: ");
                    double iloscWody = scanner.nextDouble();
                    butelka[nrButelki].wypij(iloscWody);
                    break;
                case 2:
                    System.out.print("Którą butelkę: ");
                    nrButelki = scanner.nextInt();
                    System.out.print("Ile wody dolejesz: ");
                    iloscWody = scanner.nextDouble();
                    butelka[nrButelki].wlej(iloscWody);
                    break;
                case 3:
                    System.out.print("Z której butelki: ");
                    nrButelki = scanner.nextInt();
                    System.out.print("Do której butelki: ");
                    int e = scanner.nextInt();
                    System.out.print("Ile wody: ");
                    iloscWody = scanner.nextDouble();
                    butelka[nrButelki].przelej(iloscWody, butelka[e]);
                    break;
                default:
                    if(choice!=0) System.out.println("Nie ma takiej opcji, wybierz z podanych");
            }

        }while (choice!=0);

    }
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("song.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

}