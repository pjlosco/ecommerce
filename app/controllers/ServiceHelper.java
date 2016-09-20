package controllers;

import models.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class ServiceHelper {

    private CloseableHttpClient httpClient;

    protected User user = null;
    protected static Logger log;

    protected ServiceHelper(String className) {
        httpClient = HttpClients.createDefault();
        log = LogManager.getLogger(className);
    }

    private HttpRequestBase setupRequestWithUser(HttpRequestBase baseRequest) {
        // If user is Salesforce
        if (user != null && !user.getAccessToken().isEmpty()) {
            baseRequest.setHeader("Authorization", "Bearer " + user.getAccessToken());
        }

        // Add other user types here

        return baseRequest;
    }

    private void checkResponse(HttpResponse response, String possibleErrorMessage) {
        int responseCode = response.getStatusLine().getStatusCode();
        log.info(" -> " + responseCode);
        if (responseCode > 204) {
            log.error("Unexpected response, " + responseCode + " code returned");
            throw new RuntimeException(possibleErrorMessage);
        }
    }

    public HttpResponse executePostServiceCall(URI uri, UrlEncodedFormEntity entity, String possibleErrorMessage) throws URISyntaxException, IOException {
        HttpPost httpPost = (HttpPost) setupRequestWithUser(new HttpPost(uri));
        if (entity != null) {
            httpPost.setEntity(entity);
        }
        log.info("POST to: " + uri);
        HttpResponse response = httpClient.execute(httpPost);
        checkResponse(response, possibleErrorMessage);
        return response;
    }

    public HttpResponse executePostServiceCall(URI uri, StringEntity entity, String possibleErrorMessage) throws URISyntaxException, IOException {
        HttpPost httpPost = (HttpPost) setupRequestWithUser(new HttpPost(uri));
        if (entity != null) {
            httpPost.setEntity(entity);
        }
        log.info("POST to: " + uri);
        HttpResponse response = httpClient.execute(httpPost);
        checkResponse(response, possibleErrorMessage);
        return response;
    }

    public HttpResponse executeGetServiceCall(URI uri, String possibleErrorMessage) throws URISyntaxException, IOException {
        HttpGet httpGet = (HttpGet) setupRequestWithUser(new HttpGet(uri));
        HttpResponse response = httpClient.execute(httpGet);
        checkResponse(response, possibleErrorMessage);
        return response;
    }

    public HttpResponse executeDeleteServiceCall(URI uri, String possibleErrorMessage) throws URISyntaxException, IOException {
        HttpDelete httpDelete = new HttpDelete(uri);
        log.info("DELETE to: " + uri);
        HttpResponse response = httpClient.execute(httpDelete);
        checkResponse(response, possibleErrorMessage);
        return response;
    }

    public void setUser(User user) {
        this.user = user;
    }
}