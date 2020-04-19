import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Random;

public class GetJsonData {
    static String url = "https://www.yuque.com/api/v2/users/ekko/repos";

    public static String getJsonData(JSONObject jsonParam, String urls) {
        String[] user_agent = {

                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1",
                "Mozilla/5.0 (X11; CrOS i686 2268.111.0) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.57 Safari/536.11",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6",
                "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1090.0 Safari/536.6",
                "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/19.77.34.5 Safari/537.1",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.9 Safari/536.5",
                "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.36 Safari/536.5",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3",
                "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_0) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3",
                "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1062.0 Safari/536.3",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1062.0 Safari/536.3",
                "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
                "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
                "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.0 Safari/536.3",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24",
                "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24",
                "Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11",
                "Opera/9.80 (Android 2.3.4; Linux; Opera mobi/adr-1107051709; U; zh-cn) Presto/2.8.149 Version/11.10"};
        int max = 19;
        int min = 0;
        int index = new Random().nextInt(max - min);
//        StringBuffer sb = new StringBuffer();
        return HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, "application/json")
                .header(Header.USER_AGENT, user_agent[index])
                .header("X-Auth-Token", "ymmfSLt9BqruLJJM6NzGqIp1M9xg71zK1xlvYXgs")
                .body(JSON.toJSONString(jsonParam))
                .execute()
                .body();


//            // 创建url资源
//            URL url = new URL(urls);
//            // 建立http连接
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            // 设置允许输出
//            conn.setDoOutput(true);
//            // 设置允许输入
//            conn.setDoInput(true);
//            // 设置不用缓存
//            conn.setUseCaches(false);
//            // 设置传递方式
//            conn.setRequestMethod("POST");
//            // 设置维持长连接
////            conn.setRequestProperty("Connection", "Keep-Alive");
//            // 设置文件字符集:
//            conn.setRequestProperty("Charset", "UTF-8");
//            // 转换为字节数组
//            byte[] data = (jsonParam.toString()).getBytes();
//            // 设置文件长度
////            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
//            // 设置文件类型:
//            conn.setRequestProperty(
//            conn.setRequestProperty("Accept", "*/*");
//            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//            conn.setRequestProperty(;
//
//            conn.setRequestProperty(
//            // 开始连接请求
//            conn.connect();
//            OutputStream out = new DataOutputStream(conn.getOutputStream());
//            // 写入请求的字符串
//            out.write((jsonParam.toString()).getBytes());
//            out.flush();
//            out.close();
//            System.out.println(conn.getResponseCode());
//
//            // 请求返回的状态
//            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
//                System.out.println("连接成功");
//                // 请求返回的数据
//                InputStream in1 = conn.getInputStream();
//                try {
//                    String readLine;
//                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(in1, StandardCharsets.UTF_8));
//                    while ((readLine = responseReader.readLine()) != null) {
//                        sb.append(readLine).append("\n");
//                    }
//                    responseReader.close();
//                    System.out.println(sb.toString());
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            } else {
//                System.out.println("error++");
//
//            }
//        } catch (Exception e) {
//        }

    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 100; i < 5000; i++) {
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("name", "ekko" + RandomUtil.randomNumbers(3) + i);
            jsonParam.put("slug", "ekko" + i);
            jsonParam.put("description", "明天我就没有会员了,所以我要多建点知识库");
            jsonParam.put("public", 1);
            jsonParam.put("type", "Book");
            String data = GetJsonData.getJsonData(jsonParam, url);
            System.out.println(String.format("第%d个仓库添加！", i));
            System.out.println("返回：{}" + JSON.toJSONString(data, SerializerFeature.WriteMapNullValue));
            Thread.sleep(RandomUtil.randomInt(3000));
        }
    }
}