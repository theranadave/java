package Utils;

public class Hash {
    static String hash(String s) {
        String hash = Integer.toHexString(s.hashCode());
	    return hash;
	}

}
