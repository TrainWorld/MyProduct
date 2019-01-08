package yu.com.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回body
 *
 */
@Root(name = "soapenv:Body", strict = false)
public class RequestBody {

@Element(name = "CompanyCashedNew", required = false)
    public RequestModel requestModel;


}
