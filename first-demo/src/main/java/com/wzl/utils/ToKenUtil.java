package com.wzl.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class ToKenUtil {
    private final static String ENCRYPT_KEY = "abc123";
    private final static int EXPIRE_TIME =60;//过期时间
    private final static String ISSUER = "cc";

    //静态方法产生token
    //要封装到token中的内容----如果需要传递多个值--可以定义为Map或者JSON
    //return 返回token
    public static String createToken(JSONObject jsonObject){
        return JWT.create()
                .withSubject(jsonObject.toString())
                .withIssuer(ISSUER)
                .withExpiresAt(DateUtil.offsetMinute(new Date(),EXPIRE_TIME))
                .withClaim("test","123")
                .sign(Algorithm.HMAC256(ENCRYPT_KEY));
    }

    //校验token是否通过
    public static boolean verifyToKen(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ENCRYPT_KEY)).withIssuer(ISSUER).build();
            jwtVerifier.verify(token);
            return true;
        }catch (Exception e){//如果token过期会报错 ToKenExpiredException
            e.printStackTrace();
            return false;
        }
    }
    // 销毁 Token 的方法
    private static Set<String> destroyedTokens = new HashSet<>();
    public static boolean destroyToken(String token) {
        return destroyedTokens.add(token);
    }
    // 校验 Token 是否已被销毁
    public static boolean isTokenDestroyed(String token) {
        return destroyedTokens.contains(token);
    }
}
