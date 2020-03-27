package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {
    private  TextView mLifecycleDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises2);
        mLifecycleDisplay = findViewById(R.id.tv_center);
        View view =(View) findViewById(R.id.mmmm);//获取最外层view
        mLifecycleDisplay.setText(String.valueOf(getAllChildViewCount(view)));//递归求view数

    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        if (!(view instanceof ViewGroup))//若是view，则计数为1
            return 1;

        ViewGroup viewgroup = (ViewGroup) view;
        int count = 0;

        for(int i=0; i<viewgroup.getChildCount(); i++)//若是viewgroup，则进入循环进行递归计数
            count += getAllChildViewCount(viewgroup.getChildAt(i));

        return count;
    }

}
