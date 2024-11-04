package model;

public class Nave implements Runnable{
    private String nombre;
    private int propulsores;
    private int salud;
    private int matrizEscudo;

    public Nave(String nombre, int propulsores, int matrizEscudo, int salud) {
        this.nombre = nombre;
        this.propulsores = propulsores;
        this.matrizEscudo = matrizEscudo;
        this.salud =salud;
    }

    @Override
    public void run() {
        int inicio = 0;
        int fin = 50;
        String paso = "\uD83C\uDF2B\uFE0F";
        StringBuilder recorrido = new StringBuilder();
        while (inicio < fin){
            int impacto = (int)(Math.random()*20);
            /*Syncronized lo he usado para compactar el bloque y asegurarme de que el contenido del bloque sale junto
            * y no se entremezcla con otros hilos
            */
            synchronized (System.out){
            if(impacto < matrizEscudo) {
                salud -= 5;
                System.out.println("\uD83D\uDD25 " + nombre + " recibio un impacto \uD83D\uDD25");
                System.out.println("Salud de " + nombre + ": " + salud);
                if (salud <= 0) {
                    System.out.println("\uD83D\uDCA5 " + nombre + " quedo destruido \uD83D\uDCA5");
                    return;
                }
            }
            }
            synchronized (System.out) {
                inicio += propulsores;
                System.out.println(inicio);
                for(int i = 0; i < propulsores; ++i){
                    recorrido.append(paso);
                }
                System.out.println(recorrido+"("+nombre+")"+"\uD83D\uDE80");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("La nave " + nombre + " fue interrumpida");
            }
        }
        if(inicio >= fin){
            System.out.println(nombre+"""
                    ⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛
                    ⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜⬛⬜           
                    """);
        }


    }
}
