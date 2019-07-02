package next.controller;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

    private String doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
        return "/";
    }

    @Override
    @SneakyThrows
    public String service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        return doGet(httpRequest, httpResponse);
    }
}
