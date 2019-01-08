package yu.com.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回body
 *
 */
@Root(name = "Body")
public class ResponseBody {

    @Element(name = "CompanyCashedNewResponse", required = false)
    public ResponseModel model;

}
