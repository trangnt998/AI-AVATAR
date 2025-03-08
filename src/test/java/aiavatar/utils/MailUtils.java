package aiavatar.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailUtils {
    private static final String DROPMAIL_API_URL = "https://dropmail.me/api/graphql/MY_TOKEN";
    private static String email = null;
    private static String sessionId = null;

    // Lấy email tạm thời từ DropMail
    public static String getTemporaryEmail() {
        String query = "mutation { introduceSession { id addresses { address } } }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"query\":\"" + query + "\"}")
                .post(DROPMAIL_API_URL);

        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.getBody().asString());
            sessionId = jsonResponse.getJSONObject("data").getJSONObject("introduceSession").getString("id");
            email = jsonResponse.getJSONObject("data").getJSONObject("introduceSession")
                    .getJSONArray("addresses").getJSONObject(0).getString("address");

            System.out.println("Email tempo: " + email);
            System.out.println("Session ID: " + sessionId);
            return email;
        } else {
            System.out.println("Can't create mail, code: " + response.statusCode());
            return null;
        }
    }

    // Lấy nội dung email từ DropMail
    public static String getEmails() {
        if (sessionId == null) {
            System.out.println("Not have sessionId");
            return null;
        }

        String query = "query ($id: ID!) { session(id: $id) { mails { text } } }";
        String requestBody = "{\"query\":\"" + query + "\",\"variables\":{\"id\":\"" + sessionId + "\"}}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(DROPMAIL_API_URL);

        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.getBody().asString());
            JSONArray mails = jsonResponse.getJSONObject("data").getJSONObject("session").getJSONArray("mails");

            if (mails.length() > 0) {
                String emailText = mails.getJSONObject(0).getString("text");
//                System.out.println("Content email: " + emailText);
                return emailText;
            } else {
                System.out.println("Not have mail.");
                return null;
            }
        } else {
            System.out.println("Error when get mail: " + response.statusCode());
            return null;
        }
    }

    // Trích xuất OTP từ nội dung email
    public static String extractOTP(String emailText) {
        if (emailText == null) return null;

        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(emailText);

        if (matcher.find()) {
            String otp = matcher.group();
            System.out.println("OTP: " + otp);
            return otp;
        } else {
            System.out.println("OTP not found");
            return null;
        }
    }

    public static void main(String[] args)  {
        // Lấy email tạm thời
        String tempEmail = getTemporaryEmail();
        if (tempEmail == null) return;


        String emailContent = getEmails();
        if (emailContent == null) return;

        // Trích xuất OTP từ email
        String otp = extractOTP(emailContent);

        System.out.println("===============================");
        System.out.println("Email tạm thời: " + tempEmail);
        System.out.println("OTP: " + otp);
        System.out.println("===============================");
    }
}
