package com.zick.HttpClientTest;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.*;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */
public class HttpClientTest {

    @Test
    public void jUnitTest() {
        get();
    }
    /**
     * 发送 get请求
     */
    public void get() {
        // TODO Auto-generated method stub
        String url="http://maoyan.com/";


        //1.使用默认的配置的httpclient
        CloseableHttpClient client = HttpClients.createDefault();
        //2.使用get方法
        HttpGet httpGet = new HttpGet(url);
        InputStream inputStream = null;
        CloseableHttpResponse response = null;

        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);


            //看请求是否成功，这儿打印的是http状态码
            System.out.println(response.getStatusLine().getStatusCode());
            //4.获取响应的实体内容，就是我们所要抓取得网页内容
            HttpEntity entity = response.getEntity();

            //5.将其打印到控制台上面
            //方法一：使用EntityUtils
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity, "utf-8"));
            }
            EntityUtils.consume(entity);

            //方法二  :使用inputStream
           /* if (entity != null) {
                inputStream = entity.getContent();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);

                }
            }*/

        } catch (UnsupportedOperationException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 发送 post请求 访问本地应用并根据传递参数不同返回不同结果
     */
    public static void post(String url) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("inputVal", "13301330133"));

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out
                            .println("--------------------------------------");
                    System.out.println("Response content: "
                            + EntityUtils.toString(entity, "UTF-8"));
                    System.out
                            .println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * post方式提交表单（模拟用户登录请求）
     */
    public static void postForm(String url) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("j_username", "13301330133"));
        formparams.add(new BasicNameValuePair("j_password", "330133"));
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out
                            .println("--------------------------------------");
                    System.out.println("Response content: "
                            + EntityUtils.toString(entity, "UTF-8"));
                    System.out
                            .println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传文件
     */
    public static void upload(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);
            FileBody bin = new FileBody(new File(
                    "C:\\Users\\zhangwenchao\\Desktop\\jinzhongzi.jpg"));
            // StringBody name = new StringBody("这个一测试",
            // ContentType.TEXT_PLAIN);
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addPart("uploadFile", bin)
                    .setCharset(CharsetUtils.get("UTF-8")).build();
            httppost.setEntity(reqEntity);
            System.out.println("executing request: "
                    + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);

            // httppost = new
            // HttpPost(response.getLastHeader("location").getValue());
            // response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    // 响应长度
                    System.out.println("Response content length: "
                            + resEntity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: "
                            + EntityUtils.toString(resEntity));
                }
                // 销毁
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件下载
     */
    public static void download(String url) {
        // 生成一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                // 响应长度
                System.out.println("Response content length: "
                        + resEntity.getContentLength());
                InputStream in = resEntity.getContent();
                String fileName = url.substring(url.lastIndexOf("/"));
                File file = new File("E:\\" + fileName);
                try {
                    FileOutputStream fout = new FileOutputStream(file);
                    int l = -1;
                    byte[] tmp = new byte[1024];
                    while ((l = in.read(tmp)) != -1) {
                        fout.write(tmp, 0, l);
                        // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
                    }
                    fout.flush();
                    fout.close();
                } finally {
                    // 关闭低层流。
                    in.close();
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * HttpClient连接SSL，需要导入证书的方法
     * 若SSL需要导入信任的证书，使用该方法
     * @param url
     */
    public static void ssl(String url) {
        CloseableHttpClient httpclient = null;
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType());
            FileInputStream instream = new FileInputStream(new File(
                    "E:\\tomcat.keystore"));
            try {
                // 加载keyStore d:\\tomcat.keystore
                trustStore.load(instream, "123456".toCharArray());
            } catch (CertificateException e) {
                e.printStackTrace();
            } finally {
                try {
                    instream.close();
                } catch (Exception ignore) {
                }
            }
            // 相信自己的CA和所有自签名的证书
            SSLContext sslcontext = SSLContexts
                    .custom()
                    .loadTrustMaterial(trustStore,
                            new TrustSelfSignedStrategy()).build();
            // 只允许使用TLSv1协议
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext,
                    new String[] { "TLSv1" },
                    null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf)
                    .build();
            // 创建http请求(get方式)
            HttpGet httpget = new HttpGet(url);
            System.out.println("executing request" + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: "
                            + entity.getContentLength());
                    System.out.println(EntityUtils.toString(entity));
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 不需要导入证书，SSL信任所有证书，使用该方法
     *
     * @return
     */
    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
                    null, new TrustStrategy() {
                        // 信任所有证书
                        public boolean isTrusted(X509Certificate[] chain,
                                                 String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();

        } catch (KeyManagementException e) {

            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        } catch (KeyStoreException e) {

            e.printStackTrace();

        }
        return HttpClients.createDefault();

    }

    /**
     * HttpClient连接SSL，不需要导入证书
     * 信任所有证书，跳过证书验证
     * @param url
     */

    public static void ssl2(String url) {
        CloseableHttpClient httpclient = null;
        try {

            httpclient = createSSLClientDefault();
            // 创建http请求(get方式)
            HttpGet httpget = new HttpGet(url);
            System.out.println("executing request" + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: "
                            + entity.getContentLength());
                    System.out.println(EntityUtils.toString(entity));
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
