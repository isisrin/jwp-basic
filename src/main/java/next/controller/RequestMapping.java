package next.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {

    private static final Map<String, Controller> requestMapper = new HashMap<>();

    static  {
        requestMapper.put("/users/create", new CreateUserController());
        requestMapper.put("/users/form", new CreateUserController());
        requestMapper.put("/users", new ListUserController());
        requestMapper.put("/users/login", new LoginController());
        requestMapper.put("/users/loginForm", new LoginController());
        requestMapper.put("/users/logout", new LogoutController());
        requestMapper.put("/users/profile", new ProfileController());
        requestMapper.put("/users/update", new UpdateUserController());
        requestMapper.put("/users/updateForm", new UpdateUserController());
    }

    public static Controller getMatchedController(String url) {
        return requestMapper.get(url);
    }
}
