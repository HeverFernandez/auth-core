package edu.epis.sisga.payload;

import edu.epis.sisga.entities.Menu;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Created by Aitamh on 19/08/17.
 */
public class JwtAuthenticationResponse {

    private Integer code;
    private String message;
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    private String usuario;
    private Long idusuario;
    private Boolean estado;
    private List<Menu> menus;

    public JwtAuthenticationResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public JwtAuthenticationResponse(Integer code, String message, String accessToken, String username, Collection<? extends GrantedAuthority> authorities,String usuario, Long idusuario, List<Menu> menus) {
        this.code = code;
        this.message = message;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.username = username;
        this.authorities = authorities;
        this.usuario = usuario;
        this.idusuario = idusuario;
        this.menus = menus;
    }

    public JwtAuthenticationResponse(Integer code, String message, String accessToken, String username, Collection<? extends GrantedAuthority> authorities,String usuario, Long idusuario, Boolean estado, List<Menu> menus) {
        this.code = code;
        this.message = message;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.username = username;
        this.authorities = authorities;
        this.usuario = usuario;
        this.idusuario = idusuario;
        this.estado = estado;
        this.menus = menus;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
