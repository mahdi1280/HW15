package ir.maktab;

import ir.maktab.model.Current;
import ir.maktab.model.ShortTerm;
import ir.maktab.model.User;
import ir.maktab.service.current.CurrentService;
import ir.maktab.service.current.CurrentServiceImpl;
import ir.maktab.service.shoertterm.ShortTermService;
import ir.maktab.service.shoertterm.ShortTermServiceImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceIml;
import ir.maktab.session.MySession;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        MySession.getSession();
        UserService userService=new UserServiceIml();
        ShortTermService shortTermService=new ShortTermServiceImpl();
        CurrentService currentService=new CurrentServiceImpl();
        User userAli = userService.save(new User("ali", "hasani"));
        User userMohammad = userService.save(new User("mohammad", "mohammadi"));
        currentService.save(new Current(LocalDateTime.now(),100000000,userMohammad,false));
        shortTermService.save(new ShortTerm(LocalDateTime.now(),100000000,userAli,0));
    }
}
