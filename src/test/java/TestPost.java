//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.params.CoreProtocolPNames;
//import org.apache.http.util.EntityUtils;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class TestPost {
//
//
//
//    public static void main(String args[]) {
//        try {
//            JSONObject  obj = new JSONObject();
//            obj.append("app_name", "全民大讨论");
//            obj.append("app_ip", "10.21.243.234");
//            obj.append("app_port", 8080);
//            obj.append("app_type", "001");
//            obj.append("app_area", "asd");
//
//            CloseableHttpClient httpclient = HttpClients.createDefault();
//            System.out.println(obj);
//
//            HttpPost httpPost = new HttpPost("http://119.29.85.118//test.php");
//            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
//
//            // 解决中文乱码问题
//            StringEntity stringEntity = new StringEntity(obj.toString(), "UTF-8");
//            stringEntity.setContentEncoding("UTF-8");
//
//            httpPost.setEntity(stringEntity);
//
//            // CloseableHttpResponse response =
//            // httpclient.execute(httpPost);
//
//            System.out.println("Executing request " + httpPost.getRequestLine());
//
//            // Create a custom response handler
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//                @Override
//                public String handleResponse(final HttpResponse response)
//                        throws ClientProtocolException, IOException {//
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//
//                        HttpEntity entity = response.getEntity();
//
//                        return entity != null ? EntityUtils.toString(entity) : null;
//                    } else {
//                        throw new ClientProtocolException(
//                                "Unexpected response status: " + status);
//                    }
//                }
//            };
//            String responseBody = httpclient.execute(httpPost, responseHandler);
//            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
//
