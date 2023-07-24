package spring_pegawai.pegawaiDbNew.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Message {

    private String code;
    private String desc;

    @JsonInclude(Include.ALWAYS)
    private Object hint;

    @JsonInclude(Include.ALWAYS)
    private Object args;

    public Message() {
        this.code = "";
        this.desc = "";
        this.hint = "";
        this.args = "";
    }

    public static Message create() { return new Message(); }

    public Message setCode(String code) {
        this.code = code;
        return this;
    }

    public Message setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Message setHint(Object hint) {
        this.hint = hint;
        return this;
    }

    public Message setArgs(Object... args) {
        this.args = args;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Object getHint() {
        return hint;
    }

    public Object getArgs() {
        return args;
    }
}