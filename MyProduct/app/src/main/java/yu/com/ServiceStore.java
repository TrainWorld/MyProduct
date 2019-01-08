package yu.com;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import yu.com.request.RequestEnvelope;
import yu.com.response.ResponseEnvelope;

public interface ServiceStore {

    @Headers({"Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/ICompany/CompanyCashedNew"})
    @POST("/Company.svc")
    Observable<ResponseEnvelope> addAddress(@Body RequestEnvelope requestEnvelope);


}
