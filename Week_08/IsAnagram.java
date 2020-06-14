/**
 * 242. 有效的字母异位词
 * 时间复杂度：O(n)。时间复杂度为 O(n) 因为访问计数器表是一个固定的时间操作。
 * 空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论 N 有多大，表的大小都保持不变。
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count1 = new int[26];
        for (char c : s.toCharArray())
            count1[c - 97] += 1;
        for (char c : t.toCharArray())
            count1[c - 97] -= 1;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != 0)
                return false;
        }
        return true;
    }
}
