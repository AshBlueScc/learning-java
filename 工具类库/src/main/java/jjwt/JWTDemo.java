package jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author chengzhen
 * @date 2020/4/17
 * @time 下午4:57
 */
public class JWTDemo {
    public static void main(String[] args) {
        JwtBuilder builder= Jwts.builder()
                .setId("888")   //设置唯一编号
                .setSubject("小白")//设置主题  可以是JSON数据
                .setIssuedAt(new Date())//设置签发日期
                .signWith(SignatureAlgorithm.HS256,"hahaha");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        //构建 并返回一个字符串
        String compactJwt = builder.compact();
        System.out.println(compactJwt);

        Claims claims = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(compactJwt).getBody();
        System.out.println(claims);

        System.out.println("============");

        //设置过期时间
        long now=System.currentTimeMillis();
        long exp=now+1000*30;//30秒过期
        JwtBuilder jwtBuilder = Jwts.builder().setId( "888" )
                .setSubject( "小白" )
                .setIssuedAt( new Date() )//签发时间
                .setExpiration( new Date( exp ) )//过期时间
                .signWith( SignatureAlgorithm.HS256, "hahaha" );
        String token = jwtBuilder.compact();
        System.out.println(token);

        Claims claims1 = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(token).getBody();
        System.out.println(claims1);

        System.out.println("============");

        //我们刚才的例子只是存储了id和subject两个信息，如果你想存储更多的信息（例如角色）可以定义自定义claims。
        long now2=System.currentTimeMillis();
        long exp2=now2+1000*30;//30秒过期
        JwtBuilder jwtBuilder2 = Jwts.builder().setId( "888" )
                .setSubject( "小白" )
//                .setIssuedAt( new Date() )//签发时间
//                .setExpiration( new Date( exp2) )//过期时间
                .claim( "roles","admin" )
                .signWith( SignatureAlgorithm.HS256, "hahaha" );
        String token2 = jwtBuilder2.compact();
        System.out.println(token2);

        Claims claims2 = Jwts.parser().setSigningKey( "hahaha" ).parseClaimsJws( token2 ).getBody();
        System.out.println(claims2);
        System.out.println(claims2.get( "roles" ));
    }
}
