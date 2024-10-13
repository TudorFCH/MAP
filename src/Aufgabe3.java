import java.util.Arrays;

public class Aufgabe3 {

    // Methode 1: Summieren der Arrays
    public static int[] addiereArrays(int[] zahl1, int[] zahl2) {
        int laenge = zahl1.length;
        int[] summe = new int[laenge + 1];
        int carry = 0;

        for (int i = laenge - 1; i >= 0; i--) {
            int tempSumme = zahl1[i] + zahl2[i] + carry;
            summe[i + 1] = tempSumme % 10;
            carry = tempSumme / 10;
        }
        summe[0] = carry;

        return (summe[0] == 0) ? Arrays.copyOfRange(summe, 1, summe.length) : summe;
    }

    // Methode 2: Subtrahieren der Arrays
    public static int[] subtrahiereArrays(int[] zahl1, int[] zahl2) {
        int laenge = zahl1.length;
        int[] differenz = new int[laenge];
        int borrow = 0;

        for (int i = laenge - 1; i >= 0; i--) {
            int tempDifferenz = zahl1[i] - zahl2[i] - borrow;
            if (tempDifferenz < 0) {
                tempDifferenz += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            differenz[i] = tempDifferenz;
        }
        return differenz;
    }

    // Methode 3: Multiplikation des Arrays mit einer Ziffer
    public static int[] multipliziereArrayMitZiffer(int[] zahl, int ziffer) {
        int laenge = zahl.length;
        int[] produkt = new int[laenge + 1];
        int carry = 0;

        for (int i = laenge - 1; i >= 0; i--) {
            int tempProdukt = zahl[i] * ziffer + carry;
            produkt[i + 1] = tempProdukt % 10;
            carry = tempProdukt / 10;
        }
        produkt[0] = carry;

        return (produkt[0] == 0) ? Arrays.copyOfRange(produkt, 1, produkt.length) : produkt;
    }

    // Methode 4: Ganzzahlige Division des Arrays durch eine Ziffer
    public static int[] dividiereArrayDurchZiffer(int[] zahl, int ziffer) {
        int laenge = zahl.length;
        int[] quotient = new int[laenge];
        int rest = 0;

        for (int i = 0; i < laenge; i++) {
            int tempDividende = rest * 10 + zahl[i];
            quotient[i] = tempDividende / ziffer;
            rest = tempDividende % ziffer;
        }

        int startIndex = 0;
        while (startIndex < laenge && quotient[startIndex] == 0) {
            startIndex++;
        }
        return (startIndex == laenge) ? new int[]{0} : Arrays.copyOfRange(quotient, startIndex, laenge);
    }
    public static void main(String[] args) {
        int[] number1 = {7, 8, 0, 0, 0, 0, 0, 0, 0};
        int[] number2 = {3, 0, 9, 0, 0, 0, 0, 0 ,0};
        int digit = 3;
        System.out.println("Summe: " + Arrays.toString(addiereArrays(number1, number2)));

        int[] number3 = {5, 1, 9, 8, 6, 2, 2, 6, 6};
        int[] number4 = {1, 5, 5, 4, 1, 0, 7, 0, 7};
        System.out.println("Differenz: " + Arrays.toString(subtrahiereArrays(number3, number4)));

        int[] number5 = {2, 6, 8, 2, 0, 7, 5, 8 ,7};
        System.out.println("Multiplikation: " + Arrays.toString(multipliziereArrayMitZiffer(number5, digit)));

        int[] number6 = {6, 9, 1, 2, 7, 7, 2, 7, 7};
        System.out.println("Ganzzahlige Division: " + Arrays.toString(dividiereArrayDurchZiffer(number6, digit)));
    }
}