package com.thlly.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class UploadImg {
    private static PoolingHttpClientConnectionManager pc = new PoolingHttpClientConnectionManager();
    private static CloseableHttpResponse response=null;
    public static String uploadImg(byte[] imgByte,String fileName) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pc).build();
        HttpPost httpPost = new HttpPost("https://upload.huluxia.net/upload/image/larger");
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
        multipartEntityBuilder.addBinaryBody("file", imgByte, ContentType.MULTIPART_FORM_DATA, fileName);
        httpPost.setEntity(multipartEntityBuilder.build());
        response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity, "utf8");
        return s.substring(s.indexOf("http"), s.indexOf("\"", s.indexOf("http")));
    }
}

