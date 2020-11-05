package com.example.helloworld;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmentdua#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmentdua extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;

    public Fragmentdua() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmentdua.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmentdua newInstance(String param1, String param2) {
        Fragmentdua fragment = new Fragmentdua();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmentdua, container, false);
        recyclerView=view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder=new ArrayList<>();
        datamodel ob1=new datamodel(R.drawable.antman,"Ant-Man","Deskripsi dari film Ant-Man");
        dataholder.add(ob1);

        datamodel ob2=new datamodel(R.drawable.aveninfinitywar,"AVENGER-Infinity_War","Deskrisi dari film Avenger Infinity War");
        dataholder.add(ob2);

        datamodel ob3=new datamodel(R.drawable.alive,"#Alive","Deksripsi dari film Alive");
        dataholder.add(ob3);

        datamodel ob4=new datamodel(R.drawable.aquaman,"Aquaman","Deskripsi dari film Aquaman");
        dataholder.add(ob4);

        datamodel ob5=new datamodel(R.drawable.chemicalhearts,"Chemical hearts","Deksripsi dari film Chemical Hearts");
        dataholder.add(ob5);

        datamodel ob6=new datamodel(R.drawable.escaperoom,"Escape Room","Deskripsi dari film Escape Room");
        dataholder.add(ob6);

        datamodel ob7=new datamodel(R.drawable.faultinourstars,"The Fault in Our Stars","Deksripsi dari film The Fault in our stars");
        dataholder.add(ob7);

        datamodel ob8=new datamodel(R.drawable.justiceleague,"Justice League","Deskripsi dari film Justice League");
        dataholder.add(ob8);

        datamodel ob9=new datamodel(R.drawable.marypoppins,"Mary Poppiins","Deksripsi dari film Mary Poppins");
        dataholder.add(ob9);

        datamodel ob10=new datamodel(R.drawable.moneyheist,"Money Heist","Deskripsi dari film Money Heist");
        dataholder.add(ob10);

        datamodel ob11=new datamodel(R.drawable.noah,"Noah","Deksripsi dari film Noah");
        dataholder.add(ob11);

        datamodel ob12=new datamodel(R.drawable.themeg,"The meg","Deskripsi dari film The Meg");
        dataholder.add(ob12);

        recyclerView.setAdapter(new myadapter(dataholder));
        return view;
    }
}