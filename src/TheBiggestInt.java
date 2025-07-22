public class TheBiggestInt {
    public static void main(String[] args) {

        // Voglio Scoprire l'intero più grande rappresentabile in JAVA

        int biggestIntInJava = 0;
        int nextInt = 0;
        boolean continua = true;

        long startTime = System.currentTimeMillis();
        while(continua){
            nextInt++;
            if(biggestIntInJava>nextInt) continua=false;
            else biggestIntInJava++;
        }
        long stopTime = System.currentTimeMillis();
        long duration = stopTime - startTime;

        System.out.println(
                "Il numero intero più grande rappresentabile in JAVA è: "
                        + biggestIntInJava
                        +". L'operazione di calcolo ha richiesto: "
                        + duration
                        + " [ms]"
        );

    }
}
