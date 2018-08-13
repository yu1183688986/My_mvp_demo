package mvp.com.my_mvp.model.biz;

import mvp.com.my_mvp.model.bean.User;

/**
 * @date on 11:19 2018/8/13
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 业务逻辑接口  login()方法
 */
public interface IUser {
    void login(String userName,String password,OnLoginListener listener);
    //回调接口，来通知登录的状态
    public interface OnLoginListener{
        void  loginSuccess(User user);
        void loginFailed();
    }
}
