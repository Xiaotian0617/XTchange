package com.ailu.bitmex.utils.digest;

import java.util.Base64;

public class BitmexDigest extends BaseParamsDigest {

  public static final String HMAC_SHA_256 = "HmacSHA256";

  private String apiKey;

  /**
   * Constructor
   *
   * @param secretKeyBase64 the secret key to sign requests
   */

  private BitmexDigest(byte[] secretKeyBase64) {

    super(Base64.getUrlEncoder().withoutPadding().encodeToString(secretKeyBase64), HMAC_SHA_256);
  }

  public static BitmexDigest createInstance(String secretKeyBase64) {

    if (secretKeyBase64 != null) {
      return new BitmexDigest(Base64.getUrlDecoder().decode(secretKeyBase64.getBytes()));
    }
    return null;
  }

  public static String createInstanceStr(String secretKeyBase64) {

    if (secretKeyBase64 != null) {
      return new String(Base64.getUrlDecoder().decode(secretKeyBase64.getBytes()));
    }
    return null;
  }


  private BitmexDigest(String secretKeyBase64, String apiKey) {

    super(secretKeyBase64, HMAC_SHA_256);
    this.apiKey = apiKey;
  }

  public static BitmexDigest createInstance(String secretKeyBase64, String apiKey) {

    return secretKeyBase64 == null ? null : new BitmexDigest(secretKeyBase64, apiKey);
  }

}
