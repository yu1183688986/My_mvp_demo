package mvp.com.my_mvp.presenter;

import android.os.Handler;

import mvp.com.my_mvp.model.bean.User;
import mvp.com.my_mvp.model.biz.IUser;
import mvp.com.my_mvp.model.biz.userBiz;
import mvp.com.my_mvp.view.ILoginView;

/**
 * @date on 14:34 2018/8/13
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe Presenter是用作Model和View之间交互的桥梁 有两个方法login和clear
 */
public class UserPresenter {
    private IUser iUser;
    private ILoginView iLoginView;
    private Handler mHandler = new Handler();

    public UserPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.iUser = new userBiz();
    }

    public void login(){
        iLoginView.showLoading();
        iUser.login(iLoginView.getUserName(), iLoginView.getPassword(), new IUser.OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                //需要在UI线程执行
                mHandler.post(()->{
                    iLoginView.toMainActivity();
                    iLoginView.hideLoading();
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(()->{
                    iLoginView.hideLoading();
                    iLoginView.showFail();
                });
            }
        });
    }

    public void clear(){
        iLoginView.clearUserName();
        iLoginView.clearPassword();
    }
}
