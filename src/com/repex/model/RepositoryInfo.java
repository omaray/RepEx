package com.repex.model;

public class RepositoryInfo {
    String language;
    String org;
    String name;
    Integer stargazers_count;
    Integer forks_count;
    Integer open_issues_count;
    Integer subscribers_count;
    
    public RepositoryInfo() { }
    
    public String getLanguage() {
        return this.language;
    }
    
    public String getOrg() {
        return this.org;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Integer getStargazersCount() {
        return this.stargazers_count;
    }
    
    public Integer getForksCount() {
        return this.forks_count;
    }
    
    public Integer getOpenIssuesCount() {
        return this.open_issues_count;
    }
    
    public Integer getSubscribersCount() {
        return this.subscribers_count;
    }
}
