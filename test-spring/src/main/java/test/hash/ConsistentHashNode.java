package test.hash;

import java.util.TreeMap;

/**
 * Created by Micheal on 2020/6/25.
 */
public class ConsistentHashNode {
    public static void main(String[] args) {
        String serverList[] = {"192.168.9.1", "192.168.9.5", "192.168.9.2"};
        TreeMap<Integer, String> constantMap = new TreeMap<>();
        for (String server : serverList) {
            int serverHash = Math.abs(server.hashCode());
            constantMap.put(serverHash, server);
        }

    }
}
