package next.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        log.info("리퀘스트 URI {} /GET", req.getRequestURI());
        test(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        log.info("리퀘스트 URI {} /POST", req.getRequestURI());
        test(req, resp);
    }

    @SneakyThrows
    private void test(HttpServletRequest req, HttpServletResponse resp) {
        Controller huhu = RequestMapping.getMatchedController(req.getRequestURI());
        log.info("감증... {} ", huhu);
        String hoho = RequestMapping.getMatchedController(req.getRequestURI()).service(req, resp);
        log.info("제발요 엄마 {}",hoho);
        if(hoho.contains(".jsp")) {
            RequestDispatcher rd = req.getRequestDispatcher(hoho);
            rd.forward(req, resp);
            return;
        }
        resp.sendRedirect(hoho);
    }
}
