package com.example.lab2_hordiienko_madt;

import android.content.Context;
import android.widget.Toast;

public class TextCounter {

    public static int countCharacters(Context context, String input) {
        if (input == null) {
            Toast.makeText(context, "The string is empty", Toast.LENGTH_LONG).show();
            return 0;
        }
        return input.length();
    }

    public static int countWords(Context context, String input) {
        if (input == null || input.trim().isEmpty()) {
            Toast.makeText(context, "The string is empty", Toast.LENGTH_LONG).show();
            return 0;
        }
        String[] words = input.trim().split("[, . \\s ]+");

        return words.length;
    }

    public static int countNumbers(Context context, String input) {
        if (input == null || input.trim().isEmpty()) {
            Toast.makeText(context, "The string is empty", Toast.LENGTH_LONG).show();
            return 0;
        }
        String[] numbers = input.trim().split("[^0-9]+");
        int count = 0;
        for (String num : numbers) {
            if (!num.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static int countSentences(Context context, String input) {
        if (input == null || input.trim().isEmpty()) {
            Toast.makeText(context, "The string is empty", Toast.LENGTH_LONG).show();
            return 0;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }
}
