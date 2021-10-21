package com.example.testeassinatura;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.github.gcacace.signaturepad.views.SignaturePad;

public class MainActivity extends Activity {

    private SignaturePad mSignaturePad;
    private Button mClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
            }

            @Override
            public void onSigned() {
                mClearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                mClearButton.setEnabled(false);
            }
        });

        mClearButton = (Button) findViewById(R.id.clear_button);

        mClearButton.setOnClickListener(view -> mSignaturePad.clear());
    }
}