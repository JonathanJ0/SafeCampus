package com.example.safecampusapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText location, time, details;
    private Spinner harassmentType;
    private Button submitButton, trackButton, sendButton;
    private TextView statusOutput;
    private String reportId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = findViewById(R.id.location);
        time = findViewById(R.id.time);
        details = findViewById(R.id.details);
        harassmentType = findViewById(R.id.type);
        submitButton = findViewById(R.id.submit_button);
        trackButton = findViewById(R.id.track_button);
        sendButton = findViewById(R.id.send_button);
        statusOutput = findViewById(R.id.status_output);

        submitButton.setOnClickListener(v -> submitReport());
        trackButton.setOnClickListener(v -> trackReport());
        sendButton.setOnClickListener(v -> sendMessage());
    }

    private void submitReport() {
        String type = harassmentType.getSelectedItem().toString();
        String loc = location.getText().toString();
        String t = time.getText().toString();
        String detail = details.getText().toString();

        // Create JSON for report
        try {
            JSONObject report = new JSONObject();
            report.put("type", type);
            report.put("location", loc);
            report.put("time", t);
            report.put("details", detail);

            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://your-backend-url.com/submit-report"; // Replace with actual URL

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, report, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        reportId = response.getString("reportId");
                        Toast.makeText(MainActivity.this, "Report submitted. ID: " + reportId, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "Request Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

            queue.add(jsonObjectRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void trackReport() {
        String reportIdInput = statusOutput.getText().toString();
        // Implement API call to track report status
    }

    private void sendMessage() {
        // Implement sending message logic
    }
}
