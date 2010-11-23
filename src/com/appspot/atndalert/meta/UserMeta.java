package com.appspot.atndalert.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2010-11-23 14:19:29")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<com.appspot.atndalert.model.User> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.User, java.lang.Long> entityVersion = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.User, java.lang.Long>(this, "entityVersion", "entityVersion", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.User> loginName = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.User>(this, "loginName", "loginName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.User> mailAddress = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.User>(this, "mailAddress", "mailAddress");

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", com.appspot.atndalert.model.User.class);
    }

    @Override
    public com.appspot.atndalert.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.atndalert.model.User model = new com.appspot.atndalert.model.User();
        model.setEntityVersion(longToPrimitiveLong((java.lang.Long) entity.getProperty("entityVersion")));
        model.setKey(entity.getKey());
        model.setLoginName((java.lang.String) entity.getProperty("loginName"));
        model.setMailAddress((java.lang.String) entity.getProperty("mailAddress"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.atndalert.model.User m = (com.appspot.atndalert.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("entityVersion", m.getEntityVersion());
        entity.setProperty("loginName", m.getLoginName());
        entity.setProperty("mailAddress", m.getMailAddress());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.atndalert.model.User m = (com.appspot.atndalert.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.atndalert.model.User m = (com.appspot.atndalert.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.atndalert.model.User m = (com.appspot.atndalert.model.User) model;
        return m.getEntityVersion();
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.atndalert.model.User m = (com.appspot.atndalert.model.User) model;
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