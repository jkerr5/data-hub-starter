package com.marklogic.hubstarter.auth;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * "Simple" in that it doesn't do anything. Useful for development, but should NOT be used for a
 * production environment.
 */
public class SimpleX509TrustManager implements X509TrustManager {

    /**
     * Factory method for creating a simple SSLContext that uses this class as its TrustManager.
     *
     * @return
     */
    public static SSLContext newSSLContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSLv3");
            sslContext.init(null, new TrustManager[] { new SimpleX509TrustManager() }, null);
            return sslContext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

}
