package com.example.hades.generateso;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI() + ",sum=" + sum(5, 6));

        TextView tv2 = findViewById(R.id.sample_text2);
        tv2.setText(NativeLibUtil.stringFromJNI() + ",sum=" + NativeLibUtil.sum(1000, 789));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int sum(int a, int b);

//    openssl pkcs7 -inform DER -in CERT.RSA.RSA -noout -print_certs -text

}