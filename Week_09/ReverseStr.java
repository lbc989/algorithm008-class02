/**
 * 541. 反转字符串 II
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {//i += 2k的原因是每隔一个k的后一个k才会翻转
            swap(str, i, i + k);//翻转
        }
        return String.valueOf(str);
    }

    private void swap(char[] str, int i, int j) {
        j = Math.min(str.length, j) - 1;//如果i+k已经到了str的length的话，我们只能翻转到达length之前的那一段（限制2），为什么“-1”，比如
        //例子中k=2，第一个翻转是ab，j= math.min(7,2)-1.要reverse的是ab --> ba,坐标正好是0，1(2-1).因为长度为2，代表着两个char，
        //而i=0已经占有了一个char，所以要减去1，这是为了和坐标匹配。
        for (; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
