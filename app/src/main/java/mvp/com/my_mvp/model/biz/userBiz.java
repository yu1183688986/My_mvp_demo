package mvp.com.my_mvp.model.biz;

import mvp.com.my_mvp.model.bean.User;

/**
 * @date on 11:25 2018/8/13
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 至于业务类，我们抽取了一个接口，
 * 一个实现类这也很常见~~login方法，一般肯定是连接服务器的，是个耗时操作，
 * 所以我们开辟了子线程，Thread.sleep(2000)模拟了耗时，由于是耗时操作，
 * 所以我们通过一个回调接口来通知登录的状态。
 */
public class userBiz implements IUser {
    @Override
    public void login(String userName, String password, OnLoginListener listener) {
        new Thread(()->{
            //模拟登录延时
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟登录成功
            if ("yuyong".equals(userName) && "123".equals(password)){
                User user = new User();
                user.setName(userName);
                user.setPassword(password);
                listener.loginSuccess(user);
            }else {
                listener.loginFailed();
            }
        }).start();
    }
}
