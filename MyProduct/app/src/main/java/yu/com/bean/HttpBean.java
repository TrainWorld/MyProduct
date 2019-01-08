package yu.com.bean;

public class HttpBean {


    /**
     * Status : 401
     * Msg : 请输入卡号后六位！
     * Data : null
     */

    private int Status;
    private String Msg;
    private String Data;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
}
