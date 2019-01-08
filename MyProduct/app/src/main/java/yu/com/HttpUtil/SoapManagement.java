package yu.com.HttpUtil;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import yu.com.ServiceStore;

public class SoapManagement {

    private static String BASE_URL = "http://apics.bestcake.com";
    private static final int connectTimeout = 1;
    private static final int writeTimeout = 1;
    private static final int readTimeout = 1;
    private ServiceStore serviceStore;
    private SoapManagement() {

        OkHttpClient OkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(connectTimeout, TimeUnit.MINUTES)
                .writeTimeout(writeTimeout, TimeUnit.MINUTES)
                .readTimeout(readTimeout, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create(new Persister(new AnnotationStrategy())))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        serviceStore = retrofit.create(ServiceStore.class);
    }
    private static class SoapInstance {
        private static final SoapManagement soapInstance = new SoapManagement();
    }
    public static SoapManagement getSoapManagement() {
        return SoapInstance.soapInstance;
    }

    public ServiceStore CreatObservable(){

        return serviceStore;
    }


}
