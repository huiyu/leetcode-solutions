import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        if (words.length == 0) {
            return result;
        } else if (words.length == 1) {
            String line = evenDistribute(words[0], maxWidth);
            result.add(line);
            return result;
        }

        List<String> last = new ArrayList<>();
        last.add(words[0]);
        int len = words[0].length();
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (len + word.length() + last.size() > maxWidth) {
                String distributed = evenDistribute(last, len, maxWidth);
                result.add(distributed);
                last = new ArrayList<>();
                last.add(word);
                len = word.length();
            } else {
                last.add(word);
                len += word.length();
            }
        }

        String distributed = leftJustify(last, maxWidth);
        result.add(distributed);
        return result;
    }

    private String leftJustify(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (String word : line) {
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private String evenDistribute(String line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        appendSpace(sb, maxWidth - line.length());
        return sb.toString();
    }

    private String evenDistribute(List<String> line, int totalLen, int maxWidth) {
        StringBuilder sb = new StringBuilder(line.get(0));
        if (line.size() == 1) {
            appendSpace(sb, maxWidth - totalLen);
            return sb.toString();
        }

        int space = (maxWidth - totalLen) / (line.size() - 1);
        int firstSpace = (maxWidth - totalLen) - space * (line.size() - 2);
        appendSpace(sb, firstSpace);
        for (int i = 1; i < line.size() - 1; i++) {
            sb.append(line.get(i));
            appendSpace(sb, space);
        }
        sb.append(line.get(line.size() - 1));
        return sb.toString();
    }

    private void appendSpace(StringBuilder sb, int spaceNum) {
        for (int i = 0; i < spaceNum; i++) {
            sb.append(" ");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> lines = solution.fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
            }, 16);
        // System.out.println(lines);
        // lines = solution.fullJustify(new String[] {""}, 2);
        // System.out.println(lines);
        lines = solution.fullJustify(new String[] {"What","must","be","shall","be."}, 12);
        System.out.println(lines);
    }
}
