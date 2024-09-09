package com.example.data.entities;

import com.example.domain.entities.Author;
import com.example.domain.entities.Commit;
import com.google.gson.annotations.SerializedName;

public class CommitApi {
    @SerializedName("author")
    public AuthorApi authorApi;
    @SerializedName("message")
    public String message;

    public Commit toCommit() {
        return new Commit(
                authorApi.toAuthor(),
                message
        );
    }
}
