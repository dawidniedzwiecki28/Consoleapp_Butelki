package butelka;

import java.util.Scanner;

public class Butelka {
    private double ileLitrow;
    private double ileWody;
    Butelka(double ileLitrow, double ileWody)
    {
        this.ileLitrow = ileLitrow;
        this.ileWody = ileWody;
    }
    double getIleLitrow()
    {
        return  ileLitrow;
    }
    double getIleWody()
    {
        return  ileWody;
    }
    void wlej(double ilosc)
    {
        if(ilosc<=(ileLitrow-ileWody)) this.ileWody += ilosc;
        else {
            System.out.println("\nPrzesadziłeś, wylałeś wodę na ziemię!!!");
            this.ileWody = this.ileLitrow;
        }
    }
    void wypij(double ilosc)
    {
        if(ileWody > ilosc) this.ileWody -= ilosc;
        else {
            if(ileWody==0) System.out.println("\nW tej butelce nie ma wody");
            else System.out.println("\nW tej butelce jest tylko " + ileWody + "l wody\n" +
                                    "Ale dobre i tyle ;)");
            this.ileWody = 0;
        }
    }
    void przelej(double ilosc, Butelka gdziePrzelac)
    {
        double rob = this.ileWody;
        this.wypij(ilosc);
        if(this.ileWody==0) gdziePrzelac.wlej(rob);
        else gdziePrzelac.wlej(ilosc);
    }

    public static void main(String[] args) {
        Butelka[] butelka = new Butelka[10];

        double a=0, b=0;
        for (int i = 0; i < butelka.length; i++) {
            if(i%2 == 0) a = 1.5;
            else a = 2;
            if (b<a) b+=0.5;
            else b = 0;
            butelka[i] = new Butelka(a,b);
        }
        Scanner scanner = new Scanner(System.in);

        int w = 0;
        do
        {
            //Wyświetlanie aktualnego stanu
            System.out.println("\n------TWOJE BUTELKI------");
            for(int i=1;i<=9;i++)
                System.out.printf("butelka[%d] %.1fl, %.1f wody\n",i,butelka[i].getIleLitrow(),butelka[i].ileWody);

            //wyświetlanie menu
            System.out.print("\n1. Napij się\n" +
                               "2. Napełnij wybraną butelke\n" +
                               "3. Przelej z jednej do drugiej\n" +
                               "0. Koniec\n" +
                               "Twój wybór: ");
            w = scanner.nextInt();

            switch (w)
            {
                case 1:
                    System.out.print("Z której butelki: ");
                    int c = scanner.nextInt();
                    System.out.print("Ile wody wypijesz: ");
                    double d = scanner.nextDouble();
                    butelka[c].wypij(d);
                    break;
                case 2:
                    System.out.print("Którą butelkę: ");
                    c = scanner.nextInt();
                    System.out.print("Ile wody dolejesz: ");
                    d = scanner.nextDouble();
                    butelka[c].wlej(d);
                    break;
                case 3:
                    System.out.print("Z której butelki: ");
                    c = scanner.nextInt();
                    System.out.print("Do której butelki: ");
                    int e = scanner.nextInt();
                    System.out.print("Ile wody: ");
                    d = scanner.nextDouble();
                    butelka[c].przelej(d,butelka[e]);
                    break;
                default:
                    if(w!=0) System.out.println("Nie ma takiej opcji, wybierz z podanych");
            }

        }while (w!=0);



    }
}
