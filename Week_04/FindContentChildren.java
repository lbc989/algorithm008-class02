import java.util.Arrays;

//455. 分发饼干
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) gi++;
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int g[] = {1, 2, 3};
        int s[] = {1, 1};
        int contentChildren = findContentChildren.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
