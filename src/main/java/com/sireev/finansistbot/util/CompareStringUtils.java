package com.sireev.finansistbot.util;

/**
 * Класс для сравнения строк по алгоритму Левенштейна
 */
public final class CompareStringUtils {

    /**
     * Сравнивает две строки по алгоритму Левенштейна
     *
     * @param input
     *        Входящая строка
     *
     * @param target
     *        Целевая строка
     *
     * @return true, если строки совпадают, иначе false
     */
    public static boolean compareIgnoreMistakes(String input, String target) {
        int distance = levenshteinDistance(input, target);
        return distance <= 2;
    }

    private static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1)
                    );
                }
            }
        }

        return dp[a.length()][b.length()];
    }

}
