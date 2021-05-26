package controller;

import java.util.Scanner;

public class OpslagruimteVerhuurLauncher {
    //Variabelen definieren:
    final static int MAANDEN_BASIS_TARIEF = 2; //je krijgt twee maanden lang het basis tarief
    final static double BASIS_TARIEF = 100; //het basis tarief is 100 euro per maand.
    final static double GEWOON_TARIEF = 150; //het gewone (verdere) maandtarief is 150 euro per maand
    final static double MAANDKAART_TARIEF = 120; //Als je voor 1 maand huurt kost dat 120 euro

    //Nu de main methode schrijven
    public static void main(String[] args) {
        System.out.println("Dit programma rekent de stallingskosten uit voor de gehuurde opslagruimte.");
        System.out.println();

        //Vraag de gebruiker in de terminal hoeveel huurders een garagebox hebben gehuurd:
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel Huurders wilt u invoeren?");
        int aantal = input.nextInt();

        //Arrays maken voor 'huurders', contractduur, opbrengstUitDeHuur.
        String[] huurders = new String[aantal];
        int[] contractduur = new int[aantal];
        double[] opbrengsten = new double[aantal];
        double totaleOpbrengst = 0.0; //begint op nul.
    }



}
