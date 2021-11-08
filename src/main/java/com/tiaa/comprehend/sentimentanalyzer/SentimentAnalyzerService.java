package com.tiaa.comprehend.sentimentanalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.comprehend.ComprehendClient;
import software.amazon.awssdk.services.comprehend.model.ComprehendException;
import software.amazon.awssdk.services.comprehend.model.DetectSentimentRequest;
import software.amazon.awssdk.services.comprehend.model.DetectSentimentResponse;

@Component
public class SentimentAnalyzerService
{
    @Autowired
    SentimentAnalyzerConfig sentimentAnalyzerConfig;

    public FeedBackVO detectSentiments(FeedBackVO feedBackVO){
        try {
            DetectSentimentRequest detectSentimentRequest = DetectSentimentRequest.builder()
                    .text(feedBackVO.getFeedback())
                    .languageCode("en")
                    .build();
            ComprehendClient  comClient = sentimentAnalyzerConfig.getClient();

            DetectSentimentResponse detectSentimentResult = comClient.detectSentiment(detectSentimentRequest);
            System.out.println("The Neutral value is " +detectSentimentResult.sentimentScore().neutral() );
            System.out.println("The Neutral value is " +detectSentimentResult.sentiment().name());
            feedBackVO.setSentimentName(detectSentimentResult.sentiment().name());
            feedBackVO.setSentimentScore(detectSentimentResult.sentimentScore().neutral());

        } catch (ComprehendException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return feedBackVO;
    }
}
