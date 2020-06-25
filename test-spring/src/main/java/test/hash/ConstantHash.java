package test.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Micheal on 2020/6/25.
 */
public class ConstantHash {
    public static void main(String[] args) {
        String serverList[] = {"192.168.9.1", "192.168.9.5", "192.168.9.2"};
        TreeMap<Integer, String> constantMap = new TreeMap<>();
        for (String server : serverList) {
            int serverHash = Math.abs(server.hashCode());
            constantMap.put(serverHash, server);
        }

        String clients[] = {"192.168.0.1", "192.168.0.5", "192.168.5.2"};
        for (String client : clients) {
            int clientHashCode = Math.abs(client.hashCode());
            SortedMap<Integer, String> sortedMap = constantMap.tailMap(clientHashCode);
            String server = "";
            if (sortedMap.isEmpty()) {
                server = constantMap.get(constantMap.firstKey());
            } else {
                server = sortedMap.get(sortedMap.firstKey());
            }
            System.out.println("client--->>" + client + " server--->" + server);
        }
    }
}
