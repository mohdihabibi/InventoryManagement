package com.inventory.DeviceManagement;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class CreateRequest {

	private int id;
	private int aclObjId;
	private int objInstanceId;
	private int acl;
	private int deviceOwner;
	
	public CreateRequest(){
		this.id =10;
		this.aclObjId =10;
		this.objInstanceId =0;
		this.acl =11010;
		this.deviceOwner =101;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getACLObjectId() {
		return aclObjId;
	}
	public void setACLObjectId(int ACLobjectId) {
		this.aclObjId = ACLobjectId;
	}
	public int getObjInstanceId() {
		return objInstanceId;
	}
	public void setObjInstanceId(int objInstanceId) {
		this.objInstanceId = objInstanceId;
	}
	public int getAcl() {
		return acl;
	}
	public void setAcl(int acl) {
		this.acl = acl;
	}
	public int getowner() {
		return deviceOwner;
	}
	public void setowner(int owner) {
		this.deviceOwner = owner;
	}
	void sendCreateRequest() throws URISyntaxException, IOException {

		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:5080/client/lwm2m");
		StringEntity input = new StringEntity("/"+ id +"/create"+"?aclObjId="+ aclObjId +
				"&objInstanceId="+ objInstanceId +"&acl="+ acl +"&deviceOwner="+ deviceOwner);
		post.setEntity(input);
		HttpResponse response = (HttpResponse) client.execute(post);
		BufferedReader rd = new BufferedReader(new InputStreamReader((InputStream) response.getRequest().getContent()));
		System.out.println("\nCreate Request to Client");

		if (response.getStatusCode() == 201) {
			System.out.println("Successful");
		} else {
			System.out.println("wasn't successful");
		}
	}
}
	