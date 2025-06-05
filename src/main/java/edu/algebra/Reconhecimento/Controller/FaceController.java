package edu.algebra.Reconhecimento.Controller;

import edu.algebra.Reconhecimento.Service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/faces")
public class FaceController {

    @Autowired
    private FaceService faceService;

    @PostMapping("/compare")
    public ResponseEntity<Map<String, Object>> compare(
            @RequestParam("img1") MultipartFile img1,
            @RequestParam("img2") MultipartFile img2) throws IOException {

        double similarity = faceService.compareFaces(img1.getBytes(), img2.getBytes());

        Map<String, Object> response = new HashMap<>();
        response.put("similarity_percentage", String.format("%.2f", similarity * 100) + "%");
        response.put("raw_score", similarity);

        return ResponseEntity.ok(response);
    }

}
