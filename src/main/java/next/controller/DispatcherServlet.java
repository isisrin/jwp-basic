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
    private static final long serialVersionUID = 1L;

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
        String requestURI = req.getRequestURI();
        Controller huhu = RequestMapping.getMatchedController(requestURI);
        if(huhu == null) {
            resp.sendRedirect(requestURI);
            return;
        }
        String hoho = RequestMapping.getMatchedController(requestURI).service(req, resp);
        if(hoho.contains(".jsp")) {
            RequestDispatcher rd = req.getRequestDispatcher(hoho);
            rd.forward(req, resp);
            return;
        }
        resp.sendRedirect(hoho);
    }
}
