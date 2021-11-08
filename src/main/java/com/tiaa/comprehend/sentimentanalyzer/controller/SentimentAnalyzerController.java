package com.tiaa.comprehend.sentimentanalyzer.controller;

import com.tiaa.comprehend.sentimentanalyzer.FeedBackVO;
import com.tiaa.comprehend.sentimentanalyzer.SentimentAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sentiment")
public class SentimentAnalyzerController
{
    @Autowired
    SentimentAnalyzerService service;
    @PostMapping("/feedback")
    public FeedBackVO analyzeFeedBack(@RequestBody FeedBackVO feedBackVO)
    {
       return service.detectSentiments(feedBackVO);

    }

}
