package com.appspot.atndalert.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2010-11-23 14:19:29")
/** */
public final class AlertWordMeta extends org.slim3.datastore.ModelMeta<com.appspot.atndalert.model.AlertWord> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AlertWord> alertWord = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AlertWord>(this, "alertWord", "alertWord");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AlertWord, java.lang.Long> entityVersion = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AlertWord, java.lang.Long>(this, "entityVersion", "entityVersion", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AlertWord, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.atndalert.model.AlertWord, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AlertWord> loginName = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AlertWord>(this, "loginName", "loginName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AlertWord> mailAddress = new org.slim3.datastore.StringAttributeMeta<com.appspot.atndalert.model.AlertWord>(this, "mailAddress", "mailAddress");

    private static final AlertWordMeta slim3_singleton = new AlertWordMeta();

    /**
     * @return the singleton
     */
    public static AlertWordMeta get() {
       return slim3_singleton;
    }

    /** */
    public AlertWordMeta() {
        super("AlertWord", com.appspot.atndalert.model.AlertWord.class);
    }

    @Override
    public com.appspot.atndalert.model.AlertWord entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.atndalert.model.AlertWord model = new com.appspot.atndalert.model.AlertWord();
        model.setAlertWord((java.lang.String) entity.getProperty("alertWord"));
        model.setEntityVersion(longToPrimitiveLong((java.lang.Long) entity.getProperty("entityVersion")));
        model.setKey(entity.getKey());
        model.setLoginName((java.lang.String) entity.getProperty("loginName"));
        model.setMailAddress((java.lang.String) entity.getProperty("mailAddress"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.atndalert.model.AlertWord m = (com.appspot.atndalert.model.AlertWord) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("alertWord", m.getAlertWord());
        entity.setProperty("entityVersion", m.getEntityVersion());
        entity.setProperty("loginName", m.getLoginName());
        entity.setProperty("mailAddress", m.getMailAddress());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.atndalert.model.AlertWord m = (com.appspot.atndalert.model.AlertWord) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.atndalert.model.AlertWord m = (com.appspot.atndalert.model.AlertWord) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.atndalert.model.AlertWord m = (com.appspot.atndalert.model.AlertWord) model;
        return m.getEntityVersion();
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.atndalert.model.AlertWord m = (com.appspot.atndalert.model.AlertWord) model;
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