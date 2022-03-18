import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancel {

    public static void main(String[] args) throws Exception {
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {

            System.out.println("Future started");
            // DO a process that takes a long time to finish
            //
            // Note: I don't use Thread.sleep or something else because they naturally check for
            // `Thread.currentThread.isInterrupted()` and throws an InterruptedException if yes.
            //
            // We need to use something that doesn't check if the thread is interrupted.
            URL url = new URL("https://www.google.com/search?q=surf+curse+disco");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            System.out.println("Is future interrupted: " + Thread.currentThread().isInterrupted());
            System.out.println("But I still ran to finish!");
            return "haa";
        });
        // Give a chance for the future to start before cancelling it
        Thread.sleep(1);
        System.out.println("Attempt to cancel future: " + future.cancel(true));
        Thread.sleep(1000);
    }
}
