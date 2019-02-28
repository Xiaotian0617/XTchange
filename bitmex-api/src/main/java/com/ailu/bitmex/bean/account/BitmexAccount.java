package com.ailu.bitmex.bean.account;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;


public final class BitmexAccount {

  @JSONField(name = "id")
  private Integer id;
  @JSONField(name = "ownerId")
  private Integer ownerId;
  @JSONField(name = "firstname")
  private String firstname;
  @JSONField(name = "lastname")
  private String lastname;
  @JSONField(name = "username")
  private String username;
  @JSONField(name = "email")
  private String email;
  @JSONField(name = "phone")
  private String phone;
  @JSONField(name = "created")
  private String created;
  @JSONField(name = "lastUpdated")
  private String lastUpdated;
  @JSONField(name = "preferences")
  private BitmexAccountPreferences preferences;
  @JSONField(name = "TFAEnabled")
  private String tFAEnabled;
  @JSONField(name = "affiliateID")
  private String affiliateID;
  @JSONField(name = "pgpPubKey")
  private String pgpPubKey;
  @JSONField(name = "country")
  private String country;
  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public BitmexAccountPreferences getPreferences() {
    return preferences;
  }

  public void setPreferences(BitmexAccountPreferences preferences) {
    this.preferences = preferences;
  }

  public String gettFAEnabled() {
    return tFAEnabled;
  }

  public void settFAEnabled(String tFAEnabled) {
    this.tFAEnabled = tFAEnabled;
  }

  public String getAffiliateID() {
    return affiliateID;
  }

  public void setAffiliateID(String affiliateID) {
    this.affiliateID = affiliateID;
  }

  public String getPgpPubKey() {
    return pgpPubKey;
  }

  public void setPgpPubKey(String pgpPubKey) {
    this.pgpPubKey = pgpPubKey;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}