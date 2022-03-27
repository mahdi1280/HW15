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
        UserService userService = new UserServiceIml();
        ShortTermService shortTermService = new ShortTermServiceImpl();
        CurrentService currentService = new CurrentServiceImpl();
        User userAli = userService.save(User.builder()
                .setFirstname("ali")
                .setLastname("hassani")
                .build());
        User userMohammad = userService.save(User.builder()
                .setFirstname("mohammad")
                .setLastname("mohammadi")
                .build());

        currentService.save( Current.builder()
                .setAmount(1231231231)
                .setUser(userMohammad)
                .setCzech(false)
                .build());
        shortTermService.save(  ShortTerm.builder()
                .setAmount(123123)
                .setUser(userAli)
                .setInterest(1)
                .build());
    }
}
