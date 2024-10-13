public class Aufgabe4 {

    // Methode 1: Billigste Tastatur finden
    public static int billigsteTastatur(int[] tastaturen) {
        int minPreis = tastaturen[0];
        for (int preis : tastaturen) {
            if (preis < minPreis) {
                minPreis = preis;
            }
        }
        return minPreis;
    }

    // Methode 2: Teuerster Gegenstand finden (Tastaturen und USBs)
    public static int teuersterGegenstand(int[] tastaturen, int[] usbs) {
        int maxPreis = tastaturen[0];
        for (int preis : tastaturen) {
            if (preis > maxPreis) {
                maxPreis = preis;
            }
        }
        for (int preis : usbs) {
            if (preis > maxPreis) {
                maxPreis = preis;
            }
        }
        return maxPreis;
    }

    // Methode 3: Teuerstes USB-Laufwerk innerhalb des Budgets finden
    public static int teuerstesUsbImBudget(int[] usbs, int budget) {
        int maxPreis = -1;
        for (int preis : usbs) {
            if (preis <= budget && preis > maxPreis) {
                maxPreis = preis;
            }
        }
        return maxPreis;
    }

    // Methode 4: Maximale Ausgabe von Markus berechnen
    public static int maximaleAusgabe(int budget, int[] tastaturen, int[] usbs) {
        int maxAusgabe = -1;

        for (int tastaturPreis : tastaturen) {
            for (int usbPreis : usbs) {
                int gesamtPreis = tastaturPreis + usbPreis;
                if (gesamtPreis <= budget && gesamtPreis > maxAusgabe) {
                    maxAusgabe = gesamtPreis;
                }
            }
        }
        return maxAusgabe;
    }

    public static void main(String[] args) {
        int[] tastaturen = {40, 35, 70, 15, 45};
        int[] usbs = {15, 20, 10, 35};
        int budget = 60;

        System.out.println("Billigste Tastatur: " + billigsteTastatur(tastaturen));

        System.out.println("Teuerster Gegenstand: " + teuersterGegenstand(tastaturen, usbs));

        System.out.println("Teuerstes USB-Laufwerk im Budget: " + teuerstesUsbImBudget(usbs, 30));

        System.out.println("Maximale Ausgabe: " + maximaleAusgabe(budget, tastaturen, usbs));
    }
}