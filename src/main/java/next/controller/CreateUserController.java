package next.controller;

import core.db.DataBase;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CreateUserController implements Controller {

    private String doGet(HttpServletRequest req, HttpServletResponse resp) {
        return "/user/form.jsp";
    }

    private String doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
                req.getParameter("email"));
        log.debug("User : {}", user);

        DataBase.addUser(user);

        return "/";
    }

    @Override
    @SneakyThrows
    public String service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        if(httpRequest.getMethod().equals("GET")) {
            return doGet(httpRequest, httpResponse);
        }
        return doPost(httpRequest, httpResponse);
    }
}
