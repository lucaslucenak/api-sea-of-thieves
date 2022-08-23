package com.lucaslucena.apisot.models;

//import com.lucaslucena.apisot.enumns.RoleName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Table
@Entity(name = "tb_role")
@Getter
@Setter
public class RoleModel implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private String role_name;

    @Override
    public String getAuthority() {
        return role_name;
    }
}

