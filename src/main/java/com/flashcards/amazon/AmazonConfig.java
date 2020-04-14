package com.flashcards.amazon;

import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.stereotype.Component;

@Component
public class AmazonConfig {
    private static String accessKey = "";
    private static String secretKey = "";

    public static BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
}
