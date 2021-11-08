package com.tiaa.comprehend.sentimentanalyzer;

import java.io.Serializable;

public class FeedBackVO implements Serializable
{
    private String customerId;
    private String feedback;
    private String sentimentName;
    private float sentimentScore;

    public String getSentimentName()
    {
        return sentimentName;
    }

    public void setSentimentName(String sentimentName)
    {
        this.sentimentName = sentimentName;
    }

    public float getSentimentScore()
    {
        return sentimentScore;
    }

    public void setSentimentScore(float sentimentScore)
    {
        this.sentimentScore = sentimentScore;
    }

    public String getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    public String getFeedback()
    {
        return feedback;
    }

    public void setFeedback(String feedback)
    {
        this.feedback = feedback;
    }
}
