package com.smartreader;

import java.io.FileWriter;
import java.io.IOException;

public class FeedbackProcessor {
    public static void saveFeedback(String feedback, String feedbackFilePath) throws IOException {
        try (FileWriter writer = new FileWriter(feedbackFilePath, true)) {
            writer.write(feedback + "\n");
        }
    }
}
