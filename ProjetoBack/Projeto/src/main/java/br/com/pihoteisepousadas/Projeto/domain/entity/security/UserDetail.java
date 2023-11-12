package br.com.pihoteisepousadas.Projeto.domain.entity.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetail implements UserDetails {
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private String nome;
     private String email;
     private String password;
     private UserPermission role;
     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(new SimpleGrantedAuthority(role.name()));
     }

     @Override
     public String getUsername() {
            return email;
        }

     @Override
     public boolean isAccountNonExpired() {
            return true;
        }

     @Override
     public boolean isAccountNonLocked() {
            return true;
        }

     @Override
     public boolean isCredentialsNonExpired() {
            return true;
        }

     @Override
     public boolean isEnabled() {
            return true;
        }
}
