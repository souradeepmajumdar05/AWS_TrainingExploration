package com.awstest.personal;

import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class S3BucketFetcher {

	/*
	* Only pre requisite before triggering this code is to have	~/.aws/credentials
	* with required credentials
	*/

	static AmazonS3 s3;

	public static void main(String[] args) throws Exception 
	{
		try 
		{
			System.out.println("Fetching net count of your s3 buckets! ");
			/*
			* Below line along with your credentials fetches all the s3 buckets you have 
			*/
			s3 = AmazonS3ClientBuilder.standard().build();
			List<Bucket> buckets = s3.listBuckets();

			System.out.println("You have " + buckets.size() + " Amazon S3 buckets.");
		} 
		catch (AmazonServiceException fe) 
		{
			System.out.println("Error Message:    " + fe.getMessage());
			System.out.println("HTTP Status Code: " + fe.getStatusCode());
			System.out.println("AWS Error Code:   " + fe.getErrorCode());
			System.out.println("Error Type:       " + fe.getErrorType());
			System.out.println("Request ID:       " + fe.getRequestId());
		} 
		catch (AmazonClientException se) 
		{
			System.out.println("Error Message: " + se.getMessage());
		}
	}
}
