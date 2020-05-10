import java.util.ArrayList;
import java.util.List;

//22. 括号生成
class GenerateParenthesis {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if (right < left) {
            _generate(left, right + 1, n, s + ")");
        }
    }
}