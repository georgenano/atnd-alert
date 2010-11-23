package com.appspot.atndalert.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2010-11-23 14:20:11")
/** */
public final class AtndEventMeta extends org.slim3.datastore.ModelMeta<com.appspot.atndalert.model.AtndEvent> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer> accepted = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer>(this, "accepted", "accepted", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> address = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "address", "address");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> catchSentence = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "catchSentence", "catchSentence");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> description = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.util.Date> endedAt = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.util.Date>(this, "endedAt", "endedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Long> entityVersion = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Long>(this, "entityVersion", "entityVersion", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer> id = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer>(this, "id", "id", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> lat = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "lat", "lat");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer> limit = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer>(this, "limit", "limit", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> lon = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "lon", "lon");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> ownerId = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "ownerId", "ownerId");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> ownerNickname = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "ownerNickname", "ownerNickname");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> ownerTwitterId = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "ownerTwitterId", "ownerTwitterId");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> place = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "place", "place");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.util.Date> startedAt = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.util.Date>(this, "startedAt", "startedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> title = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.util.Date> updatedAt = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.util.Date>(this, "updatedAt", "updatedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent> url = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AtndEvent>(this, "url", "url");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer> waiting = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AtndEvent, java.lang.Integer>(this, "waiting", "waiting", int.class);

    private static final AtndEventMeta slim3_singleton = new AtndEventMeta();

    /**
     * @return the singleton
     */
    public static AtndEventMeta get() {
       return slim3_singleton;
    }

    /** */
    public AtndEventMeta() {
        super("AtndFeedContent", com.appspot.atndalert.model.AtndEvent.class);
    }

    @Override
    public com.appspot.atndalert.model.AtndEvent entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.atndalert.model.AtndEvent model = new com.appspot.atndalert.model.AtndEvent();
        model.setAccepted(longToPrimitiveInt((java.lang.Long) entity.getProperty("accepted")));
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setCatchSentence((java.lang.String) entity.getProperty("catchSentence"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setEndedAt((java.util.Date) entity.getProperty("endedAt"));
        model.setEntityVersion(longToPrimitiveLong((java.lang.Long) entity.getProperty("entityVersion")));
        model.setId(longToPrimitiveInt((java.lang.Long) entity.getProperty("id")));
        model.setKey(entity.getKey());
        model.setLat((java.lang.String) entity.getProperty("lat"));
        model.setLimit(longToPrimitiveInt((java.lang.Long) entity.getProperty("limit")));
        model.setLon((java.lang.String) entity.getProperty("lon"));
        model.setOwnerId((java.lang.String) entity.getProperty("ownerId"));
        model.setOwnerNickname((java.lang.String) entity.getProperty("ownerNickname"));
        model.setOwnerTwitterId((java.lang.String) entity.getProperty("ownerTwitterId"));
        model.setPlace((java.lang.String) entity.getProperty("place"));
        model.setStartedAt((java.util.Date) entity.getProperty("startedAt"));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setUpdatedAt((java.util.Date) entity.getProperty("updatedAt"));
        model.setUrl((java.lang.String) entity.getProperty("url"));
        model.setWaiting(longToPrimitiveInt((java.lang.Long) entity.getProperty("waiting")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.atndalert.model.AtndEvent m = (com.appspot.atndalert.model.AtndEvent) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("accepted", m.getAccepted());
        entity.setProperty("address", m.getAddress());
        entity.setProperty("catchSentence", m.getCatchSentence());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("endedAt", m.getEndedAt());
        entity.setProperty("entityVersion", m.getEntityVersion());
        entity.setProperty("id", m.getId());
        entity.setProperty("lat", m.getLat());
        entity.setProperty("limit", m.getLimit());
        entity.setProperty("lon", m.getLon());
        entity.setProperty("ownerId", m.getOwnerId());
        entity.setProperty("ownerNickname", m.getOwnerNickname());
        entity.setProperty("ownerTwitterId", m.getOwnerTwitterId());
        entity.setProperty("place", m.getPlace());
        entity.setProperty("startedAt", m.getStartedAt());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        entity.setProperty("url", m.getUrl());
        entity.setProperty("waiting", m.getWaiting());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.atndalert.model.AtndEvent m = (com.appspot.atndalert.model.AtndEvent) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.atndalert.model.AtndEvent m = (com.appspot.atndalert.model.AtndEvent) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.atndalert.model.AtndEvent m = (com.appspot.atndalert.model.AtndEvent) model;
        return m.getEntityVersion();
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.atndalert.model.AtndEvent m = (com.appspot.atndalert.model.AtndEvent) model;
        m.setEntityVersion(m.getEntityVersion() + 1L);
    }

    @Override
    protected void prePut(Object model) {
        assignKeyIfNecessary(model);
        incrementVersion(model);
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

}