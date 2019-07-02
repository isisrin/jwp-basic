package next.controller;

import core.db.DataBase;
import lombok.SneakyThrows;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

    private String doGet(HttpServletRequest req, HttpServletResponse resp) {
        return "/user/login.jsp";
    }

    private String doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = DataBase.findUserById(userId);
        if (user == null) {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }

        if (user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
            return "/";
        } else {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }
    }

    @Override
    @SneakyThrows
    public String service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        if (httpRequest.getMethod().equals("GET")) {
            return doGet(httpRequest, httpResponse);
        }
        return doPost(httpRequest, httpResponse);
    }
}
