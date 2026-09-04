package com.back.p67260811.domain.member.service;

import com.back.p67260811.domain.member.entity.Member;
import com.back.p67260811.standard.Ut;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthTokenService {

    private String secretPattern= "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890";
    private long expireMills = 1000L * 60 * 10;

    public String genAccessToken(Member member) {

        return Ut.jwt.toString(
                secretPattern,
                expireMills,
                Map.of("id", member.getId(), "username", member.getUsername())
        );
    }

}