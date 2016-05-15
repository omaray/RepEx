package com.repex.loader;

import com.google.gson.Gson;
import com.repex.Constants;
import com.repex.connector.HttpConnector;
import com.repex.model.RepositoryInfo;

public class RepositoryLoader {
    private String orgName;
    private String repoName;
    private String url;
    private RepositoryInfo repoInfo;
    
    public RepositoryLoader(String orgName, String repoName) {
        this.orgName = orgName;
        this.repoName = repoName;
        this.url = String.format(Constants.GITHUB_REPO_URL_TEMPLATE, this.orgName, this.repoName);
    }
    
    public void load() {
        HttpConnector connector = HttpConnector.getInstance();
        String response = connector.get(this.url);
        
        Gson gson = new Gson();
        this.repoInfo = gson.fromJson(response, RepositoryInfo.class);
    }
    
    public RepositoryInfo getRepositoryInfo() {
        return this.repoInfo;
    }
    
    public static void main(String[] args) {
        RepositoryLoader loader = new RepositoryLoader("googlecloudplatform", "gcloud-node");
        loader.load();
        
        RepositoryInfo repoInfo = loader.getRepositoryInfo();
        System.out.println(repoInfo.getLanguage());
        System.out.println(repoInfo.getForksCount());
        System.out.println(repoInfo.getOpenIssuesCount());
        System.out.println(repoInfo.getStargazersCount());
        System.out.println(repoInfo.getSubscribersCount());
    }
}
