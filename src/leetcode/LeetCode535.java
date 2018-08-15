package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，
 * 你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 * @Date: Created in 上午11:22 2018/8/12
 * @Modified By:
 */
public class LeetCode535 {

    Map<String,String> longToShort=new HashMap<>();
    Map<String,String> shortToLong=new HashMap<>();

    private String dict="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)){
            return longToShort.get(longUrl);
        }else {
            String url=encodeUrl(longUrl);
            while (longToShort.containsKey(url)){
                url=encodeUrl(longUrl);
            }
            longToShort.put(longUrl,url);
            shortToLong.put(url,longUrl);
            return url;
        }
    }

    private String encodeUrl(String url){
        String res="";
        for (int i=0;i<6;i++){
            String s=String.valueOf(dict.charAt((int)Math.random()*(dict.length()-1)));
            res+=s;
        }
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.containsKey(shortUrl)?shortToLong.get(shortUrl):"";
    }

    public static void main(String[] args) {
        System.out.println("//".split("/").length);
    }
}
