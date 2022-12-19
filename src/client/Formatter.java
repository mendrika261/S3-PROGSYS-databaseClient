package client;

public class Formatter {
    public static String removeDuplicatePunctuation(String text) {
        text = text.replaceAll(" +", " ").replaceAll(", ", ",").replaceAll(" ,", ",");
        text = text.replaceAll("= ", "=").replaceAll(" =", "=");
        text = text.replaceAll(" !", "!");
        text = text.replaceAll(" <", "<");
        text = text.replaceAll(" >", ">");
        return text;
    }
}
