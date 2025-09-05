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
}
