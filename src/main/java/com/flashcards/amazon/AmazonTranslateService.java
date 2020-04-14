package com.flashcards.amazon;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.flashcards.domain.Language;
import org.springframework.stereotype.Service;

@Service
public class AmazonTranslateService {

    private TranslateTextResult result;

    public String translate(String text,Language language) {
        try{

            String amazonLanguageCode = getAmazonLanguageCode(language);
            AmazonTranslate translate = AmazonTranslateClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(AmazonConfig.credentials))
                .withRegion(Regions.EU_WEST_3)
                .build();

            TranslateTextRequest request = new TranslateTextRequest()
                .withText(text)
                .withSourceLanguageCode("pl")
                .withTargetLanguageCode(amazonLanguageCode);
            result  = translate.translateText(request);

        } catch (Exception e) {
            System.out.println("FETCHING TRANSLATE FAILED");
        }

        return result.getTranslatedText();
    }

    private static String getAmazonLanguageCode(Language language) {
        /*TRANSLATE Service has it's own lexicon based on specified names.*/
        switch (language) {
            case ENGLISH:
                return "en";
            case GERMAN:
                return "de";
            case SPANISH:
                return "es";
            case FRENCH:
                return "fr";
            default:
                return "not found";
        }
    }
}
