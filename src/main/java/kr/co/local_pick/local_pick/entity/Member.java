package kr.co.local_pick.local_pick.entity;

import jakarta.persistence.*;
import kr.co.local_pick.local_pick.enums.Region;

import java.time.LocalDateTime;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Region region;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}