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
        requestProcessor(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        log.info("리퀘스트 URI {} /POST", req.getRequestURI());
        requestProcessor(req, resp);
    }

    @SneakyThrows
    private void requestProcessor(HttpServletRequest req, HttpServletResponse resp) {
        String requestURI = req.getRequestURI();
        Controller matchedController = RequestMapping.getMatchedController(requestURI);
        if(matchedController == null) {
            resp.sendRedirect(requestURI);
            return;
        }
        String redirectUrl = RequestMapping.getMatchedController(requestURI).service(req, resp);
        if(redirectUrl.contains(".jsp")) {
            RequestDispatcher rd = req.getRequestDispatcher(redirectUrl);
            rd.forward(req, resp);
            return;
        }
        resp.sendRedirect(redirectUrl);
    }
}
