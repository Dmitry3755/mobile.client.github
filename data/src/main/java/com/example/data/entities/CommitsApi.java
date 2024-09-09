package com.example.data.entities;

import com.example.domain.entities.Commits;
import com.google.gson.annotations.SerializedName;

public class CommitsApi {

    @SerializedName("sha")
    public String sha;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("url")
    public String url;
    @SerializedName("comments_url")
    public String commentsUrl;
    @SerializedName("commit")
    public CommitApi commitApi;

    public Commits toCommits() {
        return new Commits(
                sha,
                nodeId,
                url,
                commentsUrl,
                commitApi.toCommit()
        );
    }

}
