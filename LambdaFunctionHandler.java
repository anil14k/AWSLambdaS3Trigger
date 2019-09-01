package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;

public class LambdaFunctionHandler implements RequestHandler<S3Event, String> {

   // private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public LambdaFunctionHandler() {}

    // Test purpose only.
	/*
	 * AWSLambdaS3Event(AmazonS3 s3) { this.s3 = s3; }
	 */

    @Override
    public String handleRequest(S3Event event, Context context) {
        context.getLogger().log("Received event: " + event);
        // Get the object from the event and show its content type
        S3EventNotificationRecord record = event.getRecords().get(0);
        String srcFileName = record.getS3().getObject().getKey();
        String key =         event.getRecords().get(0).getS3().getObject().getKey();    
        String bucket = event.getRecords().get(0).getS3().getBucket().getName();
       
        	return "The bucket name is--"+bucket+"----and the key file is----"+key+"---and the source file name is--"+srcFileName;
		/*
		 * try { S3Object response = s3.getObject(new GetObjectRequest(bucket, key));
		 * String contentType = response.getObjectMetadata().getContentType();
		 * context.getLogger().log("CONTENT TYPE: " + contentType); return contentType;
		 * } catch (Exception e) { e.printStackTrace();
		 * context.getLogger().log(String.format(
		 * "Error getting object %s from bucket %s. Make sure they exist and" +
		 * " your bucket is in the same region as this function.", key, bucket)); throw
		 * e; }
		 */
    }
}