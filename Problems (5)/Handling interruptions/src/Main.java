class CounterThread extends Thread {

    @Override
    public void run() {
        long counter = 0;

            while (!Thread.interrupted()) {
                counter++;
            }

            System.out.println("It was interrupted");


    }
}