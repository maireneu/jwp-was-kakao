package controller;

import service.UserService;
import webserver.http.HttpRequest;
import webserver.http.HttpResponse;
import webserver.http.HttpResponseBuilder;

public class UserCreateController extends Controller {
    private static final String PATH = "/user/create";

    @Override
    public String getPath() {
        return PATH;
    }

    @Override
    protected HttpResponse handleGet(HttpRequest httpRequest) {
        addNewUser(httpRequest);
        return HttpResponse._200_OK;
    }

    @Override
    protected HttpResponse handlePost(HttpRequest httpRequest) {
        addNewUser(httpRequest);
        return new HttpResponseBuilder()
                .with302Redirect("/index.html")
                .build();
    }

    private void addNewUser(HttpRequest request) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        UserService.addNewUser(userId, password, name, email);
    }
}
