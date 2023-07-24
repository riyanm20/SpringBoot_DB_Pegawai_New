package spring_pegawai.pegawaiDbNew.exceptions;

public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String flag;
    private String message;

    public CustomException(String flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
