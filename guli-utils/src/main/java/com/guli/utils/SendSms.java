package com.guli.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;

public class SendSms {
    public String smsCode(String userPhone) {

        //  设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout","60000");
        System.setProperty("sun.net.client.defaultReadTimeout", "60000");

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fp68YwRUiCsn5tCHo24", "BwxwgDeYbbNk7XLRSsSCI5D7KpDAmd");
        IAcsClient client = new DefaultAcsClient(profile);
        //生成验证码
        Integer num = (int) ((Math.random() * 9 + 1) * 1000);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", userPhone);
        request.putQueryParameter("SignName", "0746Gaming");
        request.putQueryParameter("TemplateCode", "SMS_173761924");
        request.putQueryParameter("TemplateParam", "{\"code\":" + num + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            //将第一个与最后一个字符去掉
            data = data.substring(1, data.length() - 1);
            //将所有的"号替换成空
            data = data.replaceAll("\"", "");
            //根据逗号截取字符串数组
            String[] str1 = data.split(",");
            //创建Map对象
            Map<String, Object> map = new HashMap<>();
            //循环加入map集合
            for (int i = 0; i < str1.length; i++) {
                //根据":"截取字符串数组
                String[] str2 = str1[i].split(":");
                //str2[0]为KEY,str2[1]为值
                map.put(str2[0], str2[1]);
            }
            if ("OK".equals(map.get("Message"))) {
                return num.toString();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();



        }
        return null;
    }

}
