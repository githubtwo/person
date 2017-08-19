package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.test.common.Const;
import com.test.common.ResponseCode;
import com.test.common.ServerResponse;
import com.test.pojo.User;
import com.test.service.ICardService;
import com.test.service.IOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/17.
 */
@RestController
@RequestMapping("/order/")
public class OrderController {

    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoGS8aL/fQdFuWSVRQHY/Os7UzN0cfV+HM3CVmxSmq8VOvOWbo7OE4CfTvXeaosuQ7mRS6K7lSzvZ5ISCthJ84eyEQWhfda4X21SU2Ya+0BsTR7P7aDhyMzdgq9uaBLUJtor0vWkGM1SqoySs99/ytIw1Z+tQs1H9t3T3Q0LsIUIZ/ItFoxYXm6C/OMvB+DtLVYf9SdXkZNFLtOvEK0dMqxurIREfCJkkykdjO3aWvhI5PkPL0T17b1Xjuwe3paiv2hJOyp5FH/6x1WKnSLPIQTouG9cwNtaehw6ZMZFnfGJFqygPuiVIdO5vOUHCQegSLgr3py/0HJdaTy9u/lB6bQIDAQAB";

    @Resource
    private IOrderService iOrderService;

    @Resource
    private ICardService iCardService;

    @PostMapping("pay")
    public ServerResponse pay(HttpSession session,String cardNo,Integer money){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            if(!iCardService.getCardNo(cardNo)){
                return ServerResponse.createByErrorMessage("该卡号不存在");
            }
            return iOrderService.pay(cardNo,money,user.getId());
        }
       return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
    }


    @PostMapping("alipay_callback")
    public void callback(HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean flag = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, "utf-8","RSA2");

        if(!flag){
            String[] parms = URLDecoder.decode(params.get("passback_params"),"UTF-8").split("&");
            String orderId = params.get("trade_no");
            iOrderService.createRecharge(Float.valueOf(parms[0]),parms[1],parms[2],orderId);
        }
    }
}
