package yu.com.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * 获取具体信息需要传的参数
 *
 */

public class RequestModel {
    @Attribute(name = "xmlns",empty = "http://tempuri.org/")
    public String namespace;

    @Element(name = "json", required = false)
    public String json;     //城市名字

    @Element(name = "sign", required = false)
    public String sign;     //城市名字

    public RequestModel (String json,String sign){
        this.json=json;
        this.sign=sign;
    }

}
