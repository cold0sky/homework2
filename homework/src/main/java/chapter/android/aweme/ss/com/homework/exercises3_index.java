package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class exercises3_index extends AppCompatActivity {

    private TextView mLifecycleDisplay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        Intent intent = getIntent();
        int clickedItemIndex = intent.getIntExtra("ItemIndex",0);

        mLifecycleDisplay = findViewById(R.id.tv_content_info);
        mLifecycleDisplay.setText("这是第"+String.valueOf(clickedItemIndex+1)+"个Item");//显示item的序号
    }
}
