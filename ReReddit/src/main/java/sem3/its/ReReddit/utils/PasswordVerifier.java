package sem3.its.ReReddit.utils;

public interface PasswordVerifier {
    boolean verify(String hash, char[] plainText);
}
