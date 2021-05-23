package lei.lei.service;

import com.alibaba.fastjson.JSON;
import io.swagger.models.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class HttpCllient {

    public HttpEntity<String> client(String url, HttpMethod method, MultiValueMap<String,String> params) {

        RestTemplate  template=new RestTemplate();
        String  json= JSON.toJSONString(params);
        HttpHeaders httphiders=new HttpHeaders();
        httphiders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> response1=new HttpEntity<String>(json,httphiders);
        return template.postForEntity(url,response1,String.class);

    }




}
