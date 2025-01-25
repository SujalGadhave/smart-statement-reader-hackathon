package com.smartreader;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.Tensors;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AIModelProcessor {
    public static String classifyPDF(String filePath) throws Exception {
        byte[] graphDef = Files.readAllBytes(Paths.get("C:/Users/admin/Documents/bankStatement.pdf"));
        try (Graph graph = new Graph()) {
            graph.importGraphDef(graphDef);
            try (Session session = new Session(graph)) {
                Tensor<String> inputTensor = Tensors.create("C:/Users/admin/Documents/bankStatement.pdf");
                Tensor<?> output = session.runner()
                        .feed("input_node", inputTensor)
                        .fetch("output_node").run().get(0);

                String result = new String(output.bytesValue(), "UTF-8");
                output.close();
                return result;
            }
        }
    }
}
