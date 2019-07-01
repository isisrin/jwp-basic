package next.controller;

import core.db.DataBase;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/users")
public class ListUserController implements Controller { //extends HttpServlet
    private static final long serialVersionUID = 1L;

    private String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!UserSessionUtils.isLogined(req.getSession())) {
            return "users/loginForm";
        }

        req.setAttribute("users", DataBase.findAll());

        return "user/list.jsp";
    }

    @Override
    @SneakyThrows
    public String service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        return this.doGet(httpRequest, httpResponse);
    }
}
