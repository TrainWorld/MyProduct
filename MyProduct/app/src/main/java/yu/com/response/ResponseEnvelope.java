package yu.com.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回总信息
 *
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "t")
})
public class ResponseEnvelope {
    @Element(name = "Body")
    public ResponseBody body;

}
