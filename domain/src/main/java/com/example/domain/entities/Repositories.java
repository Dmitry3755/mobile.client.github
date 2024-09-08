package com.example.domain.entities;

public class Repositories {
    private String id;
    private String nodeId;
    private String name;
    private String fullName;
    private Boolean securityPrivate;
    private Owner owner;
    private String description;
    private Boolean fork;
    private String url;
    private Integer forksCount;
    private Integer watchers;

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
