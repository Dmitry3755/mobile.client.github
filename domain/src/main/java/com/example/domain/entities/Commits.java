package com.example.domain.entities;

public class Commits {
    public String sha;
    public String node_Id;
    public String url;
    public String commentsUrl;
    public Commit commit;

    public Commits(
            String sha,
            String node_Id,
            String url,
            String commentsUrl,
            Commit commit
    ) {
        this.sha = sha;
        this.node_Id = node_Id;
        this.url = url;
        this.commentsUrl = commentsUrl;
        this.commit = commit;
    }
}
