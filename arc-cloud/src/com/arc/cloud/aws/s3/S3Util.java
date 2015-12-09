package com.arc.cloud.aws.s3;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.arc.cloud.aws.auth.AWSAuthenticator;
import com.arc.cloud.dao.hib2.hib.codegen.Document;
import com.arc.cloud.dao.util.UIDBUtil;

public class S3Util {

	public void createBuket(String bucketName) {
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();
		AmazonS3 s3client = new AmazonS3Client(credentials);
		s3client.createBucket(bucketName);
		
	}
	
	public void uploadDocumment(Document document,InputStream is,String mymeType) throws Exception {
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();
		AmazonS3 s3client = new AmazonS3Client(credentials);
		ObjectMetadata obj = new ObjectMetadata();
		//obj.setContentType(mymeType);
		HashMap userMap= new HashMap<>();
		userMap.put("projectname", document.getTxProject());
		
		obj.setUserMetadata(userMap);
		System.out.println("S3Util.uploadDocumment() S3 bucket path is " + "acc-acc-weather-archive"+ "\\" +document.getTxSubDiv1()+"\\"+document.getTxSubDiv2());
	
		s3client.putObject(new PutObjectRequest("acc-acc-weather-archive212",document.getTxSubDiv1()+"/"+document.getTxSubDiv2()+"/"+document.getDocid() ,is,obj));
		
	}
	
	public static void getDoc(){
		List list = UIDBUtil.getSingDocument(String.valueOf(2138384113));
		Document document = (Document) list.get(0);
		
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();
		AmazonS3 s3client = new AmazonS3Client(credentials);
		S3Object s3object = s3client.getObject(new GetObjectRequest("acc-acc-weather-archive212",document.getTxSubDiv1()+"/"+document.getTxSubDiv2()+"/"+document.getDocid()));
		S3ObjectInputStream stream = s3object.getObjectContent();
		
		ObjectMetadata  mdata = s3object.getObjectMetadata();
		System.out.println("S3Util.getDoc()" + mdata.getContentType());
	}
	

	public static void main(String[] args) throws Exception {
		//new S3Util().createBuket("sds-pksms");

		new S3Util().getDoc();
		//new S3Util().uploadDocumment(doc,new FileInputStream(new File("C:\\temp\\united_states.pdf")));
	}

}
