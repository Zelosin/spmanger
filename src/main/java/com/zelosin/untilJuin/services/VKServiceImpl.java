package com.zelosin.untilJuin.services;


import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.groups.Filter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VKServiceImpl implements LinkedServiceInter {

    @Value("${spring.social.vk.appId}")
    private String appplicationId;

    @Value("${spring.social.vk.appSecret}")
    private String applicationSecretCode;

    @Value("${spring.social.vk.v}")
    private String apiVersion;

    @Value("${spring.social.vk.link.autho}")
    private String applicationCodeAuthoLink;

    @Value("${spring.social.vk.link.redirect}")
    public String redirectURL;

    @Value("${spring.social.vk.user.scope}")
    private String applicationScope;

    private TransportClient transportClient = HttpTransportClient.getInstance();
    private VkApiClient apiClient = new VkApiClient(transportClient);
    private UserActor currentUserActor;
    private GroupActor currentGroupActor;
    private UserAuthResponse authResponse;

    public String createVKAuthorizationURL(){
        return  applicationCodeAuthoLink+
                "client_id=" + appplicationId+
                "&scope=" + applicationScope +
                "&redirect_uri=" + redirectURL;
    }

    public boolean authService(String code){
        try {
            authResponse = apiClient.oAuth()
                    .userAuthorizationCodeFlow(Integer.valueOf(appplicationId), applicationSecretCode, redirectURL, code)
                    .execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isAlreadyAuthed(){
        return authResponse != null;
    }

    public UserActor getVkAccessTokenForUser(){
        currentUserActor = new UserActor(authResponse.getUserId(), Objects.requireNonNull(authResponse).getAccessToken());
        return currentUserActor;
    }


    public GroupActor getVkAccessTokenForComunnity(Integer communityId){
        currentGroupActor = new GroupActor(communityId, Objects.requireNonNull(authResponse).getAccessToken());
        return currentGroupActor;
    }

    public JSONObject getCommunityList(UserActor userActor, Filter filter){
        try {
            return new JSONObject(apiClient.groups().get(userActor).filter(filter).extended(true).executeAsString());
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}





















