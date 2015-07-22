package com.example.michael.lunchfinder.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;


/**
 * Loader that fixes a couple of bugs/problems with support lib AsyncTaskLoader.
 * See http://stackoverflow.com/questions/10524667/android-asynctaskloader-doesnt-start-loadinbackground
 */
public abstract class BaseLoader<D> extends AsyncTaskLoader<D> {

    public BaseLoader(Context context) {
        super(context);
        onContentChanged();
    }

    @Override
    protected void onStartLoading() {
            if (takeContentChanged()) {
                forceLoad();
            }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
