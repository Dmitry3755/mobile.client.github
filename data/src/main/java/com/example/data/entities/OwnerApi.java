package com.example.data.entities;

import com.example.domain.entities.Owner;
import com.google.gson.annotations.SerializedName;

public class OwnerApi {
    @SerializedName("login")
    public String login;
    @SerializedName("id")
    public String id;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("avatar_url")
    public String avatarUrl;
    @SerializedName("gravatar_id")
    public String gravatarId;
    @SerializedName("url")
    public String url;
    @SerializedName("type")
    public String type;
    @SerializedName("site_admin")
    public Boolean siteAdmin;

    public Owner toOwner() {
        return new Owner(
                login,
                id,
                nodeId,
                avatarUrl,
                gravatarId,
                url,
                type,
                siteAdmin
        );
    }
}
