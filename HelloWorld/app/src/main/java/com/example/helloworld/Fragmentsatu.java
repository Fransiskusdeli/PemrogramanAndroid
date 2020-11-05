package com.example.helloworld;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragmentsatu extends Fragment {

    private static final String TAG = "Fragmentsatu";
    public static String MY_FLAG = "MY_FLAG";
    private Button btnMulai;
    private Button btnBerhenti;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentsatu, container, false);
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        btnMulai= findViewById(R.id.mulai);
//        btnBerhenti=findViewById(R.id.berhenti);
//    }


//    public void scheduleJob(View view){
//        Log.i(TAG, "onStartJob: Masuk");
//        Log.i(TAG, "onStartJobService: Membuat componentName");
//
//        ComponentName componentName = new ComponentName(requireActivity().getApplicationContext(), JobServiceku.class);
//        JobInfo info = new JobInfo.Builder(123, componentName)
//                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
//                .setPersisted(true)
//                .setPeriodic(15*60*1000)
//                .build();
//
//        JobScheduler scheduler = (JobScheduler) requireContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
//        int resultCode = scheduler.schedule(info);
//        if (resultCode == JobScheduler.RESULT_SUCCESS){
//            Log.i(TAG, "scheduleJob: Job scheduled");
//        }else{
//            Log.i(TAG, "scheduleJob: Job scheduling failed");
//        }
//    }

    public void batalSchedule(View view){
        JobScheduler scheduler = (JobScheduler) requireContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
//        scheduler.cancel(123);
//        Log.i(TAG, "batalSchedule");
        Log.i(TAG, "onStopJobService: job di hentikan");
        Toast.makeText(requireContext().getApplicationContext(),"Service dihentikan",Toast.LENGTH_SHORT).show();
    }

//    private void serviceInit(){
//        btnMulai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                scheduleJob();
//            }
//        });
//        btnBerhenti.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                batalSchedule();
//            }
//        });
//    }
}