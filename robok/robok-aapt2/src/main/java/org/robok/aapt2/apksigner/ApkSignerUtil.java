package org.robok.aapt2.apksigner;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import com.android.apksig.ApkSigner;
import com.android.apksig.ApkSigner.SignerConfig;
import com.android.apksig.ApkSigner.Builder;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Collections;

public class ApkSignerUtil {

    public static void signApk(Context context, String inputApkPath, String outputApkPath, String keystoreAssetPath, String keystorePassword, String keyAlias, String keyPassword) throws Exception {
        // Copia o keystore dos assets para o sistema de arquivos
        File keystoreFile = copyKeystoreFromAssets(context, keystoreAssetPath, "tempkey.jks");

        // Carrega o keystore
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(keystoreFile), keystorePassword.toCharArray());

        // Carrega a chave privada e o certificado
        KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(keyAlias, new KeyStore.PasswordProtection(keyPassword.toCharArray()));
        PrivateKey privateKey = entry.getPrivateKey();
        // Converte o certificado para X509Certificate
        X509Certificate certificate = (X509Certificate) entry.getCertificate();

        // Configura o signer
        SignerConfig signerConfig = new SignerConfig.Builder(keyAlias, privateKey, Collections.singletonList(certificate)).build();

        // Arquivos APK
        File inputApk = new File(inputApkPath);
        File outputApk = new File(outputApkPath);

        // Assina o APK
        ApkSigner apkSigner = new ApkSigner.Builder(Collections.singletonList(signerConfig))
                .setInputApk(inputApk)
                .setOutputApk(outputApk)
                .build();
        apkSigner.sign();

        System.out.println("APK assinado com sucesso!");
    }

    private static File copyKeystoreFromAssets(Context context, String assetPath, String keystoreName) throws IOException {
    File keystoreFile = new File(context.getFilesDir(), keystoreName);
    
    try (InputStream is = context.getAssets().open(assetPath);
         FileOutputStream fos = new FileOutputStream(keystoreFile)) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
    } catch (IOException e) {
        e.printStackTrace();
        throw new IOException("Erro ao copiar o keystore dos assets: " + e.getMessage());
    }
    
    return keystoreFile;
}
}