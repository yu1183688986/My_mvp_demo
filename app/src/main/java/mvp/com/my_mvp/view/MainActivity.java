package mvp.com.my_mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import mvp.com.my_mvp.R;
import mvp.com.my_mvp.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{

    private ProgressBar progressBar;
    private UserPresenter presenter;
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    //initialize
    private void initialize(){
        presenter = new UserPresenter(this);
        progressBar = findViewById(R.id.loading);
        progressBar.setVisibility(View.INVISIBLE);
        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        Button clear = findViewById(R.id.clean);
        login.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(this,"用户"+getUserName()+"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFail() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void clearUserName() {
        userName.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                presenter.login();
                break;
            case R.id.clean:
                presenter.clear();
                break;
            default:
                break;
        }
    }
}
