package ntu.hesl.filepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView fileTextView;
    Button pickButton;
    private File selectedFile;;
    private static final int REQUEST_PICK_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileTextView = (TextView)findViewById(R.id.filenameTextView);
        pickButton = (Button)findViewById(R.id.pickButton);
        pickButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.pickButton:
                Intent intent = new Intent(this, FilePicker.class);
                startActivityForResult(intent, REQUEST_PICK_FILE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK) {

            switch(requestCode) {

                case REQUEST_PICK_FILE:

                    if(data.hasExtra(FilePicker.EXTRA_FILE_PATH)) {

                        selectedFile = new File
                                (data.getStringExtra(FilePicker.EXTRA_FILE_PATH));
                        fileTextView.setText(selectedFile.getPath());
                    }
                    break;
            }
        }
    }

}
