package aplicactions.ticas.appticas.utils;

public class Response {
    private Integer responseCode;
    private String message;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response(Integer responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
}
