package com.example.domain.entities;

public class Owner {
    public String login;
    public String id;
    public String nodeId;
    public String avatarUrl;
    public String gravatarId;
    public String url;
    public String type;
    public Boolean siteAdmin;

    public Owner(
            String login,
            String id,
            String nodeId,
            String avatarUrl,
            String gravatarId,
            String url,
            String type,
            Boolean siteAdmin
    ) {
        this.login = login;
        this.id = id;
        this.nodeId = nodeId;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.url = url;
        this.type = type;
        this.siteAdmin = siteAdmin;
    }
}
