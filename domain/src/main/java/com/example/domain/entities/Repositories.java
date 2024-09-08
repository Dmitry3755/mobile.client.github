package com.example.domain.entities;

public class Repositories {
    public String id;
    public String nodeId;
    public String name;
    public String fullName;
    public Boolean securityPrivate;
    public Owner owner;
    public String description;
    public Boolean fork;
    public String url;
    public Integer forksCount;
    public Integer watchers;

    public Repositories(
            String id,
            String nodeId,
            String name,
            String fullName,
            Boolean securityPrivate,
            Owner owner,
            String description,
            Boolean fork,
            String url,
            Integer forksCount,
            Integer watchers) {
        this.id = id;
        this.nodeId = nodeId;
        this.name = name;
        this.fullName = fullName;
        this.securityPrivate = securityPrivate;
        this.owner = owner;
        this.description = description;
        this.fork = fork;
        this.url = url;
        this.forksCount = forksCount;
        this.watchers = watchers;
    }

}
