
import java.lang.Math;
public class Queens {
    public static void main(String[] args) {
        // int[] regine = {0, 4, 7, 5, 2, 6, 1, 3}; // Test della struttura 1 Regina per colonna
        // Quante disposizioni con ripetizione mi attendo? 8^8 = (2^3)^8 = (2)^24 = 16 777 216
        // Quindi un intero è sufficiente
        int totaleDisposizioniVerificate = 0; // 16 777 216 << (2)^31 - 1
        int totaleNumeroSoluzioni = 0; // Mi attendo un subset di totaleDisposizioniVerificate
        int[] regine = new int [8]; // Array per le soluzioni
        int N = regine.length; // Costante Scacchiera
        long durata = 0;

        long startTime = System.currentTimeMillis();

        for(int q0 =0; q0<N; q0++){
            for(int q1 =0; q1<N; q1++){
                for(int q2 =0; q2<N; q2++){
                    for(int q3 =0; q3<N; q3++){
                        for(int q4 =0; q4<N; q4++){
                            for(int q5 =0; q5<N; q5++){
                                for(int q6 =0; q6<N; q6++){
                                    for(int q7 =0; q7<N; q7++){
                                        totaleDisposizioniVerificate++;
                                        regine = new int[] {q0, q1, q2, q3, q4, q5, q6, q7};
                                        if (isValida(regine)) {
                                            totaleNumeroSoluzioni++;
                                            stampaScacchiera(regine, totaleNumeroSoluzioni);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long stopTime = System.currentTimeMillis();
        durata = stopTime - startTime;

        System.out.println("\nIl problema delle " + N + " regine ha prodotto il risultato seguente:");
        System.out.println("Ho testato " + totaleDisposizioniVerificate + " disposizioni con ripetizioni.");
        System.out.println("Ho trovato " + totaleNumeroSoluzioni + " soluzioni possibili al gioco.");
        System.out.println("Tempo impiegato per risolvere il problema: " + durata + " [ms].");
    }

    private static boolean isValida(int[] regine) {
        final int N = regine.length;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(regine[i]==regine[j]) return false; // Stessa colonna
                if((Math.abs(regine[i]-regine[j])-Math.abs(i-j))==0) return false; // Stessa diagonale
            }
        }
        return true;
    }

    public static void stampaScacchiera(int[] regine, int soluzioneN){
        final int N = regine.length;
        System.out.println();
        System.out.println("Soluzione numero " + soluzioneN +":\n");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (regine[i] == j) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
