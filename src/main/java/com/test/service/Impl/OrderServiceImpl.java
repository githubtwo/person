package com.test.service.Impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.test.common.ServerResponse;
import com.test.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/17.
 */
@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {

    String APP_ID = "2016082000293876";

    String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEnetaRhT74cS3Uz9dfTb16w0Kv9wge1MTSNENx3n6qnIgd8pVUzigLRY2/AjWe1z3L14NFdBir3HQFR1ZAonQgjUidpG4ZCB3Wr313vnQlMXfQPbshbQCN+2MesJh2U7C3VMxiODW2HsbCR2+6zEwL0HxxKanbJ4pxSxsamQQVGcIYXFTxIPP1BIh3jdsbnIA/P2wt1kE0lWi++k3IX/pDq5zmbZQxgpWX7SvXejWaKoIVbjL4WRUnVmKGm/M2ipvwhY9F1VXaosSEZuYCHQR89AwPNlqMXSUa1TMhH1B1WAx8ZZZNcNa2apuhWVEwABurM0V6vLQNcrXd/5RbK3HAgMBAAECggEAfabfCu6iDTIR4B05SYxNWd42wjudBw2yXfA9W4/oLC/46Hh3tjaezW1Kwhg1C3thTzeLJlzHz+kprh2DbAWyrGPikl/Dm/EKrevFVsPI8O81OF3mV54rO3rgUZ0yteFe9dUccS+e0RHWOnx9uZpARcZQ9hD8Ul/gz/TpLWP0oV7pGqVi8yuelgDYotY7Tjf1O4m3P0Kb1vE132u/YIol53ohg3NJCKQMayfZrKcc5hLbjTjc7BX6ZfNXinw4Y5laxhByH8oMD7/DMZt0NKPlwc2WXbHjY0wAiQJvO2QAFUyt4MryR3zAFlaJjdRVgdIQn0aX/GY0HcYdG/ZRriTw0QKBgQDGCWIAM05mXdt3Cm8UuB2yZ5c8+09BO015J2G0kf2vIKOzUpQld1fP5Sm4H+uEpDo7TG17d81Vv83tpkTAfCXigsO94Jj1/q5Cjj6ZHzy2ilP5At4CvXpaZT2gyuC+vwDFt9MtIJCJHM7RBlW1QwU+AHLET6St/bmPpgkb51fVqQKBgQCrbrisTD8T6TGy3DyR41RsjaXfzm2PKYltBcoCZXAK8H+wfSxqkfq+F5DB0E5n83e3IfeobbSfUmYDktlc4NCWAysw98EfutcgYgYIfIwPK0UfpSi2CujQjoIZJ2DEyvdztpulfU0GFeSO01cZa3mNhKt8d1cXbVVhFaxSlmGt7wKBgQCrddg54DITA1ROvuPqBnb/zhztmZDHI7cyHFzF4FjKVfImAmtt/OQ0hW8XkdtyXlZknQl1iwZnJcf/6KNCHLsYYKtlLJ6C7dyml02veZIxYZbO1CKwMKlMtrcjDkSEIg9jIINgYP+DF0QhSeDPLZXOVskHGwWz9yfALbtZQ3WS8QKBgAtS5/3xl2UQTUkcRR/53TTCcoeDEjeXrc02ya441xrR4g1dZ1aux9pQoi47PUKekXTWWI6WmIzBm5120MbSztRp5yt34hjfdaBc+TsMRxAlco5xkWvc8p38G9nfgQPeyFOrZ0KaMUFKputMSH+UWtYfQliZZXZVsYMVNGnMJy2fAoGAaSRC9Z0QAOmCbPt+/8JuPlX7jhSbuBZe2v32oQ9pZ5cmzUTz7zLWNKa5GBY0r2Rn+SBZrAJBlkc6+6x+ihcDCPyIztBtCNWE7eRYHmPSqlFWYQTizea2wn4F/q6wnCLFBVwmeYmO6imAxmPjPb8kJ2OLZkJ8dEh38wgfE3xZisI=";
    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoGS8aL/fQdFuWSVRQHY/Os7UzN0cfV+HM3CVmxSmq8VOvOWbo7OE4CfTvXeaosuQ7mRS6K7lSzvZ5ISCthJ84eyEQWhfda4X21SU2Ya+0BsTR7P7aDhyMzdgq9uaBLUJtor0vWkGM1SqoySs99/ytIw1Z+tQs1H9t3T3Q0LsIUIZ/ItFoxYXm6C/OMvB+DtLVYf9SdXkZNFLtOvEK0dMqxurIREfCJkkykdjO3aWvhI5PkPL0T17b1Xjuwe3paiv2hJOyp5FH/6x1WKnSLPIQTouG9cwNtaehw6ZMZFnfGJFqygPuiVIdO5vOUHCQegSLgr3py/0HJdaTy9u/lB6bQIDAQAB";

    public ServerResponse pay(String cardNo,Integer money,String userId) {
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "utf-8", ALIPAY_PUBLIC_KEY, "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo((new Date()).getTime() + "" + (int) (Math.random() * 1000000));
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        String backParams = money+"&"+cardNo+"&"+userId;
        try {
            model.setPassbackParams(URLEncoder.encode(backParams,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("http://47.93.243.239:8080/mmall/order/alipay_callback");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            return ServerResponse.createBySuccess(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return ServerResponse.createByErrorMessage("生成订单错误");
    }



    @Transactional
    public void createRecharge(Float price, String cardNo, String userId, String orderId) {

    }


    }
