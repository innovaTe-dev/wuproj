package PL3Handouts;

public class ThreadHelloCount {

    public static void main(String[] args) {
        HelloThread hello = new HelloThread();
        CountThread count = new CountThread();
        HelloThread hello2 = new HelloThread();

        hello.start();
        count.start();
        hello2.start();
    }
}

class HelloThread extends Thread {

    public void run() {
        int pause;

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Hello!");
                pause = (int) (Math.random() * 3000);
                this.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}

class CountThread extends Thread {

    int pause;

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(i + 1);
                pause = (int) (Math.random() * 3000);
                sleep(pause);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
