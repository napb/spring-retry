package com.example.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class DefaultRetryListener extends RetryListenerSupport {

    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println("----- listener close -----");
        super.close(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println("----------");
        System.out.println("----- listener on error -----");
        System.out.println("----- context "+context+" -----");
        System.out.println("----- callback "+callback+" -----");
        System.out.println("----- throwable "+throwable+" -----");
        System.out.println("----------");

        super.onError(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        System.out.println("----- listener open -----");
        return super.open(context, callback);
    }

}
