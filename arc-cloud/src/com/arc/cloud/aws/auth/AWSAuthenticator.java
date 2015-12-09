package com.arc.cloud.aws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

public class AWSAuthenticator {

	static AWSAuthenticator singletonGlanceutil = null;
	AWSCredentials credentials = null;

	private AWSAuthenticator() {
		try {
			credentials = new BasicAWSCredentials("AKIAJEBMBWEWH5CGH7CQ", "Y7eyrh8lSYNcb6PiKBwXoSw/VoD22eGcH8jywSXK");
			System.out.println("GlanceUtil.authenticate() Credential object created " + credentials);
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (~/.aws/credentials), and is in valid format.", e);
		}
	}

	static {
		singletonGlanceutil = new AWSAuthenticator();
	}



	public static AWSAuthenticator getObject() {
		return singletonGlanceutil;
	}

	public AWSCredentials getCredentials() {
		return credentials;
	}
	
	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			System.out.println("AWSAuthenticator.main()" + AWSAuthenticator.getObject().getCredentials().hashCode());
		}
	}
}
