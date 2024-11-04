package model;

public class Carrera {
    public static void main(String[] args) {


    Nave nave1 = new Nave("Quasar", 3, 3, 15);
    Nave nave2 = new Nave("Rayo de Sol", 6, 2, 10);
    Nave nave3 = new Nave("Kinda Kign", 2, 4, 20);

    Thread p1 = new Thread(nave1);
    Thread p2 = new Thread(nave2);
    Thread p3 = new Thread(nave3);

    p1.start();
    p2.start();
    p3.start();
}
}