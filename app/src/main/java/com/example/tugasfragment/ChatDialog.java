package com.example.tugasfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ChatDialog extends DialogFragment {

    private EditText etName, etNumber;
    private Button btnAdd;

    public String nameInput,numberInput,combine;

    public interface InputListener{
        void sendInput(String input);
    }

    public InputListener onInputLisntener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_dialog, container, false);
        etName = view.findViewById(R.id.et_name);
        etNumber = view.findViewById(R.id.et_number);
        btnAdd = view.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput = etName.getText().toString();
                numberInput = etNumber.getText().toString();
                combine = nameInput + " " + numberInput;
                Log.d("combine", combine);
//                if(!nameInput.equals("") || !numberInput.equals("")){
//                    ChatFragment chatFragment = new ChatFragment();
//                    chatFragment.getActivity();
//                }
                onInputLisntener.sendInput(combine);

                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            ChatFragment chatFragment = (ChatFragment) getParentFragment();
            onInputLisntener = chatFragment.inputListener;
        }catch (ClassCastException e){
            Log.e("error","ClassCastException " + e.getMessage());
        }
    }
}