package com.example.helloworld;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmenttiga#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmenttiga extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText noMhs;
    private EditText namaMhs;
    private EditText phoneMhs;
    private Button buttonSimpan;
    private Button buttonhps;
    private Button buttonupdate;





    private FirebaseFirestore firebaseFirestoreDb;





    public Fragmenttiga() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmenttiga newInstance(String param1, String param2) {
        Fragmenttiga fragment = new Fragmenttiga();
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



        View view = inflater.inflate(R.layout.fragment_fragmenttiga, container, false);
        noMhs = view.findViewById(R.id.noMhs);
        namaMhs = view.findViewById(R.id.namaMhs);
        phoneMhs = view.findViewById(R.id.phoneMhs);
        buttonSimpan = view.findViewById(R.id.simpanButton);
        buttonhps = view.findViewById(R.id.hapusButton);
        buttonupdate = view.findViewById(R.id.gantiButton);
        firebaseFirestoreDb = FirebaseFirestore.getInstance();



        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sanity check
                if (!noMhs.getText().toString().isEmpty() && !namaMhs.getText().toString().isEmpty()) {
                    tambahMahasiswa();
                } else {
                    //jika kosong
                    Toast.makeText(requireActivity(), "Field harus diisi semua!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonhps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteDataMahasiswa();
            }
        });


        buttonupdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDataMahasiswa();
            }
        });



        return view;




    }

    //utk nyimpen



    private void getDataMahasiswa() {
        DocumentReference docRef = firebaseFirestoreDb.collection("DaftarMhs").document("mhs1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        DataMahasiswa mhs = document.toObject(DataMahasiswa.class);
                        noMhs.setText(mhs.getNim());
                        namaMhs.setText(mhs.getNama());
                        phoneMhs.setText(mhs.getPhone());
                    } else {
                        Toast.makeText(requireActivity(), "Document tidak ditemukan",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireActivity(), "Document error : " + task.getException(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





    private void tambahMahasiswa() {

        DataMahasiswa mhs = new DataMahasiswa(noMhs.getText().toString(),
                namaMhs.getText().toString(),
                phoneMhs.getText().toString());

        firebaseFirestoreDb.collection("DaftarMhs").document(namaMhs.getText().toString()).set(mhs)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(requireActivity(), "Data telah diinputkan ",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireActivity(), "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }




    private void deleteDataMahasiswa() {
        firebaseFirestoreDb.collection("DaftarMhs").document(namaMhs.getText().toString())
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        noMhs.setText("");
                        namaMhs.setText("");
                        phoneMhs.setText("");
                        Toast.makeText(requireActivity(), "Mahasiswa berhasil dihapus",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireActivity(), "Error deleting document: " + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateDataMahasiswa(){
//        firebaseFirestoreDb.collection("DaftarMhs").document(namaMhs.getText().toString())
//                .update("nama",namaMhs.getNama(),"nim",noMhs.getNim(),"phone",phoneMhs.getPhone())
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        noMhs.setText("");
//                        namaMhs.setText("");
//                        phoneMhs.setText("");
//                        Toast.makeText(requireActivity(), "Mahasiswa berhasil diupdate",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(requireActivity(), "Error updating document: " + e.getMessage(),
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
    }







}