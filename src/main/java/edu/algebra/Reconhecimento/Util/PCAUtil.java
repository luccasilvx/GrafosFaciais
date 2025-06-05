package edu.algebra.Reconhecimento.Util;

import java.util.Arrays;

public class PCAUtil {
    public static double[] reduce(double[] vector) {
        // Simulação de PCA: retorna os primeiros 100 valores
        return Arrays.copyOf(vector, Math.min(100, vector.length));
    }
}
