package com.example.admin.learn_aidl_serivce;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou.jn
 *
 * @create_at 2018/8/8 14:37
 */
public class BookManagerService extends Service {

    List<Book> mBookList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book("Android 探索艺术",98));
        mBookList.add(new Book("Thinking in Java",120));
    }

    private Binder mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            synchronized (this) {
                    return mBookList;
            }
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                    mBookList.add(book);
            }
        }

    };

    public BookManagerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
