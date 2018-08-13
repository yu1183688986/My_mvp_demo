package mvp.com.my_mvp.view;
/**
 * @date on 11:34 2018/8/13
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe presenter与view交互是通过接口，view的接口包括获取用户名和密码，登录的反馈，以及控件交互。
 */
public interface ILoginView {
    String getUserName();
    String getPassword();
    //反馈
    //登录成功跳转
    void toMainActivity();
    void showFail();
    //控件友好交互progressBar
    void showLoading();
    void hideLoading();
    //清除内容
    void clearUserName();
    void clearPassword();
}
