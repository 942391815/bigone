package test.hash;

/**
 * Created by Micheal on 2020/6/25.
 */
public class GeneralHash {
    public static String clients[] = {"192.168.9.1", "192.168.9.5", "192.168.9.2"};
    public static int serverCount = 3;

    public static void main(String[] args) {
        for (String client : clients) {
            int hashCode = Math.abs(client.hashCode());
            int index = hashCode % serverCount;
            System.out.println(client + "--->>>" + index);
        }
    }
}
