package com.realtime.entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realtime.entities.constants.AuthorizationGrantTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.io.Serial;
import java.io.Serializable;

/**
 * POJO CLASS HOLDS THE GRANTS AVAILABLE
 * SEE @AuthorizationGrantTypeEnum FOR THE
 * LIST OF AVAILABLE OPTIONS
 */
@Getter
@Setter
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrantType implements Serializable {

    @Serial
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private AuthorizationGrantTypeEnum value;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, targetEntity = Client.class, optional = false)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Client client;

}
