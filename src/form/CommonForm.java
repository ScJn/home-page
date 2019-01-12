package form;

public class CommonForm {
    private String message;
    private int status;
    private Object data;

    public CommonForm(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonForm of200(String message,Object data){
        return new CommonForm(message,0,data);
    }

    public static CommonForm of400(String message){
        return new CommonForm(message,400,null);
    }

    public static CommonForm of204(String message){
        return new CommonForm(message,0,null);
    }
}
