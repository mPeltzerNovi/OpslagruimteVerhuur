package controller;

import java.util.Scanner;

public class OpslagruimteVerhuurLauncher {
    //Stap 1:Variabelen definieren:
    final static int MAANDEN_BASIS_TARIEF = 2; //je krijgt twee maanden lang het basis tarief
    final static double BASIS_TARIEF = 100; //het basis tarief is 100 euro per maand.
    final static double GEWOON_TARIEF = 150; //het gewone (verdere) maandtarief is 150 euro per maand
    final static double JAARKAART_TARIEF = 1000; //Als je voor 1 maand huurt kost dat 120 euro

    //Stap 2: Nu de main methode schrijven
    public static void main(String[] args) {
        System.out.println("Dit programma rekent de stallingskosten uit voor de gehuurde opslagruimte.");
        System.out.println();

        //Stap 3:Vraag de gebruiker in de terminal hoeveel huurders een garagebox hebben gehuurd:
        Scanner input = new Scanner(System.in);
        System.out.print("Hoeveel Huurders wilt u invoeren?");
        int aantal = input.nextInt();

        //Stap 4: Arrays maken voor 'huurders', contractduur, opbrengstUitDeHuur.
        String[] huurders = new String[aantal];
        int[] contractduur = new int[aantal];
        double[] opbrengsten = new double[aantal];
        double totaleOpbrengst = 0.0; //begint op nul.

        //Stap 5: Vraag naar de namen van de huurders en en de contractduur in maanden
        //-->For loop
        for (int i = 0; i < aantal; i++) {
            System.out.println("Huurder " + (i+1));
            System.out.print("\tNaam: "); //(naar volgende regel).
            //Die gaan dan in een namen-array:
            huurders[i] = input.next();
            System.out.print("\tContractduur (max. 24 maanden): ");
            int tijdInput = input.nextInt();
            //Controleren of de ingevoorde contractduur idd max 24 maanden is (while):
            while (tijdInput > 24) {
                System.out.println("\tDe duur van de huurperiode kan maximaal 24 maanden zijn.");
                System.out.print("\tGeef duur van het huurcontract (max. 24 maanden): ");
                tijdInput = input.nextInt();
            }
            contractduur[i] = tijdInput;

        }
        //Stap 6: Bereken de opbrengst per huurder en de totale opbrengst over alle huurders
        //Weer met een for-loop
        for(int i = 0; i < aantal; i++) {
            opbrengsten[i] = berekenHuuropbrengst(contractduur[i]); //verderop methode voor "berekenHuuropbrengst"
            totaleOpbrengst += opbrengsten[i];
        }
        //Stap 8: Print de resultaten in de terminal en print ook de totale opbrengsten uit:
        System.out.println("Huuroverzicht");
        System.out.printf("%8s%8s%10s\n", "Huurder", "loopduur mnd", "bedrag");
        for(int i = 0; i < aantal; i++) {
            System.out.printf("%8s%8s%10s\n", huurders[i], contractduur[i], opbrengsten[i]);
        }
        System.out.println();
        System.out.println("Totaal van alle huurinkomsten: " + totaleOpbrengst + " euro.");

    }

    //Stap 7: Hier de methode maken voor berekenHuuropbrengst:
    public static double berekenHuuropbrengst(int looptijd) {
        double result;
        if(looptijd <= MAANDEN_BASIS_TARIEF) {
            result = looptijd * BASIS_TARIEF;
        } else {
            result = MAANDEN_BASIS_TARIEF * BASIS_TARIEF + (looptijd - MAANDEN_BASIS_TARIEF) * GEWOON_TARIEF;
        }
        if (result > JAARKAART_TARIEF) {
            result = JAARKAART_TARIEF;
        }
        return result;
    }



}
