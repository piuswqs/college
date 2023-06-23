package com.example.smartlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smartlab.ui.home.AnalyzFragment;
import com.example.smartlab.ui.notifications.SupportFragment;
import com.example.smartlab.ui.profile.ProfileFragment;
import com.example.smartlab.ui.result.ResultFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements AnalysisAdapter.OnItemClickLisneter{

    BottomNavigationView menuView;
    TextView myButton;

    PreferencesManager preferencesManager;
    DbHelperK dbHelperK;

    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.white));

        preferencesManager=new PreferencesManager(this);
        dbHelperK=new DbHelperK(this);

        menuView = findViewById(R.id.bot_menu);
        menuView.setOnNavigationItemSelectedListener(navListener);

        replaceFragment(new AnalyzFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_analyz:
                    replaceFragment(new AnalyzFragment());
                    break;
                case R.id.navigation_result:
                    replaceFragment(new ResultFragment());
                    break;
                case R.id.navigation_support:
                    replaceFragment(new SupportFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return false;
        }
    };

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameL, fragment);
        fragmentTransaction.commit();
    }

    Boolean buttonIsCreated=false;

    @Override
    public void onItemClick(int position, int cost, String text, String name) {
        if(!buttonIsCreated){
            myButton= new TextView(this);
            LinearLayout layout=findViewById(R.id.layout_k);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            myButton.setLayoutParams(params);
            myButton.setHeight(150);
            myButton.setBackground(getDrawable(R.drawable.button_blue_roundedcorn));
            myButton.setTextColor(getResources().getColor(R.color.white));
            myButton.setTextSize(18);
            myButton.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.basket_icon), null, null, null);
            myButton.setCompoundDrawablePadding(10);
            myButton.setAllCaps(false);
            myButton.setGravity(Gravity.CENTER_VERTICAL);
            layout.addView(myButton);
            //price=preferencesManager.getSum();
            buttonIsCreated=true;
        }

        int sum = 0;
        if (text=="Убрать"){
            sum = dbHelperK.Sum();

        }
        else{
            sum = dbHelperK.Sum();
            //dbHelperK.deleteRow(name);
        }
        price = dbHelperK.Sum();

        myButton.setText("В корзину\t\t\t"+price + " ₽");
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferencesManager.setSum(price);
                Intent intent=new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(intent);
            }
        });
    }
}
