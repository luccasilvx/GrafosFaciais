package edu.algebra.Reconhecimento.Util;

public class SimilarityUtil {
    public static double cosineSimilarity(double[] a, double[] b) {
        double dot = 0.0, normA = 0.0, normB = 0.0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            normA += Math.pow(a[i], 2);
            normB += Math.pow(b[i], 2);
        }
        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    //OBS: O PCA aqui está simulado (redução simples via truncamento de vetor).
    //Para PCA real, usar Apache Commons Math ou Smile com matriz de covariância.
}
