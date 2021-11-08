package com.tiaa.comprehend.sentimentanalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.comprehend.ComprehendClient;

@Configuration
public class SentimentAnalyzerConfig
{
    @Autowired
    Environment environment;
    @Bean
    public ComprehendClient getClient()
    {
        Region region = Region.US_EAST_1;

        ComprehendClient comClient = null;
       String[] env = environment.getActiveProfiles();
        if(env[0].equalsIgnoreCase("dev"))
        {
             comClient = ComprehendClient.builder()
                    .region(region)
                    .build();
        }
        else
        {
            comClient = ComprehendClient.builder()
                    .region(region).credentialsProvider(InstanceProfileCredentialsProvider.builder().build())
                    .build();
        }
   /*     ComprehendClient comClient = ComprehendClient.builder()
                .region(region)
                .build();*/
        return comClient;
    }

}
