package com.appspot.atndalert.util;

import java.util.ArrayList;
import java.util.List;

public class NgramTokenizer {

    private int startN;
    private int endN;

    public NgramTokenizer(int startN, int endN) {
        this.startN = startN;
        this.endN = endN;
    }

    public List<String> tokenize(String targetStr) {
        List<String> result = new ArrayList<String>();

        for (int n = this.startN; n < this.endN + 1; n++) {
            for (int i = 0; i + n - 1 < targetStr.length(); i++) {
                result.add(targetStr.substring(i, i + n));
            }
        }
        return result;
    }
}
