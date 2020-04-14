package com.flashcards.amazon;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import com.amazonaws.util.IOUtils;
import com.flashcards.domain.Language;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AmazonPollyService {

    private AmazonPollyClient polly;

    public byte[] getAudio(String text, Language language) throws Exception {
        String amazonLanguageCode = getAmazonLanguageCode(language);
        SynthesizeSpeechResult synthRes = null;
        byte[] bytes = null;
        try {
            polly = new AmazonPollyClient(AmazonConfig.credentials).withRegion(Regions.US_EAST_2);
            SynthesizeSpeechRequest synthReq = new SynthesizeSpeechRequest().withText(text).withVoiceId(amazonLanguageCode).withOutputFormat(OutputFormat.Mp3);
            synthRes = polly.synthesizeSpeech(synthReq);
            InputStream audioStream = synthRes.getAudioStream();
            bytes = IOUtils.toByteArray(audioStream);

        } catch (Exception e) {
            System.out.println("FETCHING VOICE FALIED");
        }

        return bytes;
    }
    private static String getAmazonLanguageCode(Language language) {
        /*POLLY Service has it's own lexicon based on specified names.*/
        switch (language) {
            case ENGLISH:
                return "Joey";
            case GERMAN:
                return "Marlene";
            case FRENCH:
                return "Celine";
            case SPANISH:
                return "Conchita";
            default:
                return "Jan";
        }
    }


}
