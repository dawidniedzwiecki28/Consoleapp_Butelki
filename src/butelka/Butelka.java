package butelka;
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
}
