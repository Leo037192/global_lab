import java.util.Scanner ;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int genx =0;
        boolean comprobante = false;
        char [] [] adn = new char[6][6];


        //para mutante:
        //c c a c c a
        //c g t t a c
        //c a a c g t
        //c a g t t a
        //g t c c a t
        //g t c g t a

        //para no mutante:
        //a c t t c a
        //a c t c c a
        //g t t t a g
        //g g a g c c
        //t t a a g g
        //t t a t t t
        
        //inicializamos la matriz y pedimos las partículas  del adn
        System.out.println("Bienvenido/a a la hermandad de mutantes.");
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                System.out.println("ingre:sa partícula: ");
                adn[i][j]= sc.next().charAt(0) ;
            }
        }

        //verificamos que estén bien introducidas
        while (genx==0) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if ((adn[i][j] == 'a') || (adn[i][j] == 'c') || (adn[i][j] == 'g') || (adn[i][j] == 't')) {
                        genx=1;
                    }
                }
            }
        }

        //la verficación decide si enviar el adn por la función
        if (genx == 1){
            comprobante = isMutantDna(false, adn);
        }else {
            System.out.println("ingre:sa bien las partículas.");
        }

        //el regreso del boolean afirma si es mutante o no
        if (comprobante == true){
            System.out.println("estas admitido en la hermandad.");
        }else{
            System.out.println("no estás permitido.");
        }
    }


    public static boolean isMutantDna (boolean genexis, char adn[][]){
        //analizamos si encontramos coincidencias en horizzontal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if ((adn[i][j] == adn[i+1][j]) && (adn[i][j] == adn[i+2][j]) && (adn[i][j] == adn[i+3][j])){
                    return true;
                }
            }
        }

        //analizamos si encontramos coincidencias en vertical
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if ((adn[i][j] == adn[i][j+1]) && (adn[i][j] == adn[i][j+2]) && (adn[i][j] == adn[i][j+3])){
                    return true;

                }
            }
        }

        //analizamos si enconramos coincidencias en diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((adn[i][j] == adn[i+1][j+1]) && (adn[i][j] == adn[i+2][j+2]) && (adn[i][j] == adn[i+3][j+3])){
                    return true;
                }
            }
        }

        //analizamos si encontramos coincdencias en diagonal invertida
        for (int i = 5; i > 2; i--) {
            for (int j = 5; j > 2; j--) {
                if ((adn[i][j] == adn[i-1][j-1]) && (adn[i][j] == adn[i-2][j-2]) && (adn[i][j] == adn[i-3][j-3])){
                    return true;
                }
            }
        }


        return false;
    }
}