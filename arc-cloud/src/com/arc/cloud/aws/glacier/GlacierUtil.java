package com.arc.cloud.aws.glacier;

import java.io.File;
import java.util.Date;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.model.CreateVaultRequest;
import com.amazonaws.services.glacier.model.CreateVaultResult;
import com.amazonaws.services.glacier.transfer.ArchiveTransferManager;
import com.amazonaws.services.glacier.transfer.UploadResult;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.arc.cloud.aws.auth.AWSAuthenticator;

public class GlacierUtil {

	public void createVault(String vaultName) {
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();

		AmazonGlacierClient client = new AmazonGlacierClient(credentials);
		client.setEndpoint("https://glacier.us-east-1.amazonaws.com/");

		CreateVaultRequest request = new CreateVaultRequest().withAccountId("-").withVaultName(vaultName);
		CreateVaultResult result = client.createVault(request);
		System.out.println("GlacierUtil.createVault()" + result.getLocation());
	}

	public void uploadDocstoValult(String vaultName, File[] files) throws Exception {
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();

		AmazonGlacierClient client = new AmazonGlacierClient(credentials);
		client.setEndpoint("https://glacier.us-east-1.amazonaws.com/");

		ArchiveTransferManager atm = new ArchiveTransferManager(client, credentials);

		UploadResult result = atm.upload(vaultName, "Desc", new File("C:\\ytb-dl\\ytb-dl.exe"));
		System.out.println("Archive ID: " + result.getArchiveId());
	}

	public void downloadDocsfromValult(String vaultName, File[] files) throws Exception {

		     AmazonGlacierClient glacierClient;
		     AmazonSQSClient sqsClient;
		     AmazonSNSClient snsClient;
		    
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();

		glacierClient = new AmazonGlacierClient(credentials);
		sqsClient = new AmazonSQSClient(credentials);
		snsClient = new AmazonSNSClient(credentials);

		glacierClient.setEndpoint("glacier.us-west-2.amazonaws.com");
		sqsClient.setEndpoint("sqs.us-west-2.amazonaws.com");
		snsClient.setEndpoint("sns.us-west-2.amazonaws.com");

		try {
			ArchiveTransferManager atm = new ArchiveTransferManager(glacierClient, sqsClient, snsClient);

			//atm.download(vaultName, archiveId, new File(downloadFilePath));

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) throws Exception {
		//new GlacierUtil().uploadDocstoValue("sample", null);

	}

}
