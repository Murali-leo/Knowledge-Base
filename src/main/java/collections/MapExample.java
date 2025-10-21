package main.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MapExample {
    public static void main(String[] args) {
        String s = "bcdefaabcdeeeeefggg";

        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<Character, Integer> firstIndex = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            // record first occurrence index for tie-breaking (first-come)
            firstIndex.putIfAbsent(c, i);
        }

        Queue<Character> queue = new PriorityQueue<>((a, b) -> {
            int diff = Integer.compare(charCountMap.get(b), charCountMap.get(a));
            if (diff != 0) return diff;
            // counts equal -> prefer character that appeared earlier in the string
            return Integer.compare(firstIndex.get(a), firstIndex.get(b));
        });
        for (char c : charCountMap.keySet()) {
            queue.offer(c);
        }
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            int count = charCountMap.get(ch);
            result.append(String.valueOf(ch).repeat(count));
        }

       
        System.out.println(result.toString());

    }
}
