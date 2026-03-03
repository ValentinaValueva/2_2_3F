package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDao;
import web.model.User;
//import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

//    private final UserService userService;
//
//
//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }

    private final UserDao userDao;

    @Autowired
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String index(ModelMap model) {
        model.addAttribute("users", userDao.index());
        return "users/index";

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }

//    @GetMapping (value = "/")
//    public String users(ModelMap model) {
//    List<User> userList = userService.listUsers();
//    model.addAttribute("users", userList);
//
//        return "userList";
//    }userList
}


