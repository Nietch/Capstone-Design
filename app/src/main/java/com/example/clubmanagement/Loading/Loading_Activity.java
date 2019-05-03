package com.example.clubmanagement.Loading;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clubmanagement.Fragment.FragmentStart;
import com.example.clubmanagement.R;
import com.example.clubmanagement.login.LoginActivity;

import static java.lang.Thread.sleep;

public class Loading_Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loading);
        try{
            sleep(1000);
        }
        catch (Exception e){System.out.print(e);}

        Intent intent = new Intent(Loading_Activity.this, LoginActivity.class);
        startActivity(intent);
    }
}