package spring_pegawai.pegawaiDbNew.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import spring_pegawai.pegawaiDbNew.util.threadlocals.LocalNotices;
import spring_pegawai.pegawaiDbNew.util.threadlocals.LocalWarnings;

import java.util.ArrayList;
import java.util.HashMap;

@JsonInclude(Include.ALWAYS)
public class ApiResponse {

    private static final String status_ok = "Ok";
    private static final String status_warning = "Warning";
    private static final String status_error = "Error";

    private HashMap<String, Object> data;
    private HashMap<String, Object> meta;

    private ArrayList<Message> errors;
    private ArrayList<Message> notices;
    private ArrayList<Message> warnings;

    private String status;

    public ApiResponse() {
        data = new HashMap<String, Object>();
        meta = new HashMap<String, Object>();
        errors = new ArrayList<Message>();
        notices = new ArrayList<Message>();
        warnings = new ArrayList<Message>();
    }

    public static ApiResponse create() {
        return new ApiResponse();
    }

    public static ApiResponse data(String key, Object value) {
        ApiResponse apiResponse = ApiResponse.create()
                .addData(key, value)
                .addNotices(LocalNotices.getNotices())
                .addWarnings(LocalWarnings.getWarnings());
        removeLocalNoticesWarnings();
        return apiResponse;
    }

    public static ApiResponse error(Message error) {
        ApiResponse apiResponse = ApiResponse.create()
                .addError(error)
                .changeStatus(status_error);
        removeLocalNoticesWarnings();
        return apiResponse;
    }

    public static ApiResponse errors(ArrayList<Message> errors) {
        ApiResponse apiResponse = ApiResponse.create()
                .addErrors(errors)
                .changeStatus(status_error);
        removeLocalNoticesWarnings();
        return apiResponse;
    }

    public static ApiResponse upload(int rowsUploaded) {
        ApiResponse apiResponse = ApiResponse.create()
                .addNotice(Message.create().setCode("upload.success").setDesc("'" + rowsUploaded + "' rows uploaded!").setArgs(rowsUploaded))
                .changeStatus(status_ok);
        removeLocalNoticesWarnings();
        return apiResponse;
    }

    public static ApiResponse ok(){
        ApiResponse apiResponse = ApiResponse.create()
                .addNotices(LocalNotices.getNotices());
        removeLocalNoticesWarnings();
        return apiResponse;
    }

    //    Remove
    public static void removeLocalNoticesWarnings() {
        LocalNotices.remove();
        LocalWarnings.remove();
    }

    //    addData
    public ApiResponse addData(String key, Object value) {
        this.data.put(key, value);
        this.changeStatus(status_ok);
        return this;
    }

    //    addMeta
    public ApiResponse addMeta(String key, Object value) {
        this.meta.put(key, value);
        return this;
    }

    //    addError
    public ApiResponse addError(Message myMessage) {
        this.errors.add(myMessage);
        return this;
    }

    //    addErrors
    public ApiResponse addErrors(ArrayList<Message> errors) {
        errors.forEach(error -> {
            this.errors.add(error);
            this.changeStatus(status_error);
        });
        return this;
    }

    //    addNotice
    public ApiResponse addNotice(Message myMessage) {
        this.notices.add(myMessage);
        return this;
    }

    //    addNotices
    public ApiResponse addNotices(ArrayList<Message> notices) {
        notices.forEach(notice -> {
            this.notices.add(notice);
            this.changeStatus(status_ok);
        });
        return this;
    }

    //    addWarning
    public ApiResponse addWarning(Message warning) {
        this.notices.add(warning);
        return this;
    }

    //    addWarnings
    public ApiResponse addWarnings(ArrayList<Message> warnings) {
        warnings.forEach(warning -> {
            this.warnings.add(warning);
            this.changeStatus(status_warning);
        });
        return this;
    }

    //    changeStatus
    public ApiResponse changeStatus(String status) {
        this.status = status;
        return this;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public HashMap<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(HashMap<String, Object> meta) {
        this.meta = meta;
    }

    public ArrayList<Message> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Message> errors) {
        this.errors = errors;
    }

    public ArrayList<Message> getNotices() {
        return notices;
    }

    public void setNotices(ArrayList<Message> notices) {
        this.notices = notices;
    }

    public ArrayList<Message> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<Message> warnings) {
        this.warnings = warnings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
