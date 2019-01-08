package yu.com.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;


/**
 * 用户角色请求Envelope
 *
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(reference = "http://tempuri.org/", prefix = "tem"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv")
})
public class RequestEnvelope {
    @Element(name = "soapenv:Body", required = false)
    public RequestBody body;

    public RequestEnvelope(RequestBody body){
        this.body=body;
    }

}
