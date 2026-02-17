public class EjecutarEstudiante {

    public static void main(String[] args) {
        //Arreglo de objectos
        Estudiante[] est = new Estudiante[4];


        est[0] = new Estudiante("Juan", 3, "Ingenieria de sistemas", 3.8, 20);
        est[1] = new Estudiante("Miguel", 4, "Ingenieria de sistemas", 4.2, 19);
        est[2] = new Estudiante("Armando", 3, "Ingenieria de sistemas", 3.0, 21);
        est[3] = new Estudiante("Milena", 3, "Ingenieria de sistemas", 4.5, 20);

        System.out.println(est[2]);
    
 }
}