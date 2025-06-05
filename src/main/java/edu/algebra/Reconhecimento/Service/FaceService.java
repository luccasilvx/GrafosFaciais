package edu.algebra.Reconhecimento.Service;

import edu.algebra.Reconhecimento.Util.ImageUtil;
import edu.algebra.Reconhecimento.Util.PCAUtil;
import edu.algebra.Reconhecimento.Util.SimilarityUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FaceService {

    public double compareFaces(byte[] img1, byte[] img2) throws IOException {
        double[] vector1 = ImageUtil.imageToVector(img1);
        double[] vector2 = ImageUtil.imageToVector(img2);

        double[] reduced1 = PCAUtil.reduce(vector1);
        double[] reduced2 = PCAUtil.reduce(vector2);

        return SimilarityUtil.cosineSimilarity(reduced1, reduced2);
    }
}