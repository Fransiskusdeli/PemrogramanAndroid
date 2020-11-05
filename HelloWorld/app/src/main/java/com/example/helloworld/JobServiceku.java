package com.example.helloworld;


import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.logging.LogRecord;

public class JobServiceku extends JobService {
private static final String TAG = JobServiceku.class.getSimpleName();
private boolean jobPembatalan = false;
Context context;
    @Override
    public boolean onStartJob(JobParameters params) {

        context = getApplicationContext();
        doBackground(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "onStopJob: batal ");
        jobPembatalan= true;
        return true;
    }

    private void doBackground(final JobParameters parameters){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    Log.i(TAG, "run: "+1);
                    final int finalI = i;
                    Handler myHandler = new Handler(getMainLooper());
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG, "handler run: "+finalI);
                        }
                    });

                    if (jobPembatalan){
                        return;
                    } try{
                            Thread.sleep(3000);
                    } catch (InterruptedException e){
                        Log.e(TAG, "InterrupException: ",e.getCause() );
                    }
                }
                Log.i(TAG, "run: JOB SLESAI");
            }
        }).start();

    }
}
