package aplicactions.ticas.appticas.utils;

public class Response {
    private Object body;
    private String message;

    public Response(Object body, String message) {
        this.body = body;
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
