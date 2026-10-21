class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";

        for (int i = 0; i < strs.size(); i++) {
            String currentWord = strs.get(i);
            int length = currentWord.length();

            encodedString = encodedString + length + "#" + currentWord;
        }

        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> answer = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);
            int value = Integer.parseInt(str.substring(i, delimiter));

            i = delimiter + 1;

            String word = str.substring(i, i + value);
            answer.add(word);

            i = i + value;
        }

        return answer;
    }
}