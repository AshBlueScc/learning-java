package java_jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author chengzhen
 * @date 2020/4/20
 * @time 上午10:04
 */
public class JavaJWTDemo {
    public static void main(String[] args) {
        //签发token
        long now2=System.currentTimeMillis();
        long exp2=now2+1000*30;//30秒过期

        String token = JWT.create()
                .withJWTId("888")
                .withSubject("小白")
                .withIssuer("小白")
//                .withIssuedAt(new Date())
//                .withExpiresAt(new Date(exp2))
                .withClaim("roles", "admin")
                .sign(Algorithm.HMAC256("hahaha"));
        System.out.println(token);


        //解密token,此处无法拿到整个解密的payload的json串，只能拿取单个的值，区别于jjwt,并且和jjwt的解密无法互通使用
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(
                "Id:" + jwt.getId()+
                "subject:" + jwt.getSubject()+
                "issuer:" + jwt.getIssuer()+
                "roles:" + jwt.getClaim("roles")+
                "signature:" + jwt.getSignature());


        //验证
//        String id = JWT.decode(token).getId();
//        Assertions.assertEquals("888", id);
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("hahaha")).build();
        jwtVerifier.verify(token);


        try {
            Algorithm algorithm = Algorithm.HMAC256("hahaha");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("小白")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt1 = verifier.verify(token);
            System.out.println(jwt1.getPayload());
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
        }
    }
}
