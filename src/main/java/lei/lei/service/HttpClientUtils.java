package lei.lei.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class HttpClientUtils {

    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static HttpClientBuilder httpBulder = null;
    private static RequestConfig requestConfig = null;

    private static int MAXCONNECTION = 10;

    private static int DEFAULTMAXCONNECTION = 5;

    private static String IP = "cnivi.com.cn";
    private static int PORT = 80;

    static {
        //设置http的状态参数
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        HttpHost target = new HttpHost(IP, PORT);
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAXCONNECTION);
        connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);
        connectionManager.setMaxPerRoute(new HttpRoute(target), 20);
        httpBulder = HttpClients.custom();
        httpBulder.setConnectionManager(connectionManager);
    }

    public  CloseableHttpClient getConnection() {
        CloseableHttpClient httpClient = httpBulder.build();
        httpClient = httpBulder.build();
        return httpClient;
    }


    public  HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            params.add(pair);
        }
        HttpUriRequest reqMethod = null;
        if ("post".equals(method)) {
            reqMethod = RequestBuilder.post().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        } else if ("get".equals(method)) {
            reqMethod = RequestBuilder.get().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        }
        return reqMethod;
    }


}