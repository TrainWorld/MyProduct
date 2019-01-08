package yu.com.Onclick;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import org.apache.commons.lang3.StringEscapeUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import yu.com.HttpUtil.Obser;
import yu.com.HttpUtil.SoapManagement;
import yu.com.bean.HttpBean;
import yu.com.request.RequestBody;
import yu.com.request.RequestEnvelope;
import yu.com.request.RequestModel;


public class MyHomeOnClick {

    private final String TAG = "MyHomeOnClick";


    public void GetOnClick(View view) {

        Snackbar.make(view, "我是get请求", Snackbar.LENGTH_SHORT).show();
    }

    public void PostOnClick(View view) {

        String json = "{\"cardNo\":\"1111\",\"uid\":\"559176\",\"timestamp\":\"2018-12-20 14:36:21\",\"Ip\":\"10.0.2.15\",\"cardPwd\":\"2222\",\"versionnum\":\"3.2.58\",\"machinedesc\":\"CHM-TL00H-4.4.4-7ACFF6E1612240D66B5A7EA8D20EFF10\",\"Imei\":\"490551440699280\",\"platformtype\":\"android\",\"OperatType\":\"\",\"City\":\"上海\"}";

        String tmp = StringEscapeUtils.unescapeJson(json);

        String sign = "6c1040dc2b4537424cd7ee915e8f2393";

        RequestBody requestBody = new RequestBody();
        requestBody.requestModel = new RequestModel(json, sign);
        RequestEnvelope requestEnvelope = new RequestEnvelope(requestBody);

        Obser.getObservable(SoapManagement.getSoapManagement()
                .CreatObservable().addAddress(requestEnvelope))
                .map(new Function<HttpBean, String>() {
                    @Override
                    public String apply(HttpBean httpBean) throws Exception {

                        String data = httpBean.getStatus() + "|" + httpBean.getMsg() + "|" + httpBean.getData();

                        return data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//下游接收线程
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String responseEnvelope) {
                        Log.i("yuaoyu", responseEnvelope + "");
                        Log.i("yuaoyu", Thread.currentThread().getName() + "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("yuaoyu", e.getMessage() + "");
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Snackbar.make(view, "我是post请求", Snackbar.LENGTH_SHORT).show();
    }

}
