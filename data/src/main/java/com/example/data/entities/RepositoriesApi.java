package com.example.data.entities;

import com.example.domain.entities.Repositories;
import com.google.gson.annotations.SerializedName;

public class RepositoriesApi {
    @SerializedName("id")
    public String id;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("name")
    public String name;
    @SerializedName("full_name")
    public String fullName;
    @SerializedName("private")
    public Boolean securityPrivate;
    @SerializedName("owner")
    public OwnerApi ownerApi;
    @SerializedName("description")
    public String description;
    @SerializedName("fork")
    public Boolean fork;
    @SerializedName("url")
    public String url;
    @SerializedName("forks_count")
    public Integer forksCount;
    @SerializedName("watchers")
    public Integer watchers;

    public Repositories toRepositories() {
        return new Repositories(
                id,
                nodeId,
                name,
                fullName,
                securityPrivate,
                ownerApi.toOwner(),
                description,
                fork,
                url,
                forksCount,
                watchers
        );
    }
}
