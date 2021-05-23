package lei.lei.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.models.HttpMethod;
import lei.lei.entity.ApponitExam;
import lei.lei.service.HttpCllient;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import lei.lei.service.HttpClientUtils;
@Controller
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class HelloController {


    //异常报错提示
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HttpCllient httpclient;

    //读取配置文件获取URL
    @Value("${test.msg}")
    private String msg;


    @Value("${test.msg1}")
    private String msg1;


    @Value("${test.msg2}")
    private String msg2;


    //用户通过访问这个地址 /api/GetComobo 后进行一个再次的连接 的地址msg 最后返回一个json数据
    @ResponseBody
    @PostMapping("/api/GetComobo/{code}")
    public String hello(@PathVariable String code, HttpServletRequest request) throws Exception {
        String message=null;
        if (code.equals("333")) {
            //获取http里面的 AllowSex 的值
            String AllowSex = request.getParameter("AllowSex");
            Map<String, String> map = new HashMap<String, String>();
            map.put("AllowSex", AllowSex);
            HttpClientUtils httpClientUtils = new HttpClientUtils();

            HttpClient client = httpClientUtils.getConnection();
            HttpUriRequest post = httpClientUtils.getRequestMethod(map, msg, "post");
            HttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == 200) {
                org.apache.http.HttpEntity entity = response.getEntity();
                message = EntityUtils.toString(entity, "utf-8");
                System.out.println(message);
            } else {
                System.out.println("请求失败");
            }
        }
        return message;
    }

    @ResponseBody
    @PostMapping("/api/ApponitExam/{code}")
    public HttpEntity<String>  hello1(@PathVariable String code ,@RequestBody Map<String ,Object> map) {
            HttpEntity<String>  client=null;
        //判断code 的值
        if(code.equals("333")){
            // 注意replaceAll前面的是正则表达式
            // String uuid = UUID.randomUUID().toString().replaceAll("-","");

        //利用list来接受字段
        //List<String> paramNames = new ArrayList<String>(map.size());
        //放入键
        //paramNames.addAll(map.keySet());
        //放入值
            //log.info("map的值:::::::",map);
        //进行list排序
        //Collections.sort(paramNames);
        //设置地段属性
        //String params1="";
        //String beginLetter="?";
        //循环遍历集合里面的值
            //String smap = JSON.toJSONString(map);
            StringBuilder urlParams = new StringBuilder("?");
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for(Map.Entry<String, Object> paramName :map.entrySet()){
                urlParams.append(paramName.getKey()).append("=").append(paramName.getValue()).append("&");
            }
            //map.put("AppSourceId",uuid);
            String urlParamsStr = urlParams.toString();
            String substring = urlParamsStr.substring(0, urlParamsStr.length() - 1);

        /*for (String paramName : paramNames) {
            if (params1.equals(""))
            {
                params1 += beginLetter + paramName + "=" + map.get(paramName);
            }
            else
            {
                params1 += "&" + paramName + "=" + map.get(paramName);
            }
        }*/

        String url=msg1+substring;
        HttpMethod method=HttpMethod.POST;
        MultiValueMap<String,String> params=new LinkedMultiValueMap<String, String>();

        try{
            client=httpclient.client(url, method, params);
        } catch(Exception e){
            log.error("ApponitExam",e);
        }
        }
        return client;
    }


    @ResponseBody
    @PostMapping("/api/CancelApitpon/{code}")
    public HttpEntity<String>  hello2(@PathVariable String code ,@RequestBody Map<String,Object> map1) {
        HttpEntity<String>  client=null;
        //判断code 的值
        if(code.equals("333")){
        //建字段放入map里面
        map1.put("AppSourceId","AppSourceId");
        map1.put("userName","userName");
        //放入集合里面的值 定义长度
        List<String> list=new ArrayList<String>(map1.size());
        //添加值
        list.addAll(map1.keySet());
        //对list进行排序sort表示静态的
        Collections.sort(list);
        //设置属性
        String  par="";
        String  Hider="?";
        //循环比哪里list里面的值
            for(String par1:list){
                if (par.equals(""))
                {
                    //拼接字段
                    par += Hider + par1 + "=" + map1.get(par1);
                }
                else
                {
                    par += "&" + par1 + "=" + map1.get(par1);
                }
            }
            //调用地址 拼接上去
            String url=msg2+par;
            //请求方式
        HttpMethod method=HttpMethod.POST;
        //所有的字段放入这个集合里面
        MultiValueMap<String,String> params=new LinkedMultiValueMap<String, String>();
        //调用HttpClient

        try{
            client=httpclient.client(url, method, params);
        } catch(Exception e){
            log.error("CancelApitpon",e);
        }
        }
        return client;
    }



}
