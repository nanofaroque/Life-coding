package dailycodings;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 0 1 10
 * 0
 * /
 * 1
 */
public class DailyCoding_1008 {
    public static void main(String[] args) {
        //int data[] = {1, 2 , 5, 6, 3, 4};
        int data[] = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};

        DailyCoding_1008 dc = new DailyCoding_1008();
        int res = dc.maxXorOptimal(data);
        System.out.println(res);
        Assertions.assertEquals(127, res);
        System.out.println(maxXor(data));
    }

    class TrieNode {
        char val;
        HashMap<Character, TrieNode> map;

        public TrieNode(char val) {
            this.val = val;
            this.map = new HashMap<>();
        }
    }

    private int maxXorOptimal(int[] nums) {
        int maxNumber= Arrays.stream(nums).max().getAsInt();
        int max = Integer.MIN_VALUE;
        int L = (Integer.toBinaryString(maxNumber)).length();
        TrieNode root = new TrieNode('*');
        // zero left-padding to ensure L bits for each number
        int n = nums.length, bitmask = 1 << L;
        String[] strNums = new String[n];
        for (int i = 0; i < n; ++i) {
            strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }

        for (String binaryString : strNums) {
            TrieNode node = root;
            TrieNode xorNode = root;
            StringBuilder xorString = new StringBuilder();
            for (Character bit : binaryString.toCharArray()) {
                if (node.map.containsKey(bit)) {
                    node = node.map.get(bit);
                } else {
                    node.map.put(bit, new TrieNode(bit));
                    node = node.map.get(bit);
                }
                Character toggledBit = bit == '1' ? '0' : '1';

                if(xorNode.map.containsKey(toggledBit)){
                    xorNode=xorNode.map.get(toggledBit);
                    xorString.append('1');
                }else{
                    xorNode=xorNode.map.get(bit);
                    xorString.append('0');
                }
            }
            int res = Integer.parseInt(xorString.toString(), 2);
            max = Math.max(res, max);
            //System.out.println("Result: " + res);
        }
        return max;
    }

    private static int maxXor(int[] data) {
        int len = data.length;
        if (len == 1) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                max = Math.max(max, (data[i] ^ data[j]));
            }
        }
        return max;
    }
}
