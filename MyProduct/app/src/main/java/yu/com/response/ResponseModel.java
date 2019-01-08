package yu.com.response;



import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * 用户角色返回
 *
 */
@Namespace(reference = "http://tempuri.org/" )
public class ResponseModel {

    @Element(name = "CompanyCashedNewResult" , required = false)
    public String result;

    @Element(name = "CompanyCashedNew" , required = false)
    public String result2="ggg";
}
