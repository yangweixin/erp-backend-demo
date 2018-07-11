package top.oyoung.erp.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 下午3:28
 */
@Component
public class JwtUtil {

    private final String secretKey = "iamahandsomeboy";

    /**
     * @Author: Yang Weixin
     * @Description: 生成token
     * @DateTime: 2018/7/11 下午3:35
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + 2592000L * 1000);//30days
        return Jwts.builder()
            .setClaims(claims)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
    }

    /**
     * @Author: Yang Weixin
     * @Description: 解析token，获取claims
     * @DateTime: 2018/7/11 下午3:50
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * @Author: Yang Weixin
     * @Description: 通过userDetails创建token
     * @DateTime: 2018/7/11 下午3:51
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * @Author: Yang Weixin
     * @Description: 获取token中的用户名
     * @DateTime: 2018/7/11 下午3:52
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * @Author: Yang Weixin
     * @Description: 验证令牌是否过期
     * @DateTime: 2018/7/11 下午3:52
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Author: Yang Weixin
     * @Description: 刷新令牌
     * @DateTime: 2018/7/11 下午3:53
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

}
