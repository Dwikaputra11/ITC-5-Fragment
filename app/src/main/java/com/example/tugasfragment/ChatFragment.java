package com.example.tugasfragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    private Button btnAddContact;
    private TextView tvInput;

    ChatDialog.InputListener inputListener = new ChatDialog.InputListener() {
        @Override
        public void sendInput(String input) {
            tvInput.setText(input);
        }
    };
    private static final String TAG = "ChatFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        btnAddContact = view.findViewById(R.id.btn_addContact);
        tvInput = view.findViewById(R.id.tv_input);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatDialog chatDialog = new ChatDialog();
                chatDialog.show(getChildFragmentManager(), "ChatDialog");
            }
        });

        return view;

    }
}