package com.example.algebraalgorithm.string;

public class Search {

    public int searchFullScan(String text, String mask) {
        for (int t = 0; t <= text.length() - mask.length(); t++) {
            int m = 0;
            while (m < mask.length() && mask.charAt(m) == text.charAt(t + m)) {
                m++;
            }
            if (m == mask.length()) {
                return t;
            }
        }

        return -1;
    }

    public int searchBMH(String text, String mask) {
        int[] shift = createShift(mask);
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = mask.length() - 1;
            while(m >= 0 && text.charAt(t + m) == mask.charAt(m)) {
                m--;
            }
            if (m < 0) {
                return t;
            }
            t += shift[text.charAt(t + mask.length() - 1)];
        }
        return -1;
    }

    private int[] createShift(String mask) {
        int[] shift = new int[128];
        for (int i = 0; i < shift.length; i++) {
            shift[i] = mask.length();
        }
        for (int m = 0; m < mask.length() - 1; m++) {
            shift[mask.charAt(m)] = mask.length() - m - 1;
        }

        return shift;
    }

}
