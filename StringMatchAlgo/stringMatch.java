String p = "ABCABDABCABEABC";
String s = "ABCABE";

for (int i = 0; i < p.length() - s.length(); i++) {
    boolean ok = true; 
    for (int j = 0; j < s.length(); j++) {
        if (s[i + j] != p[j]) {
            ok = false;
        }
    }
    if (ok) return i;
}
return -1;

static boolean match(String a, String b) {
    for (int i =0 ; i < a.length() - b.length(); i++) {
        boolean ok = true; 
        for (int j = 0; j < b.length(); j++) {
            if (a.charAt(i + j) != b.charAt(j)) {
                ok = false;
            }
        }
        if (ok) return true;
    }
    return false;
}