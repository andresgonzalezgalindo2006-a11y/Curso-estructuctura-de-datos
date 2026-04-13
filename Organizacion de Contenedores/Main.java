public class Main {

    public static void main(String[] args) {

        Buque[] buques = new Buque[10];
        ContenedorMatriz[][] contenedores = new ContenedorMatriz[10][10];

        // Registrar buques
        buques[0] = new Buque("Titanic");
        buques[1] = new Buque("Pacific");

        // Registrar contenedores
        contenedores[0][0] = new ContenedorMatriz("China",500);
        contenedores[1][0] = new ContenedorMatriz("USA",300);
        contenedores[2][0] = new ContenedorMatriz("Brasil",200);

        // Mostrar peso total
        double total = 0;

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){

                if(contenedores[i][j] != null){
                    total += contenedores[i][j].peso;
                }

            }
        }

        System.out.println("Peso total: "+total);

        // Mostrar origen de contenedores
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){

                if(contenedores[i][j] != null){
                    System.out.println("Origen: "+contenedores[i][j].nombre);
                }

            }
        }

    }

}