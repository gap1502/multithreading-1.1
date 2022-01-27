class Main {
    public static void main(String[] args) {
        ThreadGroup mainGroup = new ThreadGroup("main group");

        System.out.println("Создаю потоки...");
        for (int i = 1; i < 5; i++) {
            new Thread(mainGroup, new MyThread(mainGroup, "Поток " + i)).start();
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершаю все потоки...");
        mainGroup.interrupt();
    }
}
