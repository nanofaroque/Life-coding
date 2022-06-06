package leetcode.contests.contest_296;

public class TextEditor {
    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.addText("leetcode");
        int res = te.deleteText(4);

        System.out.println(res);
        te.addText("practice");
        System.out.println(te.cursorRight(3));
        System.out.println(te.cursorLeft(8));
    }

    int curr = 0;
    StringBuilder sb;

    public TextEditor() {
        curr = 0;
        sb = new StringBuilder("");
    }

    public void addText(String text) {
        sb.insert(curr,text);
        curr += text.length();
    }

    public int deleteText(int k) {
        if (curr == 0) return 0;
        int start = Math.max(0, curr - k);
        int deleted = curr - start;
        sb.delete(start, curr);
        curr = start;
        return deleted;

    }

    public String cursorLeft(int k) {
        int pos = Math.max(0, curr - k);
        curr = pos;
        return sb.substring(Math.max(pos - 10, 0), pos);

    }

    public String cursorRight(int k) {
        int pos = Math.min(curr + k, sb.length());
        curr = pos;
        return sb.substring(Math.max(pos - 10, 0), pos);
    }
}
