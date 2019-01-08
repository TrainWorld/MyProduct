package yu.com.HttpUtil;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import yu.com.bean.HttpBean;
import yu.com.response.ResponseEnvelope;

public class Obser {

    /**
     * 抽离soap解析层逻辑
     * @param observable
     * @return
     */
    public static Observable<HttpBean> getObservable(Observable<ResponseEnvelope> observable){
        return observable
                .subscribeOn(Schedulers.io())//上游发送线程
                .map(new Function<ResponseEnvelope,HttpBean>() {
                    @Override
                    public HttpBean apply(ResponseEnvelope responseEnvelope) throws Exception {
                        String strGson = responseEnvelope.body.model.result;
                        Gson gson = new Gson();
                        HttpBean httpBean = gson.fromJson(strGson,HttpBean.class);
                        return httpBean;
                    }
                });
    };

}
