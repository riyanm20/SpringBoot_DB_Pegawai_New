package spring_pegawai.pegawaiDbNew.util.threadlocals;

import org.springframework.stereotype.Component;
import spring_pegawai.pegawaiDbNew.util.Message;

import java.util.ArrayList;

@Component
public class LocalNotices {

    private static ThreadLocal<ArrayList<Message>> noticesHolder = new ThreadLocal<ArrayList<Message>>();

    private static boolean hashNotices() { return noticesHolder.get() != null; }

    public static void createIfEmpty() {
        if ( !hashNotices() ) {
            noticesHolder.set(new ArrayList<Message>());
        }
    }

    public static ArrayList<Message> getNotices() {
        createIfEmpty();
        return noticesHolder.get();
    }

    public void addNotices(Message notice) {
        createIfEmpty();
        noticesHolder.get().add(notice);
    }

    public static void remove() { noticesHolder.remove(); }

}
